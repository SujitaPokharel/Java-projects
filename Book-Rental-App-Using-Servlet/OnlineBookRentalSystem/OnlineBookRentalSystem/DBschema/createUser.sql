CREATE USER 'bookDbUser'@'localhost' IDENTIFIED BY 'studentpswd';

GRANT ALL PRIVILEGES ON project_bookrentalsystem.* TO 'bookDbUser'@'localhost' WITH GRANT OPTION;

SHOW GRANTS FOR 'bookDbUser'@'localhost';