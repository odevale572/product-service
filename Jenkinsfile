node {
  stage("Clone the project") {
    git branch: 'main', url: 'https://github.com/odevale572/product-service.git'
  }

  stage("Compilation") {
    sh "./mvnw clean install"
  }

  stage("Tests and Deployment") {
   
    stage("Deployment") {
      sh 'nohup ./mvnw spring-boot:run -Dserver.port=8001 &'
    }
  }
}
