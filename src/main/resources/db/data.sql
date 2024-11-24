INSERT INTO pets (id, name)
VALUES (1, 'Bella'),
       (2, 'Max'),
       (3, 'Charlie'),
       (4, 'Luna'),
       (5, 'Oliver');

INSERT INTO clients (id, name, pet_id)
VALUES (1, 'John Doe', 1),      -- Клиент с именем John Doe и питомцем с id=1 (Bella)
       (2, 'Jane Smith', 2),    -- Клиент с именем Jane Smith и питомцем с id=2 (Max)
       (3, 'Alice Johnson', 3), -- Клиент с именем Alice Johnson и питомцем с id=3 (Charlie)
       (4, 'Bob Brown', 4),     -- Клиент с именем Bob Brown и питомцем с id=4 (Luna)
       (5, 'Cathy White', 5); -- Клиент с именем Cathy White и питомцем с id=5 (Oliver)

INSERT INTO visits (id, date, client_id, pet_id, comment)
VALUES (1, '2024-11-22 10:00:00', 1, 1, 'Regular check-up for Bella'), -- Визит клиента John Doe с питомцем Bella
       (2, '2024-11-22 11:30:00', 2, 2, 'Vaccination for Max'),        -- Визит клиента Jane Smith с питомцем Max
       (3, '2024-11-23 09:00:00', 3, 3,'Routine health check for Charlie'), -- Визит клиента Alice Johnson с питомцем Charlie
       (4, '2024-11-23 14:00:00', 4, 4, 'Check-up for Luna'),          -- Визит клиента Bob Brown с питомцем Luna
       (5, '2024-11-24 08:30:00', 5, 5, 'Dental cleaning for Oliver'); -- Визит клиента Cathy White с питомцем Oliver