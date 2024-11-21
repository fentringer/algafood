
CREATE TABLE cozinha (
    id  BIGINT PRIMARY KEY ,
    nome VARCHAR(255) NOT NULL
);

CREATE INDEX idx_cozinha_nome ON cozinha(nome);

CREATE SEQUENCE cozinha_id_seq;
ALTER TABLE cozinha ALTER COLUMN id SET DEFAULT nextval('cozinha_id_seq');

