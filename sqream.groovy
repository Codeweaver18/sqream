
job('Docker Build') {
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
    docker login -u $dockerHubUsername -p $dockerHubPassword
    Docker image build -t flask_docker .
    Docker tag flask_docker  codeweaver/sqreamflaskapp:$BUILD_NUMBER
    Docker push codeweaver/sqreamflaskapp:$BUILD_NUMBER
     
    ''')
  }
}
job('Nginx reverse Proxy') {
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
    Cd Nginx
    docker build -t ngnxserver .
    Docker tag ngnxserver  codeweaver/sqreamnginx:latest
    docker login -u $dockerHubUsername -p $dockerHubPassword
    Docker push codeweaver/sqreamnginx:latest
    ''')
  }
}
job('Docker run containers') {
    steps {
    shell('''
    docker run -p 5000:5000 -d flask_docker
    docker run -p 80:80 -d ngnxserver
    ''')
  }
}
