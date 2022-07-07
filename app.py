import os
from flask import Flask
app = Flask(__name__)

@app.route('/sqream')
def hello_geek():
    stream = os.popen('docker container ls')
    output = stream.read()
    return '<h1>see the list of running containers <br/></h2>' + '<br/>'+ output + '<br/>'

if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=5000)
