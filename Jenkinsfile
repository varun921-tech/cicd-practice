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
                                               }
                                               }
