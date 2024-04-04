USE bus_management_jdbc;

CREATE TABLE driver(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`code` VARCHAR(5) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    address VARCHAR(100),
    phone_number VARCHAR(15),
    qualification VARCHAR(5)
);

CREATE TABLE route(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`code` VARCHAR(3) NOT NULL,
    distance INT,
    number_of_stops INT
);

CREATE TABLE assigment(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    driver_id INT NOT NULL,
    route_id INT NOT NULL,
    `round` INT,
    FOREIGN KEY(driver_id) REFERENCES driver(id),
    FOREIGN KEY(route_id) REFERENCES route(id)
);
