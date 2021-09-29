/*primeiro vou criar o database do prrojeto integrador grupo 5 */
CREATE DATABASE db_rede_social_empowerenergy;
USE db_rede_social_empowerenergy;

/*agora vou criar 3 tabelas do database tb_postagem, tb_tema e tb_usuario*/
CREATE TABLE tb_usuario(
id_usuario BIGINT NOT NULL AUTO_INCREMENT,
nome_usuario VARCHAR (255) NOT NULL,
sobrenome_usuario VARCHAR(255) NOT NULL,
idade_usuario INT NOT NULL,
email_usuario VARCHAR (255) NOT NULL UNIQUE,
senha_usuario VARCHAR(255) NOT NULL,
PRIMARY KEY (id_usuario)
);

CREATE TABLE tb_tema(
id_tema BIGINT NOT NULL AUTO_INCREMENT,
eolica_tema VARCHAR (255) NOT NULL,
hidrica_tema VARCHAR (255) NOT NULL, 
biomassa_tema VARCHAR (255) NOT NULL,
solar_tema VARCHAR (255) NOT NULL,
PRIMARY KEY  (id_tema)
);

CREATE TABLE tb_postagem(
id_postagem BIGINT NOT NULL AUTO_INCREMENT,
imagem_postagem VARCHAR (255) NOT NULL,
mencao_postagem VARCHAR(255) NOT NULL,
hashtag_postagem VARCHAR(255) NOT NULL,
localizacao_postagem VARCHAR(255)NOT NULL,
fk_id_usuario BIGINT NOT NULL,
fk_id_tema BIGINT NOT NULL,
PRIMARY KEY (id_postagem),
FOREIGN KEY (fk_id_usuario) REFERENCES tb_usuario (id_usuario),
FOREIGN KEY (fk_id_tema) REFERENCES tb_tema (id_tema)
);
