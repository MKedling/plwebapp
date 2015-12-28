CREATE TABLE users (id INTEGER PRIMARY KEY, username VARCHAR(255), password VARCHAR(255));

INSERT INTO users (id,username,password) VALUES(1,'kalle', 'psw');


CREATE TABLE sampledata (id INTEGER PRIMARY KEY, sampledata VARCHAR(255));

INSERT INTO sampledata (id,sampledata) VALUES(1,'world');


CREATE TABLE products (
	id INTEGER primary key,
	p_name VARCHAR(255),
	description VARCHAR(255),
	p_image VARCHAR(255),
	price DECIMAL
);

INSERT INTO products (id,p_name,description,p_image, price) VALUES (1,'Buffalo Wings',          'Säsongens Smak, GULDFÅGELN 500g pås ', 'wings.jpg',       35);
INSERT INTO products (id,p_name,description,p_image, price) VALUES (2,'Bitter Lemon Läsk',      'SCHWEPPES 1.5l/pet',                   'bitterlemon.jpg', 20);
INSERT INTO products (id,p_name,description,p_image, price) VALUES (3,'Hallon&blåbär Djupfryst','GARANT 225g kps',                      'hallon.jpg',      19.95);
INSERT INTO products (id,p_name,description,p_image, price) VALUES (4,'Kroketter Potatis',      'FELIX 800g pås',                       'kroketter.jpg',   26);
INSERT INTO products (id,p_name,description,p_image, price) VALUES (5,'Ishavsräkor Djupfryst',  'GARANT 300g pås',                      'rakor.jpg',       80.54);
INSERT INTO products (id,p_name,description,p_image, price) VALUES (6,'Phish Food Glass',       'BEN & JERRYS 0.5l bäg',                'phish.jpg',       50);
