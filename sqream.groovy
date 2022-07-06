
job('Docker Build') {
    description("this job pulls repository from github")
    scm {
        git {
          remote {
            url('https://github.com/Codeweaver18/sqream.git')
          }
          branch('*/main')
        }
      }
    steps {
    shell('''
    echo "beginning docker build"
    ls 
    ''')
  }
}
