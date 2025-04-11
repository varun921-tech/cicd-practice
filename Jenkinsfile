pipeline{
  agent any
    triggers {
      pollSCM "* * * * * "
    }

  stages{
    stage('Stage 1') {
      steps{
        sh "echo stage 1"
      }
    }
    stage('Stage 2') {
      steps{
        sh "echo stage 2"
      }
    }
    stage('Stage 3') {
      steps{
        sh "echo stage 3"
      }
    }
  }
}
