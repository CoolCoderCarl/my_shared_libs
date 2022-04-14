def call() {

    node {
        try {
            stage('Test stage') {
                echo "${JOB_NAME}"
            }

            stage('Build downstreams jobs') {
              def ffj = build job: 'FirstFreestyleJob'
              def sfj = build job: 'SecondFreestyleJob'
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
            echo ffj.FFJ_VARNAME
//             echo "${ffj.FFJ_VARNAME}"
//             echo "${sfj.SFJ_VARNAME}"
        }
    }
}
