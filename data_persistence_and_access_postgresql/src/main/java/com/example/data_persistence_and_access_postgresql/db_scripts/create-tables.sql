CREATE TABLE superhero
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL ,
    alias VARCHAR(255) NOT NULL ,
    origin VARCHAR(255) NOT NULL
);

CREATE TABLE assistant
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE power
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);
