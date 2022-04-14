def call() {

    node {
        try {
            stage('Test stage') {
                echo "${JOB_NAME}"
            }

            stage('Build downstreams jobs') {
              build 'FirstFreestyleJob'
              build 'SecondFreestyleJob'
            }

            stage('Env Var One') {
                echo "${FIRST}"
            }

            stage('Env Var Two') {
                echo "${SECOND}"
            }
        }
        catch (e) {
            echo "FAILURE !"
        }
        finally {
            echo "FINALLY !"
        }
    }
}
