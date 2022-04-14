def call() {
    node {
        
        stage ('JAVA Default'){
            echo "${env.JAVA_HOME}"
            sh "java -version"
        }
        
        stage ('JAVA 11'){
            env.JAVA_HOME="${tool 'jdk_11'}/jdk-11/bin"
            echo "${env.JAVA_HOME}"
            sh "${env.JAVA_HOME}/java -version"
        }
        
        stage ('JAVA 16') {
            env.JAVA_HOME="${tool 'jdk_16'}/jdk-16/bin"
            echo "${env.JAVA_HOME}"
            sh "${env.JAVA_HOME}/java -version"
        }
    }
}
