CREATE TABLE price
(
  price_id NUMBER NOT NULL,
  product_id NUMBER,
  value NUMBER,
  CONSTRAINT pk_price PRIMARY KEY (price_id)
);

CREATE SEQUENCE seq_price START WITH 1;

CREATE OR REPLACE TRIGGER trg_price_bi
BEFORE INSERT ON price
FOR EACH ROW
BEGIN
  IF :NEW.price_id IS NULL THEN
    SELECT seq_price.NEXTVAL INTO :NEW.price_id FROM dual;
  END IF;
END;
/