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
    stage('Test') {
      steps{
        echo "Running Tests..."
        sh "mvn test"
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
        archiveArtifacts archive: 'target/*.war', fingerprint=true
      }
    }
  }
}
