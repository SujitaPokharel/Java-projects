CREATE USER 'cuslookup_user'@'localhost' IDENTIFIED BY 'coursedb_pswd';

GRANT ALL PRIVILEGES ON customer_lookup.* TO 'cuslookup_user'@'localhost' WITH GRANT OPTION;

SHOW GRANTS FOR 'cuslookup_user'@'localhost';

create Table Customer(firstName varchar(15) Not Null, lastName varchar(20) Not Null, phoneNum varchar(10) Not Null);

select * from customer;