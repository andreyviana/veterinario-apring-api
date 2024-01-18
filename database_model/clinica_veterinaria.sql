CREATE DATABASE clinica_veterinaria;

USE clinica_veterinaria;

CREATE TABLE veterinarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome_veterinario VARCHAR(50) NOT NULL,
  especializacao VARCHAR(50) NOT NULL
);

CREATE TABLE animais (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_veterinario INT NOT NULL,
  animal VARCHAR(50) NOT NULL,
  nome_dono VARCHAR(50) NOT NULL,
  recebeu_alta BOOLEAN,
  diagnostico VARCHAR(255),
  FOREIGN KEY (id_veterinario) REFERENCES veterinarios (id)
);


INSERT INTO veterinarios (nome_veterinario, especializacao)
VALUES ('Andrey Viana', 'Animais de pequeno porte'),
  ('Yuri Silva', 'Equinos');

INSERT INTO animais (id_veterinario, animal, nome_dono, recebeu_alta, diagnostico)
VALUES (1, 'Gato', 'Eduardo Ribas', false, 'Infecção intestinal'),
  (2, 'Cavalo', 'Davi Benatti', true, 'Anemia infecciosa equina'),
  (1, 'Cachorro', 'Rafael Rosa', true, 'Sarna');

SELECT veterinarios.nome_veterinario, veterinarios.especializacao, animais.*
FROM animais
LEFT JOIN veterinarios
ON animais.id_veterinario = veterinarios.id;
