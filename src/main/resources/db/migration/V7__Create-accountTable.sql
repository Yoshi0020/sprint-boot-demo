CREATE TABLE demo.accounts(
	id serial NOT NULL,
	name varchar(30),
	password varchar(60),
	email varchar(256) UNIQUE,
    role varchar(4),
	PRIMARY KEY (id)
);