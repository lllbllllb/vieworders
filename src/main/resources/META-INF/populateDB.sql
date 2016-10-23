DELETE FROM products;
DELETE FROM orders;

INSERT INTO orders (id, name, address, amount, registered) VALUES ('1000', 'Pashkouski', 'Belarus', '2500', '2015-06-30 10:01:00'), ('1001', 'Smith', 'USA', '800', '2015-07-15 10:11:00'), ('1002', 'Chan', 'China', '300', '2016-10-27 10:11:12');

INSERT INTO products (id, serialNumber, description, quantity, order_id) VALUES ('1001', 'drone SN', 'drone', '2', '1000'), ('1002', 'vrbox SN', 'VRBox', '1', '1000'), ('1003', 'phone SH', 'Meizu', '2', '1000'), ('1004', 'tv SN', 'TV', '1', '1001'), ('1005', 'phone SN', 'Motorola', '1', '1001'), ('1006', 'printer SN', 'Prusia 3D', '1', '1001'), ('1007', 'p', 'first product', '2', '1001'), ('1008', 'phone SN', 'Xiaomi', '1', '1002'), ('1009', 'airpurifier SN', 'Air Purifier', '2', '1002');