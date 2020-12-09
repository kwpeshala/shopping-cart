CREATE TABLE product
(
  product_id   INT(5),
  product_name VARCHAR(100),
  primary key (product_id)
);

CREATE TABLE carton
(
  carton_id        INT(1),
  carton_price     DOUBLE(10, 4),
  product_id       INT(5),
  units_per_carton INT(11),
  PRIMARY KEY (carton_id, product_id),
  FOREIGN KEY (product_id) REFERENCES product (product_id)
);