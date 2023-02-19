CREATE TABLE IF NOT EXISTS superhero
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL ,
    alias VARCHAR(255) NOT NULL ,
    origin VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS assistant
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255),
    superhero_id INTEGER REFERENCES superhero(id)
);

CREATE TABLE IF NOT EXISTS power
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);



