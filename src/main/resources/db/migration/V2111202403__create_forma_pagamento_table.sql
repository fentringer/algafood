
CREATE TABLE forma_pagamento (
    id  BIGINT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL
);

CREATE INDEX idx_forma_pagamento_descricao ON forma_pagamento(descricao);

CREATE SEQUENCE forma_pagamento_id_seq;
ALTER TABLE forma_pagamento ALTER COLUMN id SET DEFAULT nextval('forma_pagamento_id_seq');