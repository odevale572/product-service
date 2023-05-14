pipeline {
   agent any
   stages {
    stage('Checkout') {
      steps {
        script {
           // The below will clone your repo and will be checked out to master branch by default.
           git branch: 'main', url: 'https://github.com/odevale572/product-service.git'
           // Do a ls -lart to view all the files are cloned. It will be clonned. This is just for you to be sure about it.
            
           
           // Checkout to a specific branch in your repo.
           bat "git checkout main"
          }
       }
    }
	
	stage('Build') {
      steps {
        script {
           bat "./mvnw clean install -DskipTests"
          }
       }
    }
    
    
    stage("Deployment") {
    steps {
        script {
          
	   bat './mvnw spring-boot:run -Dserver.port=8083 &'
          }
       }
      
    }
  }
}
