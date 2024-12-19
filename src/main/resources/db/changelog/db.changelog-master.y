databaseChangeLog:
        xmlns: "http://www.liquibase.org/xml/ns/dbchangelog"
        xmlns:xsi: "http://www.w3.org/2001/XMLSchema-instance"
        xmlns:ext: "http://www.liquibase.org/xml/ns/dbchangelog-ext"
        xsi:schemaLocation:
                "http://www.liquibase.org/xml/ns/dbchangelog": "https://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.1.xsd"
                "http://www.liquibase.org/xml/ns/dbchangelog-ext": "https://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd"

                - include:
                          file: "/db/changelog/changeSets/create.table.sql"
                - include:
                          file: "/db/changelog/changeSets/v0.1/insert_clients.sql"
                - include:
                          file: "/db/changelog/changeSets/v0.1/insert_pets.sql"
                - include:
                          file: "/db/changelog/changeSets/v0.1/insert_visits.sql"