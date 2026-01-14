INSERT INTO customers (first_name, last_name, email) VALUES
                                                         ('Marcus', 'Rashford', 'mr2@email.com'),
                                                         ('Erling', 'Haaland', 'eh9@email.com'),
                                                         ('Pedri', 'González', 'pg8@email.com'),
                                                         ('Aitana', 'Bonmatí', 'ab14@email.com');

INSERT INTO incidencies (titol, descripcio, data_obertura, estat, customer_id)
VALUES
    ('Disc dur ple', 'El servidor mostra un avís d''espai insuficient a /var/log', CURRENT_TIMESTAMP, 'OBERT', 1),
    ('Wifi lenta', 'La connexió a la sala de reunions cau constantment.', CURRENT_TIMESTAMP, 'EN_PROGRES', 1),
    ('Pantalla blava', 'L''equip s''ha reiniciat sol després d''una actualització.', '2023-12-01 09:00:00', 'TANCAT', 3);