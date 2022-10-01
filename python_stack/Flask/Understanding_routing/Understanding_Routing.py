from flask import Flask  
app = Flask(__name__)


@app.route('/')          
def hello_world():
    return 'Hello World!'  

@app.route('/dojo')          
def hello_world1():
    return 'Dojo!'   

@app.route('/say/<name>')          
def hello_world2(name):
    print(name)
    return "Hi " + name 

@app.route('/repeat/<int:number>/<text>')
def repeat(text,number):
    return (text*number)

if __name__=="__main__":
    app.run(debug=True)    
