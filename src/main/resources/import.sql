INSERT INTO tb_client (name, cpf, address, phone) VALUES ('Amauri Ferreira', '123.456.789.00', 'Rua Brasil', '79999628750');
INSERT INTO tb_client (name, cpf, address, phone) VALUES ('Debora Pereira', '123.456.789.00', 'Rua Fernando collor', '79999628750');

INSERT INTO tb_supplier (name, cnpj, address, phone) VALUES ('Fasouto', '15.598.527/0008-03', 'Av. Simião Sobral', '(79) 2107-5454')
INSERT INTO tb_supplier (name, cnpj, address, phone) VALUES ('TechSol', '47.252.912/0001-50', 'Rua Paulo Falcão, 152', '(11) 3273-8920');
INSERT INTO tb_supplier (name, cnpj, address, phone) VALUES ('Comercial Guarujá', '32.458.781/0003-17', 'Avenida das Palmeiras, 2120', '(21) 3456-7789');


INSERT INTO tb_product (name, description, quantity, category, max_Stock, min_Stock) VALUES ('Galaxy M35', 'Smartphone Samsung vendido online', 3, 'Eletronicos', 10, 1);
INSERT INTO tb_product (name, description, quantity, category, max_Stock, min_Stock) VALUES ('iPhone 14', 'Smartphone Apple com câmera avançada', 5, 'Eletronicos', 15, 2);
INSERT INTO tb_product (name, description, quantity, category, max_Stock, min_Stock) VALUES ('Dell XPS 13', 'Notebook ultrafino com tela infinita', 8, 'Computadores', 20, 3);
INSERT INTO tb_product (name, description, quantity, category, max_Stock, min_Stock) VALUES ('Sony WH-1000XM4', 'Fone de ouvido com cancelamento de ruído', 12, 'Acessorios', 25, 5);


INSERT INTO tb_client_product (client_id, product_id) VALUES (1 , 4)
INSERT INTO tb_client_product (client_id, product_id) VALUES (2 , 1)
INSERT INTO tb_client_product (client_id, product_id) VALUES (2 , 3)
INSERT INTO tb_client_product (client_id, product_id) VALUES (2 , 2)
INSERT INTO tb_client_product (client_id, product_id) VALUES (1 , 1)
