from flask import Flask, render_template, request, redirect , session # don't forget to import redirect!
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'


count = 0
@app.route('/')
def count_times():
    global count
    count = count +1
    return render_template("index.html" , count=count)

@app.route('/add', methods = ['POST'])
def add():
    print( "COUNTER = ")
    global count
    count=count+ 1
    print( count )
    return redirect('/')


@app.route('/reset', methods = ['POST'])
def reset():
    global count
    count = 0
    print( count )
    return redirect('/')



if __name__ == "__main__":
    app.run(debug=True)