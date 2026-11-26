DROP TABLE IF EXISTS Role;

CREATE TABLE Role (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(25) NOT NULL
);

INSERT INTO Role (name) VALUES ('ADMIN'),('USER'),('ACCOUNTANT');

DROP TABLE IF EXISTS Internal_user;

CREATE TABLE Internal_user (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	firstname VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	role_id INT NOT NULL,
	FOREIGN KEY (role_id) REFERENCES Role(id)
);

INSERT INTO Internal_user (name,firstname,email,password,role_id) VALUES 
	(
		'Dorange',
		'Cecile',
		'dorange.cecile@coworkia.fr',
		'admin',
		1
	),
	(
		'Chiffres',
		'Terry',
		'chiffres.terry@coworkia.fr',
		'compta',
		3
	),
	(	'Inette',
		'Bob',
		'bob.inette@iscod.fr',
		'user',
		2
	);
	
DROP TABLE IF EXISTS Site;


CREATE TABLE Site (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL
);


INSERT INTO Site (name) VALUES ('République');

DROP TABLE IF EXISTS Zone;

CREATE TABLE Zone (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(12) NOT NULL,
	acronyme VARCHAR(3) NOT NULL,
	site_id INT NOT NULL,
	FOREIGN KEY (site_id) REFERENCES Site(id)
);

INSERT INTO Zone (name, acronyme,site_id) VALUES 
	('Atlas','AT1',1),('Boréal','BO1',1),('Calypso','CA1',1),('Delta','DE1',1),('Echo','EC1',1),('Fjord','FJ1',1),('Gaia','GA1',1),('Hélios','HE1',1);
	
DROP TABLE IF EXISTS Post;

CREATE TABLE Post (
	id INT AUTO_INCREMENT PRIMARY KEY,
	code VARCHAR(12) NOT NULL,
	zone_id INT NOT NULL,
	FOREIGN KEY (zone_id) REFERENCES Zone(id)
);

DROP TABLE IF EXISTS Reservation;

CREATE TABLE Reservation (
	id INT AUTO_INCREMENT PRIMARY KEY,
	starting_date TIMESTAMP NOT NULL,
	ending_date TIMESTAMP NOT NULL,
	reserved_on DATE NOT NULL,
	internal_user_id INT NOT NULL,
	post_id INT NOT NULL,
	FOREIGN KEY (internal_user_id) REFERENCES Internal_user(id) ,
	FOREIGN KEY (post_id) REFERENCES Post(id) 
);