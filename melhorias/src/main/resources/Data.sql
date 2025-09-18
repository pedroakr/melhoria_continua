-- Este script insere um usuário padrão para testes
-- A senha é 'senha123', criptografada com BCrypt
INSERT INTO tb_usuarios (nome, usuario, email, senha_hash, perfil)
VALUES ('Usuário de Teste', 'tester', 'teste@cottonstar.com', '$2a$10$3g5vJ5.ASn0g.1g1aX867.y3.Ld353wSME92APpP2M/A1D5b/K4.q', 'COLABORADOR');