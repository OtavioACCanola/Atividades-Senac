CREATE DATABASE EComerce
USE EComerce

CREATE TABLE TBL_Clientes
(
	ID_Cliente INT IDENTITY PRIMARY KEY,
	CPF_Cliente CHAR(14),
	Nome VARCHAR(100),
	Data_Nascimento DATE
)

INSERT INTO TBL_Clientes VALUES
('123.456.789-00', 'Maria Silva', '1985-03-12'),
('987.654.321-11', 'João Pereira', '1990-07-25'),
('456.789.123-22', 'Ana Costa', '1978-12-05'),
('321.654.987-33', 'Carlos Souza', '2000-01-15'),
('159.753.486-44', 'Fernanda Lima', '1995-09-30'),
('753.951.852-55', 'Lucas Mendes', '1988-04-18'),
('852.456.159-66', 'Patrícia Rocha', '1993-11-22'),
('654.852.357-77', 'Ricardo Alves', '1975-06-10'),
('951.159.753-88', 'Juliana Martins', '1982-08-27'),
('357.654.852-99', 'Eduardo Ribeiro', '1998-02-14')

CREATE TABLE TBL_Pedidos
(
	ID_Pedido INT IDENTITY PRIMARY KEY,
	Data_Pedido DATE,
	ID_Cliente INT
	FOREIGN KEY (ID_Cliente) REFERENCES TBL_Clientes (ID_Cliente)
)

INSERT INTO TBL_Pedidos VALUES
('2025-01-05', 1),
('2025-01-06', 1),
('2025-01-07', 2),
('2025-01-08', 4),
('2025-01-09', 4),
('2025-01-10', 7),
('2025-01-11', 8),
('2025-01-12', 9),
('2025-01-13', 5),
('2025-01-14', 3);

CREATE TABLE TBL_Produtos
(
	ID_Produtos INT IDENTITY PRIMARY KEY,
	Nome VARCHAR (100),
	Preco DECIMAL (10,2)
)

INSERT INTO TBL_Produtos VALUES
('Camiseta', '49.90'),
('Calça Jeans', '129.90'),
('Tênis Esportivo', '199.90'),
('Boné', '39.90'),
('Jaqueta', '249.90'),
('Relógio', '299.90'),
('Óculos de Sol', '149.90'),
('Mochila', '89.90'),
('Carteira de Couro', '79.90'),
('Cinto', '59.90');

CREATE TABLE TBL_Pedidos_Produtos
(
	ID_PP INT IDENTITY PRIMARY KEY,
	ID_Pedido INT,
	ID_Produtos INT,
	Qnt_Produtos INT,
	FOREIGN KEY (ID_Pedido) REFERENCES TBL_Pedidos (ID_Pedido),
	FOREIGN KEY (ID_Produtos) REFERENCES TBL_Produtos (ID_Produtos)
)

INSERT INTO TBL_Pedidos_Produtos VALUES
(1,2,2),
(2,3,1),
(3,3,1),
(4,4,3),
(5,2,1),
(6,5,1),
(7,6,2),
(8,7,1),
(9,3,1),
(10,9,2);

SELECT * FROM TBL_Clientes 
SELECT* FROM TBL_Pedidos 
SELECT * FROM TBL_Pedidos_Produtos

