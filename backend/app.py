from flask import Flask, request, jsonify, make_response, render_template, session
import jwt
from datetime import datetime, timedelta
from functools import wraps
import database
app = Flask(__name__)
#uuid.uuid4().hex


def token_required(func):
    
    @wraps(func)
    def decorated(*args, **kwargs):
        token = request.args.get('token')
        if not token:
            return jsonify({'Alert!':'Token is missing'})
        try:
            payload = jwt.decode(token, app.config['SECRET_KEY'])
        except:
            return jsonify({'Alert!':'Invalid Token'})
    return decorated

def check_info(func):
    @wraps(func)
    def infoCheck(*args,**kwargs):
        username = request.args.get('username')
        password = request.args.get('password')
        
        print(username)
        print(password)
        if password == None or username == None:
            return jsonify({'status':'username or password not provided'})
        if database.doesAccountExist(username):
            return jsonify({'status':'Username already taken'})


        database.storeAccount(username,password)
        return jsonify({'status':'stored'})
    return infoCheck

def check_creds(func):
    @wraps(func)
    def credsCheck(*args,**kwards):
        username = request.args.get('username')
        password = request.args.get('password')
        if not database.verifyCreds(username,password):
            return jsonify({'status':'false'})
        return jsonify({'status':"true"})
    return credsCheck

@app.route('/createAccount')
@check_info
def accountCreation():
    pass

@app.route('/login')
@check_creds
def verify():
    pass

@app.route('/')
def home():
    if not session.get('logged_in'):
        return render_template('login.html')
    else:
        return 'yo'

@app.route('/public')
def public():
    return 'For Public'

@app.route('/auth')
@token_required
def auth():
    return 'JWT is verified. Welcome to your dashboard' 

# @app.route("/login", methods=['POST'])
# def login():
#     if request.form['username'] and request.form['password'] =='admin':
#         session['logged_in'] = True
#         token = jwt.encode({
#             'user': request.form['username'],
#             'exp': str(datetime.utcnow() + timedelta(seconds=120))
#         },
#             app.config['SECRET_KEY'])
#         return jsonify({'token': token})
#     else:
#         return make_response('Unable to verify',403,{'WWW-Authenticate':'Basic Realm:"Authentication Failed!"'})

# @app.route("/logout",methods=['POST'])    
# def logout():
#     if session['logged_in'] != True: return
#     session['logged_in'] = False
#     return 'You have logged out'


if __name__ == "__main__":
    app.run(debug=True)
