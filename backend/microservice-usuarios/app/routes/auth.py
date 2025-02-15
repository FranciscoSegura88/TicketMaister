from flask import Blueprint, request, jsonify
from app.models import db
from app.models.user import User
from flask_bcrypt import Bcrypt
from flask_jwt_extended import create_access_token, JWTManager
import datetime

bcrypt = Bcrypt()
jwt = JWTManager()

auth_bp = Blueprint('auth', __name__)

@auth_bp.route('/register', methods=['POST'])
def register():
    data = request.get_json()
    if User.query.filter_by(email=data['email']).first():
        return jsonify({'message': 'Usuario ya registrado'}), 400
    hashed_password = bcrypt.generate_password_hash(data['password']).decode('utf-8')
    new_user = User(email=data['email'], password=hashed_password, role='user', created_at=datetime.datetime.now())
    db.session.add(new_user)
    db.session.commit()
    return jsonify({'message': 'Usuario registrado exitosamente'}), 201

@auth_bp.route('/login', methods=['POST'])
def login():
    data = request.get_json()
    user = User.query.filter_by(email=data['email']).first()
    if not user or not bcrypt.check_password_hash(user.password, data['password']):
        return jsonify({'message': 'Usuario o contraseña incorrectos'}), 401
    access_token = create_access_token(identity=user.id)
    return jsonify(access_token=access_token), 200
