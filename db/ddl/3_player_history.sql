CREATE TABLE `player_history` (
	`id` int(11) AUTO_INCREMENT PRIMARY KEY,
	`player_id` int(11) NOT NULL,
	`history` int(11) NOT NULL DEFAULT 1,
	`belong_id` int(11) DEFAULT NULL,
	`name` varchar(255) NOT NULL,
	`kana` varchar(255) DEFAULT NULL,
	`prefecture` enum('hokkaido', 'saitama', 'tokyo') NOT NULL,
	`year` int(11) NOT NULL,
	`category` enum('senior', 'ordinary', 'college', 'high-school', 'junior', 'elementary') NOT NULL,
	`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT `player_history_uk` UNIQUE KEY (`player_id`, `history`),
	CONSTRAINT `player_history_player_fk` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`) ON DELETE CASCADE,
	CONSTRAINT `player_belong_fk` FOREIGN KEY (`belong_id`) REFERENCES `player_belong` (`id`) ON DELETE RESTRICT
);
