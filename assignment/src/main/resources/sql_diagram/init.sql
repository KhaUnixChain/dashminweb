CREATE DATABASE WebsellManager
GO

USE WebsellManager
GO

USE master
GO

DROP DATABASE WebsellManager
GO

--https://cloud.smartdraw.com/editor.aspx?credID=-38640967&depoId=34741739&flags=128#depoId=34741968&credID=-38640967


CREATE TABLE employees (
	[id] varchar(20) PRIMARY KEY NOT NULL,
	[name] nvarchar(50) NOT NULL,
	[gender] bit NOT NULL,
	[address] nvarchar(100) NOT NULL,
	[birth] date NOT NULL,
	[email] varchar(50) NOT NULL,
	[avartar] nvarchar(100)
)
GO

CREATE TABLE authorizers (
	[id_em] varchar(20) NOT NULL,
	[password] varchar(20) NOT NULL,
	[role] bit NOT NULL
)
GO

ALTER TABLE authorizers
ADD CONSTRAINT FK_id_emp_autho FOREIGN KEY ([id_em]) REFERENCES employees([id])

-- 
CREATE TABLE customers (
	[id] int identity(1,1) PRIMARY KEY,
	[name] nvarchar(50) NOT NULL,
	[email] varchar(50) NOT NULL,
	[phone] varchar(15) NOT NULL
)
GO


--
CREATE TABLE products (
	[id] varchar(20) PRIMARY KEY NOT NULL,
	[type] nvarchar(20) NOT NULL,
	[name] nvarchar(50) NOT NULL,
	[price] money NOT NULL,
	[maintenance] smallint NOT NULL,
	[image] nvarchar(50),
	[note] varchar(150)
)
GO


--
CREATE TABLE invoices (
	[id] int identity(1,1) PRIMARY KEY,
	[id_cu] int NOT NULL,
	[id_em] varchar(20),
	[purchaseDate] date NOT NULL,
	[cost] money NOT NULL
)
GO

ALTER TABLE invoices
ADD CONSTRAINT FK_id_cu_in FOREIGN KEY ([id_cu]) REFERENCES customers([id])

ALTER TABLE invoices
ADD CONSTRAINT FK_id_em_in FOREIGN KEY ([id_em]) REFERENCES employees([id])


CREATE TABLE invoice_details (
	[id] int identity(1,1) PRIMARY KEY,
	[id_in] int NOT NULL,
	[id_pr] varchar(20) NOT NULL,
	[number_buy] int NOT NULL,
	[note] nvarchar(150)
)
GO

ALTER TABLE invoice_details
ADD CONSTRAINT FK_id_detail_pr FOREIGN KEY ([id_pr]) REFERENCES products([id])

ALTER TABLE invoice_details
ADD CONSTRAINT FK_id_detail_invc FOREIGN KEY ([id_in]) REFERENCES invoices([id])


