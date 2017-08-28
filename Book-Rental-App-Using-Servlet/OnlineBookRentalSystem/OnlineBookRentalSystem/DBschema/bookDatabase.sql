CREATE SCHEMA `project_bookrentalsystem` ;
USE project_bookrentalsystem;

CREATE TABLE `project_bookrentalsystem`.`book` (
  `book_id` INT NOT NULL,
  `book_name` VARCHAR(45) NOT NULL,
  `course_id` VARCHAR(45) NOT NULL,
  `book_count` INT ZEROFILL NOT NULL,
  PRIMARY KEY (`book_id`));
 
INSERT INTO `project_bookrentalsystem`.`book` (`book_id`, `book_name`, `course_id`, `book_count`) VALUES ('101', 'Advanced Internet Programming', 'cs532', '5');
INSERT INTO `project_bookrentalsystem`.`book` (`book_id`, `book_name`, `course_id`, `book_count`) VALUES ('102', 'Advanced Algorithm Design', 'cs501', '0');
INSERT INTO `project_bookrentalsystem`.`book` (`book_id`, `book_name`, `course_id`, `book_count`) VALUES ('103', 'Basic Java', 'cs480', '5');
INSERT INTO `project_bookrentalsystem`.`book` (`book_id`, `book_name`, `course_id`, `book_count`) VALUES ('104', 'Basic Networking', 'cs470', '2');
INSERT INTO `project_bookrentalsystem`.`book` (`book_id`, `book_name`, `course_id`, `book_count`) VALUES ('105', 'Introduction to Database', 'cs457', '7');
INSERT INTO `project_bookrentalsystem`.`book` (`book_id`, `book_name`, `course_id`, `book_count`) VALUES ('106', 'Linux for Beginners', 'cs230', '10');
INSERT INTO `project_bookrentalsystem`.`book` (`book_id`, `book_name`, `course_id`, `book_count`) VALUES ('107', 'Introduction to Operating Systems', 'cs380', '5');


 CREATE TABLE `project_bookrentalsystem`.`author` (
  `book_id` INT NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `book_id_UNIQUE` (`book_id` ASC),
  CONSTRAINT `fk_bookid` FOREIGN KEY (`book_id`)REFERENCES
  `project_bookrentalsystem`.`book` (`book_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `project_bookrentalsystem`.`author` (`book_id`, `firstname`, `lastname`) VALUES ('101', 'Daniel', 'Liang');
INSERT INTO `project_bookrentalsystem`.`author` (`book_id`, `firstname`, `lastname`) VALUES ('102', 'Clifford', 'Stein');
INSERT INTO `project_bookrentalsystem`.`author` (`book_id`, `firstname`, `lastname`) VALUES ('103', 'Daniel', 'Liang');
INSERT INTO `project_bookrentalsystem`.`author` (`book_id`, `firstname`, `lastname`) VALUES ('104', 'James', 'Kuross');
INSERT INTO `project_bookrentalsystem`.`author` (`book_id`, `firstname`, `lastname`) VALUES ('105', 'Jason', 'Price');
INSERT INTO `project_bookrentalsystem`.`author` (`book_id`, `firstname`, `lastname`) VALUES ('106', 'John', 'Muster');
INSERT INTO `project_bookrentalsystem`.`author` (`book_id`, `firstname`, `lastname`) VALUES ('107', 'Abaraham', 'Silberschatz');

  
  
  






