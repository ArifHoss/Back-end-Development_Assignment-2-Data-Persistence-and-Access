INSERT INTO power (name, description)
VALUES
    ('Spider-Sense', 'Allows Spider-Man to sense danger'),
    ('Super Strength', 'Gives Superman extraordinary strength'),
    ('Batmobile', 'Allows Batman to travel quickly and evade enemies'),
    ('Web Slinging', 'Allows Spider-Man to swing through the city');

INSERT INTO superhero_power (superhero_id, power_id)
VALUES
    (1, 1),
    (3, 3),
    (1, 4),
    (1, 3),
    (2, 2),
    (3, 4);
