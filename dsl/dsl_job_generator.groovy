def lst = [1, 2, 3, 4, 5]

lst.each { 
  
  job_num = it
  job_name = "Maven job number ${job_num}"

  mavenJob(job_name) {
    
    description "Test Tutorial DSL ${job_num}"
    

    scm {
      git {
        remote {
          url('https://github.com/CoolCoderCarl/mySharedLibs.git')
          credentials('mySharedLibs_TOKEN') 
        }
        branch('*/main')
      }
    }
    
  
    logRotator {
      numToKeep 5
    }
    
    triggers {
      scm 'H */1 * * *'
    }
  
    rootPOM 'pom.xml'
  }

}
