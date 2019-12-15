CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `experience` varchar(255) NOT NULL,
  `hobby` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


INSERT INTO `everybodycancode`.`user` (`username`, `name`, `experience`, `hobby`, `contact`, `password`) VALUES ('maryy', 'maria', 'pythonl', 'jardinagem', 'mary@email.com', 'maryy');
INSERT INTO `everybodycancode`.`user` (`username`, `name`, `experience`, `hobby`, `contact`, `password`) VALUES ('laryy', 'larissa', 'ruby, mysql', 'natação', 'lary@email.com', 'laryy');
INSERT INTO `everybodycancode`.`user` (`username`, `name`, `experience`, `hobby`, `contact`, `password`) VALUES ('jonyy', 'joão', 'node, mysql', 'games', 'joao@email.com', 'jonyy');