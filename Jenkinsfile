pipeline{
  agent any
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
    stage('Run tests in parallel') {
      parallel{
        stage('Smoke Tests'){
          steps{
            echo "Running Smoke Tests..."
              sh "mvn test -Dtest=SmokeTest"
          }
        }
        stage('Regression Tests'){
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
    stage('Deploy to Tomcat'){
      steps{
        echo "Deploying..."
        deploy adapters: [tomcat9(credentialsId: 'tomcat_deployer', path: '', url: 'http://ec2-13-49-70-227.eu-north-1.compute.amazonaws.com:8080/')], contextPath: null, war: 'target/*.war'
      }
    }
  }                                          
}
                                               
                                               
