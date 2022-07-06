pipelineJob('Sqream Assesment') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/Codeweaver18/sqream.git')
          }
          branch('*/main')
        }
      }
      lightweight()
    }
  }
  job('Docker Build') {
  steps {
    shell('echo Hello World!')
  }
}
}