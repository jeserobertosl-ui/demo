
INSERT INTO clients (client_name, client_address, age)
    VALUES ('Juan', 'C. ignacio 1300', 20);
INSERT INTO clients (client_name, client_address, age) 
    VALUES ('Pedro', 'C. santiago 150', 30);

INSERT INTO orders (id_client, purchase_date, id_item, delivery_date) 
    VALUES (1, '24/10/2025', 1, '26/10/2025');
INSERT INTO orders (id_client, purchase_date, id_item, delivery_date) 
    VALUES (2, '15/6/2020', 1, '27/10/2025');

INSERT INTO items (price, item_name, item_description) 
    VALUES (10.0, 'towel', 'white towel: 50cm x 180cm');
INSERT INTO items (price, item_name, item_description) 
    VALUES (25.0, 'grill', 'stainless steel: 60cm diameter');