DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100;

CREATE TABLE restaurants
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name   TEXT NOT NULL
);

CREATE TABLE dishes
(
  dishId       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  description TEXT NOT NULL,
  price        INTEGER NOT NULL,
  restId       INTEGER,
  FOREIGN KEY (restId) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE users (
  userId       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name         TEXT NOT NULL,
  restId       INTEGER,
  FOREIGN KEY (restId) REFERENCES restaurants (id) ON DELETE CASCADE
);