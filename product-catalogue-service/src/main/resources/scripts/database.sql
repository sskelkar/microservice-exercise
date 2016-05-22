CREATE TABLE product
(
  product_id NUMBER NOT NULL,
  name VARCHAR2(50),
  type VARCHAR2(30),
  CONSTRAINT pk_product PRIMARY KEY (product_id)
);

CREATE SEQUENCE seq_product START WITH 1;

CREATE OR REPLACE TRIGGER trg_product_bi
BEFORE INSERT ON product
FOR EACH ROW
BEGIN
  IF :NEW.product_id IS NULL THEN
    SELECT seq_product.NEXTVAL INTO :NEW.product_id FROM dual;
  END IF;
END;
/