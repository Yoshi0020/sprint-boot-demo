CREATE TABLE demo.purchase_history(
    id serial NOT NULL,
    purchase_at date,
	seq integer,
	customer_id integer,
	item_id integer,
	number integer,
	payment integer,
	PRIMARY KEY(id)
);