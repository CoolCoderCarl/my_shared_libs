def call() {

    node {

        stage('Test stage') {
            echo "${JOB_NAME}"
        }

        stage('Build downstreams jobs') {
          build 'FirstFreestyleJob'
          build 'SecondFreestyleJob'
        }

        stage('Build downstreams jobs') {
          echo 'Env var 1'
        }

        stage('Build downstreams jobs') {
          echo 'Env var 2'
        }

        post {
            always { 
                echo 'POST'
            }
        }
    }
}
