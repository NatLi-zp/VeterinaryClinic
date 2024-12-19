-- liquibase formatted sql

-- changeset ng:visits
INSERT INTO visits (id, date, client_id, pet_id, comment)
VALUES (1, '2024-11-22 10:00:00', 1, 1, 'Regular check-up for Bella'),
       (2, '2024-11-22 11:30:00', 1, 2, 'Vaccination for Max'),
       (3, '2024-11-23 09:00:00', 3, 3,'Routine health check for Charlie'),
       (4, '2024-11-23 14:00:00', 4, 4, 'Check-up for Luna'),
       (5, '2024-11-24 08:30:00', 5, 5, 'Dental cleaning for Oliver');