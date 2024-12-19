-- liquibase formatted sql

-- changeset ng:insert_test_clients
INSERT INTO clients (id, name)
VALUES (1, 'John Doe1'),
       (2, 'Jane Smith'),
       (3, 'Alice Johnson'),
       (4, 'Bob Brown'),
       (5, 'Cathy White');