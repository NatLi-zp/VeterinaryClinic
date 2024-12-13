drop table if exists visits;
drop table if exists pets;
drop table if exists clients;

CREATE TABLE clients
(
    id     INT PRIMARY KEY AUTO_INCREMENT,      -- Поле для идентификатора клиента
    name   VARCHAR(64)               -- NOT NULL Поле для имени клиента
    -- pet_id INT,                   -- Внешний ключ для связи с питомцем
    -- FOREIGN KEY (pet_id) REFERENCES pets (id) -- Связь с таблицей Pet
);

CREATE TABLE pets
(
    id        INT PRIMARY KEY AUTO_INCREMENT,                      -- Поле для идентификатора питомца
    name      VARCHAR(64),                 -- NOT NULL Поле для имени питомца
    client_id INT,                                  -- Внешний ключ для связи с клиентом
    FOREIGN KEY (client_id) REFERENCES clients (id) -- Связь с таблицей Client
);

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

