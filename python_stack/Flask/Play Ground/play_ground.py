from flask import Flask, render_template
app = Flask(__name__)

# Level 1
@app.route('/play')
def play_3():
    return render_template('code.html', times=3)

# Level 2
@app.route('/play/<number>')
def play_number(number):
    number = int(number)
    return render_template("code.html", times=number)

# Level 3
@app.route('/play/<number>/<color>')
def play_color(number, color):
    number = int(number)
    return render_template("code.html", times=number, color=color)

if __name__=="__main__":
    app.run(debug=True)