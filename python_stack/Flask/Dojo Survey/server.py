from flask import Flask, render_template, request, redirect # added request
app = Flask(__name__)
# our index route will handle rendering our form
@app.route('/')
def index():
    return render_template("code.html")

@app.route('/users', methods=['POST'])
def create_user():
#     print("Got Post Info")
#     print(request.form)
    name_from_form = request.form['name']
    location_from_form = request.form['location']
    language_from_form = request.form['language']
    message_from_form = request.form['message']
    return render_template("show.html", name_on_template=name_from_form, location_on_template=location_from_form, language_on_template=language_from_form, message_on_template=message_from_form)


if __name__ == "__main__":
    app.run(debug=True)
            