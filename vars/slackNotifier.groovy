#!/usr/bin/env groovy

def call(String buildResult) {
  if (buildResult == "SUCCESS") {
    slackSend (color: "good", message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
  }
  else if (buildResult == "FAILURE") {
    slackSend (color: "danger", message: "failed: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")  
  }
  else if (buildResult == "UNSTABLE") {
    slackSend (color: "warning", message: "unstable: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")  
  }
  else {
    slackSend (color: "danger", message: "unclear: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})") 
  }
}
