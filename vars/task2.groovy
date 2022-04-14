def call() {

    node {
        try {
            stage('Test stage') {
                echo "${JOB_NAME}"
            }

            stage('Build downstreams jobs') {
              def ffj = build 'FirstFreestyleJob'
              def sfj = build 'SecondFreestyleJob'
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
            echo "${currentBuild.currentResult}"
            echo "${ffj.currentResult}"
            echo "${sfj.currentResult}"
        }
    }
}
