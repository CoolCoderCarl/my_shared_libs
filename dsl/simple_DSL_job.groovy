mavenJob('DSL Tutorial') {
  
  description 'Test Tutorial DSL'

  logRotator {
    numToKeep 5
  }
  
  triggers {
    scm 'H */1 * * *'
  }

  rootPOM 'pom.xml'
}
