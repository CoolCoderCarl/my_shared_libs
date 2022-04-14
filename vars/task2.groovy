def call() {

    node {

        stage('Test stage') {
            echo '${JOB_NAME}'
        }

        stage('Build downstreams jobs') {
          build 'FirstFreestyleJob'
          build 'SecondFreestyleJob'
        }

        stage('Env Var One') {
            echo '${FIRST}'
        }

        stage('Env Var Two') {
            echo '${SECOND}'
        }

//         post {
//             always { 
//                 echo 'POST'
//             }
//         }
    }
}
