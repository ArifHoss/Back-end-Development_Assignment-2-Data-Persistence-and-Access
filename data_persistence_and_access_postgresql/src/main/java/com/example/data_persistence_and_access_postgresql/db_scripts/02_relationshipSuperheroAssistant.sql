ALTER TABLE assistant
    ADD COLUMN superhero_id INTEGER REFERENCES superhero (id);

ALTER TABLE superhero
    ADD COLUMN assistant_id INTEGER REFERENCES assistant (id);
