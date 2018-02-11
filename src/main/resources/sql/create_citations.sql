CREATE TABLE IF NOT EXISTS `quotes_table` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `original_text` text,
 `quote_text` text,
 `author` text,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;