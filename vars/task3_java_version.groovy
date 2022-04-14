def call() {
    echo "${env.JAVA_HOME}"
    sh "java -version"
    
    env.JAVA_HOME="${tool 'jdk_11'}/jdk-11/bin/"
    echo "${env.JAVA_HOME}"
    sh "${env.JAVA_HOME}/java -version"
    
    env.JAVA_HOME="${tool 'jdk_16'}/jdk-16/bin/"
    echo "${env.JAVA_HOME}"
    sh "${env.JAVA_HOME}/java -version"
}
