DELETE FROM dishes;
DELETE FROM users;
DELETE FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 100;

INSERT INTO restaurants (name) VALUES
  ('Агава'),
  ('Бурбон'),
  ('Скоморохи');

INSERT INTO dishes (description, price, restId) VALUES
  ('Пиво', '100', '100'),
  ('Салат Цезарь', '120', '100'),
  ('Лапша', '140', '101'),
  ('Шашлык', '160', '101'),
  ('Плов', '80', '101'),
  ('Уха', '40', '101'),
  ('Вино', '60', '102'),
  ('Манка', '1', '102'),
  ('Гречка', '99', '102');

INSERT INTO users (name, restId) VALUES
  ('Андрей', '100'),
  ('Юля', '101'),
  ('Златан', '102');


