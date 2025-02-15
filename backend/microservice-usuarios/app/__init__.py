from flask import Flask
from app.config.settings import Config
from app.models import db
from app.routes.auth import auth_bp

def create_app():
    app = Flask(__name__)
    app.config.from_object(Config)

    db.init_app(app)
    app.register_blueprint(auth_bp, url_prefix='/auth')

    with app.app_context():
        db.create_all()

    return app
