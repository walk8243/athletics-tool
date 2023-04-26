CREATE TABLE `player_belong` (
	`id` int(11) AUTO_INCREMENT PRIMARY KEY,
	`name` varchar(255) NOT NULL,
	`delete_flag` boolean NOT NULL DEFAULT 0,
	`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
