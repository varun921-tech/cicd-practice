pipeline{
  agent {label 'master'}
    triggers {
      pollSCM "* * * * * "
    }

  tools {
    maven 'mymaven'
  }

  stages{
    stage('Build') {
      steps{
        echo "Building..."
          sh "mvn clean compile -DskipTests"
      }
    }
    stage('Email Status'){
      steps{
        echo "Sending Email..."
        emailext body: 'Build is successful', subject: 'Build Status Message', to: 'varungarg63683@gmail.com'
      }
    }
    stage('Run tests in parallel') {
      parallel{
        stage('Smoke Tests on master'){
          agent {label 'master'}
          steps{
            echo "Running Smoke Tests..."
              sh "mvn test -Dtest=SmokeTest"
          }
        }
        stage('Regression Tests on node1'){
          agent {label 'node1'}
          steps{
            echo "Running Regression Tests..."
              sh "mvn test -Dtest=RegressionTest"
          }
        }

      }
    }
    stage('Package') {
      steps{
        echo "Packaging..."
          sh "mvn package -DskipTests"
      }
    }
    stage('Archive Artifacts') {
      steps{
        echo "Archiving..."
          archiveArtifacts artifacts: 'target/*.jar', fingerprint:true
      }
    }
    stage('Sending Email Notification'){
      steps{
        echo "Sending an email..."
        emailext body: 'This is a demo for extended email notification', subject: 'This is the pipeline status email', to: 'varungarg63683@gmail.com'
      }
    }
    // stage('Deploy to Tomcat'){
    //   steps{
    //     echo "Deploying..."
    //     deploy adapters: [tomcat9(credentialsId: 'tomcat_deployer', path: '', url: 'http://ec2-13-49-70-227.eu-north-1.compute.amazonaws.com:8080/')], contextPath: null, war: 'target/*.jar'
    //   }
    // }
  }                                          
}
                                               
                                               
