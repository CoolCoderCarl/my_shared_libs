def call() {

    node {
        try {
            stage('Test stage') {
                echo "${JOB_NAME}"
            }

            stage('Build downstreams jobs') {
              ffj = build job: 'FirstFreestyleJob'
              def sfj = build job: 'SecondFreestyleJob'
            }

            stage('Env Var One') {
                echo "${FIRST}"
                echo ffj.getBuildVariables().FFJ_VARNAME                
            }

            stage('Env Var Two') {
                echo "${SECOND}"
                echo sfj.getBuildVariables().SFJ_VARNAME                      
            }
        }
        catch (e) {
            echo "FAILURE !"
        }
        finally {
            echo "FINALLY !"
            echo "${currentBuild.currentResult}"      
//             echo "${ffj.FFJ_VARNAME}"
//             echo "${sfj.SFJ_VARNAME}"
        }
    }
}
