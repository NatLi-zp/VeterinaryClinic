-- liquibase formatted sql

-- changeset ng:insert_test_pets
INSERT INTO pets (id, name, client_id)
VALUES (1, 'Bella1',1),
       (2, 'Max1',1),
       (3, 'Charlie',3),
       (4, 'Luna',4),
       (5, 'Oliver',5);