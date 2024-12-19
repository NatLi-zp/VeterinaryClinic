-- liquibase formatted sql

-- changeset ng:clients
CREATE TABLE clients
(
    id     INT PRIMARY KEY AUTO_INCREMENT,      -- Поле для идентификатора клиента
    name   VARCHAR(64)               -- NOT NULL Поле для имени клиента
);

-- changeset ng:pets
CREATE TABLE pets
(
    id        INT PRIMARY KEY AUTO_INCREMENT,                      -- Поле для идентификатора питомца
    name      VARCHAR(64),                 -- NOT NULL Поле для имени питомца
    client_id INT,                                  -- Внешний ключ для связи с клиентом
    FOREIGN KEY (client_id) REFERENCES clients (id) -- Связь с таблицей Client
);

-- changeset ng:visits
CREATE TABLE visits
(
    id        INT PRIMARY KEY AUTO_INCREMENT,                       -- Поле для идентификатора визита
    date      TIMESTAMP,                    -- NOT NULL Поле для даты визита
    client_id INT,                                   -- Внешний ключ для связи с клиентом
    pet_id    INT,                                   -- Внешний ключ для связи с питомцем
    comment   VARCHAR(255),                          -- Поле для комментария
    FOREIGN KEY (client_id) REFERENCES clients (id), -- Связь с таблицей Client
    FOREIGN KEY (pet_id) REFERENCES pets (id)        -- Связь с таблицей Pet
);



-- changeset ng:IndexClientsFk
CREATE INDEX FK_PETS_CLIENTID_IDX ON Pets(id);

-- changeset ng:REFERENCES_Pets_Clients
ALTER TABLE Pets ADD CONSTRAINT FK_PETS_CLIENTID_REFERENCES FOREIGN KEY (id) REFERENCES clients (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

