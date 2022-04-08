def job = hudson.model.Hudson.instance.getJob("DSL Tutorial")

build = job.scheduleBuild2(5, new hudson.model.Cause.UserIdCause())

build.get() 
