pipeline {
    agent any
    stages {
        stage('myStage'){
            node('maven') {
                steps {
                    sh 'ls -la' 
                }
            }
        }
        stage('Build') {
            steps { 
                sh 'ls' 
            }
        }
    }
}
