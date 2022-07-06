
job('Docker Build') {

    def BUILD_NUMBER = getBinding().getVariables()['BUILD_NUMBER']
    def username = getBinding().getVariables()['dockerHubUsername']
    def password = getBinding().getVariables()['dockerHubPassword']

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

    docker login -u $username -p $password
    Docker image build -t flask_docker .
    Docker tag flask_docker  codeweaver/sqreamflaskapp:$BUILD_NUMBER
    Docker push codeweaver/sqreamflaskapp:$BUILD_NUMBER
     
    ''')
  }
}
