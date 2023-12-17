
CREATE DATABASE Pet;
USE Pet;
show tables;

CREATE TABLE Shelters (
    s_id INT PRIMARY KEY,
    s_name VARCHAR(255)
);


CREATE TABLE Pets (
    p_id INT PRIMARY KEY,
    p_name VARCHAR(255),
    p_age INT,
    p_breed VARCHAR(255),
    s_id INT,
    FOREIGN KEY (s_id) REFERENCES Shelters(s_id)
);


CREATE TABLE Pet_Dog (
    p_id INT PRIMARY KEY,
    dog_breed VARCHAR(255),
    FOREIGN KEY (p_id) REFERENCES Pets(p_id)
);


CREATE TABLE Pet_Cat (
    p_id INT PRIMARY KEY,
    cat_color VARCHAR(255),
    FOREIGN KEY (p_id) REFERENCES Pets(p_id)
);


CREATE TABLE Donation (
    d_id INT PRIMARY KEY,
    d_donarName VARCHAR(255),
    d_type VARCHAR(255),
    d_date DATE
);


CREATE TABLE Donation_Cash (
    d_id INT PRIMARY KEY,
    d_amount INT,
    FOREIGN KEY (d_id) REFERENCES Donation(d_id)
);


CREATE TABLE Donation_Item (
    d_id INT PRIMARY KEY,
    d_item VARCHAR(255),
    d_quantity INT,
    FOREIGN KEY (d_id) REFERENCES Donation(d_id)
);


CREATE TABLE Adoption (
    a_id INT PRIMARY KEY,
    a_date DATE,
    a_status VARCHAR(255),
    p_id INT,
    FOREIGN KEY (p_id) REFERENCES Pets(p_id)
);
show tables;

INSERT INTO Shelters (s_id, s_name) VALUES
(1, 'Happy Paws Shelter'),
(2, 'Safe Haven Shelter');

-- Insert data into Pets Table
INSERT INTO Pets (p_id, p_name, p_age, p_breed, s_id) VALUES
(1, 'Buddy', 3, 'Labrador Retriever', 1),
(2, 'Whiskers', 2, 'Siamese', 2),
(3, 'Max', 4, 'German Shepherd', 1);


INSERT INTO Pet_Dog (p_id, dog_breed) VALUES
(1, 'Labrador Retriever'),
(3, 'German Shepherd');


INSERT INTO Pet_Cat (p_id, cat_color) VALUES
(2, 'Cream and Brown');

INSERT INTO Donation (d_id, d_donarName, d_type, d_date) VALUES
(1, 'John Doe', 'Cash', '2023-01-15'),
(2, 'Jane Smith', 'Item', '2023-02-20');


INSERT INTO Donation_Cash (d_id, d_amount) VALUES
(1, 100),
(2, 50);

-- Insert data into Donation_Item Table
INSERT INTO Donation_Item (d_id, d_item, d_quantity) VALUES
(2, 'Pet Food', 20);

-- Insert data into Adoption Table
INSERT INTO Adoption (a_id, a_date, a_status, p_id) VALUES
(1, '2023-03-01', 'Approved', 1),
(2, '2023-04-10', 'Pending', 2);

CREATE TABLE adoption_events (
    event_id INT PRIMARY KEY,
    event_date DATE,
    event_name VARCHAR(255)
);
CREATE TABLE participants (
    participant_id INT PRIMARY KEY,
    event_id INT,
    participant_name VARCHAR(255),
    FOREIGN KEY (event_id) REFERENCES adoption_events(event_id)
);
INSERT INTO adoption_events (event_id, event_date, event_name) VALUES
(1, '2023-12-01', 'Pet Adoption Day'),
(2, '2023-12-15', 'Furry Friends Fair');
INSERT INTO participants (participant_id, event_id, participant_name) VALUES
(1, 1, 'John Doe'),
(2, 1, 'Jane Smith'),
(3, 2, 'Alice Johnson'),
(4, 2, 'Bob Williams');


USE Pet;
show tables;
describe pets;
select * from pets;
select * from adoption;
select * from donation;
select * from donation_cash;
select * from donation_item;
select * from pet_cat;
select *  from shelters;
select *  from participants;
select *  from adoption_events;
SHOW GRANTS FOR 'root'@'localhost';
