CREATE TABLE demo.customer	(
	id serial NOT NULL,
	name varchar(30),
	password varchar(60),
	email varchar(256) UNIQUE,
	PRIMARY KEY (id)
);