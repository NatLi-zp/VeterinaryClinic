
INSERT INTO clients (id, name)
VALUES (1, 'John Doe'),      -- Клиент с именем John Doe и питомцем с id=1 (Bella)
       (2, 'Jane Smith'),    -- Клиент с именем Jane Smith и питомцем с id=2 (Max)
       (3, 'Alice Johnson'), -- Клиент с именем Alice Johnson и питомцем с id=3 (Charlie)
       (4, 'Bob Brown'),     -- Клиент с именем Bob Brown и питомцем с id=4 (Luna)
       (5, 'Cathy White'); -- Клиент с именем Cathy White и питомцем с id=5 (Oliver)

INSERT INTO pets (id, name, client_id)
VALUES (1, 'Bella',1),
       (2, 'Max',1),
       (3, 'Charlie',3),
       (4, 'Luna',4),
       (5, 'Oliver',5);

INSERT INTO visits (id, date, client_id, pet_id, comment)
VALUES (1, '2024-11-22 10:00:00', 1, 1, 'Regular check-up for Bella'), -- Визит клиента John Doe с питомцем Bella
       (2, '2024-11-22 11:30:00', 1, 2, 'Vaccination for Max'),        -- Визит клиента Jane Smith с питомцем Max
       (3, '2024-11-23 09:00:00', 3, 3,'Routine health check for Charlie'), -- Визит клиента Alice Johnson с питомцем Charlie
       (4, '2024-11-23 14:00:00', 4, 4, 'Check-up for Luna'),          -- Визит клиента Bob Brown с питомцем Luna
       (5, '2024-11-24 08:30:00', 5, 5, 'Dental cleaning for Oliver'); -- Визит клиента Cathy White с питомцем Oliver