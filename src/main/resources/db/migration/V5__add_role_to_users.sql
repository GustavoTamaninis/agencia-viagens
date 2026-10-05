ALTER TABLE users
    ADD COLUMN role varchar(20) NOT NULL DEFAULT 'USER';

-- Senha em texto puro: admin123 (hash bcrypt abaixo)
INSERT INTO users (username, email, password, role)
VALUES ('admin', 'admin@agenciaviagens.com', '$2a$10$fN.hKYJU1V6y.hniyb6VEO/hiqQ7WiCM51U3xSBvYBF2N0TEXdfAu', 'ADMIN');
