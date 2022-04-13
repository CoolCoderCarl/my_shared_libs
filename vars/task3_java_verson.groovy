def call() {
  env.JAVA_HOME="${tool 'jdk_11'}"
  env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"
  sh 'java -version'
}
