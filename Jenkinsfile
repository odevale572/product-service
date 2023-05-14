pipeline {
   agent any
   stages {
      
      stage("Clone the project") {
    git branch: 'main', url: 'https://github.com/odevale572/product-service.git'
  }

  stage("Compilation") {
    sh "./mvnw clean install -DskipTests"
  }

 
    /*stage('Checkout') {
      steps {
        script {
           // The below will clone your repo and will be checked out to master branch by default.
           git credentialsId: 'product-service-cred', url: 'https://github.com/odevale572/product-service.git'
           // Do a ls -lart to view all the files are cloned. It will be clonned. This is just for you to be sure about it.
           sh "ls -lart ./*" 
           // List all branches in your repo. 
           sh "git branch -a"
           // Checkout to a specific branch in your repo.
           sh "git checkout main"
          }
       }
    }*/
  }
}
