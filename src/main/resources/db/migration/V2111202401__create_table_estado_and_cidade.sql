
CREATE TABLE IF NOT EXISTS estado (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS cidade (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    estado_id BIGINT NOT NULL,
    CONSTRAINT fk_estado
        FOREIGN KEY (estado_id)
        REFERENCES estado(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_estado_id ON cidade (estado_id);

CREATE SEQUENCE estado_id_seq;
ALTER TABLE estado ALTER COLUMN id SET DEFAULT nextval('estado_id_seq');


CREATE SEQUENCE cidade_id_seq;
ALTER TABLE cidade ALTER COLUMN id SET DEFAULT nextval('cidade_id_seq'::regclass);


