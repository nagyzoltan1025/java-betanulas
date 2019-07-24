DELIMITER $$
CREATE DEFINER=`user`@`pass` PROCEDURE `get_count_for_department`(IN the_department VARCHAR(64), OUT the_count INT)
BEGIN
	
	SELECT COUNT(*) INTO the_count FROM employees where department=the_department;

END$$
DELIMITER ;