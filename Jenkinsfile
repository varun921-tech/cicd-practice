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
    // stage('Deploy to Tomcat'){
    //   steps{
    //     echo "Deploying..."
    //     deploy adapters: [tomcat9(credentialsId: 'tomcat_deployer', path: '', url: 'http://ec2-13-49-70-227.eu-north-1.compute.amazonaws.com:8080/')], contextPath: null, war: 'target/*.jar'
    //   }
    // }
  }                                          
  
  post {
    success {
      emailext (
        subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
        body: """<p>BUILD SUCCESS:</p>
        <p>Job: '${env.JOB_NAME} [${env.BUILD_NUMBER}]'</p>
        <p>Check console output at <a href='${env.BUILD_URL}'>${env.BUILD_URL}</a></p>
        """,
        mimeType: 'text/html',
        to: 'varungarg63683@gmail.com'
      )
    }
  }
}
                                               
                                               
