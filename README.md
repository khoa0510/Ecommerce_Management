# Ecommerce Management Project
Simple API With topic E-Commerce Management
1. [Init Data](#init-data)
    1. [Schema](#schema)
    2. [Data](#data)
2. [APIs](#apis)
    1. [Get Product](#get-product)
    2. [Add Items to Cart](#add-items-to-cart)
    3. [Get Items from Cart](#get-items-from-cart)
## Init Data
This project uses H2 database
### Schema
```sql
CREATE TABLE CART
(
    CART_ID INT NOT NULL PRIMARY KEY
);

CREATE TABLE PRODUCT
(
    PRODUCT_ID INT NOT NULL PRIMARY KEY,
    NAME_PRODUCT VARCHAR(100) NOT NULL,
    TYPE CHAR(3),
    SIZE CHAR(3),
    PRICE DECIMAL NOT NULL
);

CREATE TABLE CUSTOMER
(
    CUSTOMER_ID INT NOT NULL PRIMARY KEY,
    CUSTOMER_NAME NVARCHAR(50) NOT NULL,
    ADDRESS NVARCHAR(100),
    PHONE_NO CHAR(20) NOT NULL,
    CART_ID INT,
    FOREIGN KEY (CART_ID) REFERENCES CART(CART_ID)
);

CREATE TABLE CART_ITEM
(
    CART_ID INT NOT NULL,
    PRODUCT_ID INT NOT NULL,
    QUANTITY_WISHED INT NOT NULL,
    DATE_ADDED DATE NOT NULL,
    TOTAL_AMOUNT DECIMAL NOT NULL,
    FOREIGN KEY (CART_ID) REFERENCES CART(CART_ID),
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID),
    PRIMARY KEY (CART_ID, PRODUCT_ID)
);
```
### Data
```sql
INSERT INTO CART VALUES ( 1 );
INSERT INTO CART VALUES ( 2 );
INSERT INTO CART VALUES ( 3 );
INSERT INTO CART VALUES ( 4 );
INSERT INTO CART VALUES ( 5 );

INSERT INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, PHONE_NO, CART_ID) VALUES (1, 'Nguyễn Văn A', 'TP.HCM', '0123456789', 1);
INSERT INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, PHONE_NO, CART_ID) VALUES (2, 'Trần Văn B', 'Hà Nội', '0987654321', 2);
INSERT INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, PHONE_NO, CART_ID) VALUES (3, 'Lê Thị C', 'Nghệ An', '0789123456', 3);
INSERT INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, PHONE_NO, CART_ID) VALUES (4, 'Hồ Quang D', 'Nam Định', '0369258147', 4);
INSERT INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, PHONE_NO, CART_ID) VALUES (5, 'Võ Hồng E', 'Cà Mau', '0159372468', 5);

INSERT INTO PRODUCT VALUES ( 1, 'Áo Marvel', 'Nam', 'L', 100000 );
INSERT INTO PRODUCT VALUES ( 2, 'Áo Marvel', 'Nam', 'XL', 110000 );
INSERT INTO PRODUCT VALUES ( 3, 'Áo Marvel', 'Nam', 'XXL', 125000 );
INSERT INTO PRODUCT VALUES ( 4, 'Chân váy đen', 'Nữ', 'M', 150000 );
INSERT INTO PRODUCT VALUES ( 5, 'Chân váy đen', 'Nữ', 'L', 170000 );
INSERT INTO PRODUCT VALUES ( 6, 'Đầm đen dài', 'Nữ', 'M', 200000 );
INSERT INTO PRODUCT VALUES ( 7, 'Đầm đen dài', 'Nữ', 'L', 230000 );
INSERT INTO PRODUCT VALUES ( 8, 'Đầm đen dài', 'Nữ', 'XL', 250000 );
INSERT INTO PRODUCT VALUES ( 9, 'Quần Jean xanh', 'Nam', '40', 210000 );
INSERT INTO PRODUCT VALUES ( 10, 'Quần Jean xanh', 'Nam', '45', 240000 );
```
## APIs
### Get Product
- Endpoint: `GET /product`
- Parameter:
  - price: BigDecimal
  - condition: in [LESS_THAN, GREATER_THAN, EQUAL]
#### Example
- Request: `GET /product?price=200000&condition=LESS_THAN`
- Response:
  ```json
  [
    {
      "product_id": 1,
      "name_product": "Áo Marvel",
      "type": "Nam",
      "size": "L  ",
      "price": 100000
    },
    {
      "product_id": 2,
      "name_product": "Áo Marvel",
      "type": "Nam",
      "size": "XL ",
      "price": 110000
    },
    {
      "product_id": 3,
      "name_product": "Áo Marvel",
      "type": "Nam",
      "size": "XXL",
      "price": 125000
    },
    {
      "product_id": 4,
      "name_product": "Chân váy đen",
      "type": "Nữ ",
      "size": "M  ",
      "price": 150000
    },
    {
      "product_id": 5,
      "name_product": "Chân váy đen",
      "type": "Nữ ",
      "size": "L  ",
      "price": 170000
    }
  ]
  ```
### Add Items to Cart
- Endpoint: `POST customer/{customerId}/cart`
#### Example
- Request: `POST /customer/1/cart`
```json
[
	{
		"productId":1,
		"quantity":3
	},
	{
		"productId":3,
		"quantity":2
	}
]
```
- Response: Nobody
- Database:

CART_ID | PRODUCT_ID | QUANTITY_WISHED | DATE_ADDED | TOTAL_AMOUNT
------- | ---------- | --------------- | ---------- | ------------
1       | 1          | 3               | 2022-08-31 | 300000        
1       | 3          | 2               | 2022-08-31 | 250000
### Get Items from Cart
- Endpoint: `GET customer/{customerId}/cart`
- Parameter:
  - name_product: String
  - offset: Integer
  - limit: Integer
#### Example
- Request: `GET /customer/1/cart?name_product=Áo Marvel&offset=1&limit=100`
- Response:
  ```json
  [
    {
      "cart_id": 1,
      "product_id": 3,
      "quantity_wished": 2,
      "date_added": "2022-08-30T17:00:00.000+00:00",
      "total_amount": 250000
	  }
  ]
  ```
