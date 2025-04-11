pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git(url: 'https://github.com/varun921-tech/cicd-practice.git', branch: 'dev', credentialsId: 'githubCredentialsId')
      }
    }

    stage('Build') {
      steps {
        withMaven(maven: 'maven3.6.3') {
          sh 'mvn compile'
        }

      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Package') {
      steps {
        sh 'mvn package'
        archiveArtifacts '**/*.war'
      }
    }

  }
}