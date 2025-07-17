-- Создание таблицы клиентов
CREATE TABLE clients (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         email VARCHAR(100) UNIQUE,
                         phone VARCHAR(20)
);

-- Создание таблицы заказов
CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        created_at TIMESTAMP NOT NULL,
                        status VARCHAR(50),
                        client_id BIGINT,
                        CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES clients(id)
);
