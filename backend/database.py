import mysql.connector
import datetime
import hashlib


mycursor = mydb.cursor()

def doesAccountExist(username):
    mycursor.execute("SELECT _id FROM accounts WHERE _username = %(username)s", {'username': username})
    result = mycursor.fetchone()
    if result != None:
        return True

def storeAccount(username_uncrypted, password_uncrypted):
    username, password = username_uncrypted, hashlib.sha256(password_uncrypted.encode()).hexdigest()
    print(password)
    time = datetime.datetime.now()
    sql = "INSERT INTO accounts (_username,_password,_dateCreated) VALUES (%s,%s,%s)"
    val = (username, password, time)
    mycursor.execute(sql,val)
    mydb.commit()

def verifyCreds(username_uncrypted, password_uncrypted):
    username, password = username_uncrypted, hashlib.sha256(password_uncrypted.encode()).hexdigest()
    print(password)
    mycursor.execute("SELECT _password FROM accounts WHERE _username = %(username)s", {'username':username})
    result = mycursor.fetchone()
    print(result)
    if result == None:
        return False
    if result[0] != password:
        return False
    return True