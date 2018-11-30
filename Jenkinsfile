pipeline {
    agent any
    stages {
        stage('myStage'){
                steps {
                    sh 'ls -la' 
                    node('maven') {
                        sh '''
                        mvn --version

                        mvn package 
                        '''         
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
