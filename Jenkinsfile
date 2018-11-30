pipeline {
    agent any
    stages {
        stage('myStage'){
                steps {
                    sh 'ls -la' 
                    node('maven') {
                        sh 'mvn --version'         
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
