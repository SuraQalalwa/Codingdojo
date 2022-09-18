from flask import Flask, render_template
app = Flask(__name__)

# 1.http://localhost:5000 - should display 8 by 8 checkerboard
@app.route('/')
def check():
    return render_template("codeme.html") 


#2.http://localhost:5000 - should display 8 by 8 checkerboard

@app.route('/<rows>')
def checker(rows):
    return render_template("index.html", rows=int(rows))    



#3. http://localhost:5000/(x)/(y) - should display x by y checkerboard
@app.route('/<rows>/<columns>/<color1>/<color2>')
def checkers(rows,columns,color1,color2):
    return render_template("code.html", rows=int(rows), col=int(columns),colora=color1,colorb=color2)


if (__name__)=="__main__":
    app.run(debug=True)