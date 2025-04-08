CREATE TABLE items (
    item_id VARCHAR(15) PRIMARY KEY,
    item_des VARCHAR(20),
    unit_price DECIMAL(10,2)
);

INSERT INTO items (item_id, item_des, unit_price)
VALUES ('01', 'Coocoo Cola', 50.00);
INSERT INTO items (item_id, item_des, unit_price)
VALUES ('02', 'Gardenya', 25.00);
INSERT INTO items (item_id, item_des, unit_price)
VALUES ('03', 'Stick U', 60.00);

CREATE TABLE customers (
    customer_id VARCHAR(15) PRIMARY KEY,
    customer VARCHAR(30),
    address VARCHAR(20),
    contact_number VARCHAR(15)
);

INSERT INTO customers (customer_id, customer, address, contact_number)
VALUES ('C1', 'J. dela Cruz', 'Tagaytay', '09191112223');
INSERT INTO customers (customer_id, customer, address, contact_number)
VALUES ('C2', 'A. Kechum', 'Silang', '09991119219');
INSERT INTO customers (customer_id, customer, address, contact_number)
VALUES ('C3', 'G. Viscon', 'Alfonso', NULL);

CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY,
    item_id VARCHAR(15),
    customer_id VARCHAR(15),
    qty INT,
    trans_date DATE,
    FOREIGN KEY (item_id) REFERENCES items(item_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);


INSERT INTO transactions (transaction_id, item_id, customer_id, qty, trans_date)
VALUES (1, '01', 'C1', 2, DATE '2024-04-11');
INSERT INTO transactions (transaction_id, item_id, customer_id, qty, trans_date)
VALUES (2, '02', 'C1', 2, DATE '2024-04-11');
INSERT INTO transactions (transaction_id, item_id, customer_id, qty, trans_date)
VALUES (3, '01', 'C2', 1, DATE '2024-04-11');
INSERT INTO transactions (transaction_id, item_id, customer_id, qty, trans_date)
VALUES (4, '02', 'C3', 3, DATE '2024-04-12');
INSERT INTO transactions (transaction_id, item_id, customer_id, qty, trans_date)
VALUES (5, '03', 'C1', 1, DATE '2024-04-12');