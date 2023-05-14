node {
  stage("Clone the project") {
    git branch: 'main', url: 'https://github.com/odevale572/product-service.git'
  }

  stage("Compilation") {
    sh "mvn clean install"
  }

}
