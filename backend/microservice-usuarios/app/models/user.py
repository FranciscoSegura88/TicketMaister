import datetime
from sqlalchemy import Enum
from app.models import db

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    email = db.Column(db.String(120), unique=True, nullable=False)
    password = db.Column(db.String(120), nullable=False)
    role = db.Column(Enum('admin', 'user', name='role_type'), nullable=False)
    created_at = db.Column(db.DateTime, default=datetime.datetime.now)
