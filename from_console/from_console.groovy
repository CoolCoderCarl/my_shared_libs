import hudson.tasks.Shell;
import jenkins.model.Jenkins;
import hudson.model.FreeStyleProject;

job = Jenkins.instance.createProject(FreeStyleProject, 'jobFromScriptConsole')

job.buildersList.add(new Shell('echo This Job Created From Script Console'))

job.addTrigger(new hudson.triggers.TimerTrigger("H */1 * * *"))

job.save()

build = job.scheduleBuild2(5, new hudson.model.Cause.UserIdCause())

build.get() 

generatedJobs = build.getAction(javaposse.jobdsl.plugin.actions.GeneratedJobsBuildAction).getItems()

generatedJobs.each { j -> j.scheduleBuild2(5, new hudson.model.Cause.UserIdCause()) }
