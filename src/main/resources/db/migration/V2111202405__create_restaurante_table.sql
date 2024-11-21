
CREATE TABLE restaurante (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    taxa_frete DECIMAL(10, 2) NOT NULL,
    cozinha_id BIGINT NOT NULL,
    FOREIGN KEY (cozinha_id) REFERENCES cozinha(id)
);

CREATE INDEX idx_restaurante_cozinha ON restaurante(cozinha_id);

CREATE SEQUENCE restaurante_id_seq;
ALTER TABLE restaurante ALTER COLUMN id SET DEFAULT nextval('restaurante_id_seq');
