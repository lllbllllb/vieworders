DELETE FROM products;
DELETE FROM orders;

INSERT INTO orders (id, name, address, amount, registered) VALUES ('1000', 'Smith', 'USA', '2000', '2015-05-30 10:00:00');

INSERT INTO products (id, serialNumber, description, quantity) VALUES ('1000', 'thisSNproduct', 'first product', '2');