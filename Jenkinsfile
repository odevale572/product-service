pipeline {
   agent any
   stages {
    stage('Checkout') {
      steps {
        script {
           // The below will clone your repo and will be checked out to master branch by default.
           git credentialsId: 'product-service-cred', url: 'https://github.com/odevale572/product-service.git'
           
           sh "git checkout main"
          }
       }
    }
      
      stage('Build') {
      steps {
        script {
           sh "./mvnw clean install -DskipTests"
          }
       }
    }
  }
}
