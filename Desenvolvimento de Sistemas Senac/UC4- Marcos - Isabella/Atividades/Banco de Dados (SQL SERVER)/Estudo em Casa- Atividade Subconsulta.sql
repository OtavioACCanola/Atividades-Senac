CREATE DATABASE TreinoSubconsulta
USE TreinoSubconsulta

CREATE TABLE Clientes (
    id_cliente INT PRIMARY KEY,
    nome NVARCHAR(100),
    cidade NVARCHAR(100)
);

CREATE TABLE Pedidos (
    id_pedido INT PRIMARY KEY,
    id_cliente INT FOREIGN KEY REFERENCES Clientes(id_cliente),
    data_pedido DATE,
    valor_total DECIMAL(10,2)
);

CREATE TABLE Produtos (
    id_produto INT PRIMARY KEY,
    nome NVARCHAR(100),
    preco DECIMAL(10,2)
);

CREATE TABLE Itens_Pedido (
    id_pedido INT FOREIGN KEY REFERENCES Pedidos(id_pedido),
    id_produto INT FOREIGN KEY REFERENCES Produtos(id_produto),
    quantidade INT,
    PRIMARY KEY (id_pedido, id_produto)
);

INSERT INTO Clientes VALUES
(1, 'Ana', 'São Paulo'),
(2, 'Carlos', 'Rio de Janeiro'),
(3, 'Mariana', 'Belo Horizonte');

INSERT INTO Pedidos VALUES
(101, 1, '2025-08-01', 500.00),
(102, 2, '2025-08-05', 1200.00),
(103, 1, '2025-08-10', 300.00),
(104, 3, '2025-08-12', 150.00);

INSERT INTO Produtos VALUES
(201, 'Notebook', 2500.00),
(202, 'Mouse', 50.00),
(203, 'Teclado', 120.00),
(204, 'Monitor', 800.00);

INSERT INTO Itens_Pedido VALUES
(101, 202, 2),   -- 2 Mouses
(101, 203, 1),   -- 1 Teclado
(102, 201, 1),   -- 1 Notebook
(102, 204, 2),   -- 2 Monitores
(103, 202, 1),   -- 1 Mouse
(104, 203, 1);   -- 1 Teclado

SELECT c.nome FROM Clientes c
WHERE id_cliente IN
	(SELECT id_cliente FROM Pedidos p
	 WHERE c.id_cliente = p.id_cliente)

, ==ppppp----009989çççççl.l.l.l.l.