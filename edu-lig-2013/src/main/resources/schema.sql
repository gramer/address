CREATE SEQUENCE ADDRESS_SEQ AS INTEGER
    START WITH 0 INCREMENT BY 1;

CREATE TABLE ADDRESS (
	id varchar(100),
	CellPhoneNumber varchar(100),
	name varchar(100),
	email varchar(100),
	birthday varchar(100)
);