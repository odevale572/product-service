package com.estore.product.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.estore.product.entity.Product;
import com.estore.product.repository.ProductRepository;
import com.estore.product.util.ProductUtils;

@Service
public class ProductService {

	@Autowired
	ProductRepository repo;

	public List<Product> findAll() {

		List<Product> list = repo.findAll();
		
		list.stream().filter(catelog -> (catelog.getFileName()!=null && catelog.getImage()!=null)).forEach(catelog -> catelog.setImage(decompressBytes(catelog.getImage())));
		
		return repo.findAll();
	}

	public Product findById(long id) {

		return repo.findByProductId(id);
	}

	public Product registerProduct(Product product) {

		product.setProductId(ProductUtils.getRandomNumber());
		Product product2 = repo.save(product);
		return product2;
	}
	
	public Product uploadImage(int id, MultipartFile file)
	{

		Product product = repo.findById(id);
		
		try {
			product.setImage(compressBytes(file.getBytes()));
		} catch (IOException e) {
			System.out.println("Exception-" +e);
			e.printStackTrace();
		}
		
		product.setFileName(file.getName());
		product.setContentType(file.getContentType());
		
		repo.save(product);
		return product;
	}

	public Product updateProduct(Product order) {

		Product order2 = repo.save(order);
		return order2;
	}

	/**
	 * Compress and store data in database
	 * @param data
	 * @return
	 */
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}

	/**
	 * Decompress data from database and retrieve
	 * @param data
	 * @return
	 */
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

}
