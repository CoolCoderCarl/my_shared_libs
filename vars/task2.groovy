def call() {

    node {
        try {
            stage('Show current job name') {
                echo "Current job name - ${JOB_NAME}"
            }

            stage('Build FirstFreestyleJob job') {
              ffj = build job: 'FirstFreestyleJob'
            }

            stage('Build SecondFreestyleJob job') {
              sfj = build job: 'SecondFreestyleJob'
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
            echo "Current job status is ${currentBuild.currentResult}"      
            echo "Job ${ffj.getBuildVariables().JOB_NAME} status is ${ffj.currentResult}"
            echo "Job ${sfj.getBuildVariables().JOB_NAME} status is ${sfj.currentResult}"
        }
    }
}
