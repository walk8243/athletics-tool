CREATE TABLE `athelete` (
	`id` int(11) AUTO_INCREMENT PRIMARY KEY,
	`name` varchar(255) NOT NULL,
	`kana` varchar(255) DEFAULT NULL,
	`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
