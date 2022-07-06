import subprocess
from subprocess import Popen, PIPE
from subprocess import check_output
from flask import Flask
app = Flask(__name__)

@app.route('/')
def hello_geek():
    stdout = check_output(['./docker.sh']).decode('utf-8')
    return '<h1>see the list of running containers <br/></h2>' + '<br/>'+ stdout + '<br/>'

if __name__ == "__main__":
    app.run(port=5000, threaded=True, host=('0.0.0.0'))