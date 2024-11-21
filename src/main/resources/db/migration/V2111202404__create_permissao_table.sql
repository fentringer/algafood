
CREATE TABLE permissao (
    id  BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL
);

CREATE INDEX idx_permissao_nome ON permissao(nome);

CREATE SEQUENCE permissao_id_seq;
ALTER TABLE permissao ALTER COLUMN id SET DEFAULT nextval('permissao_id_seq');
