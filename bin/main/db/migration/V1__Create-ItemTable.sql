CREATE TABLE demo.item
(
  id serial NOT NULL,
  name varchar(255),
  capacity integer,
  price integer,
  calorie integer,
  url text,
  PRIMARY KEY (id)
);