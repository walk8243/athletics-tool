CREATE TABLE `player` (
	`id` int(11) AUTO_INCREMENT PRIMARY KEY,
	`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
