DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `users` (
    `id` int(4) NOT NULL AUTO_INCREMENT,
    `login` varchar(60) NOT NULL,
    `password` varchar(10) NOT NULL,
    `role` varchar(15) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `dreams` (
  `id` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `content` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tasks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `content` VARCHAR(100) NOT NULL,
  `priority` INT NULL,
  `repeatability` INT NULL,
  `time_limits` DATETIME(6) NULL,
  `done` TINYINT(1) NULL,
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `purposes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `content` VARCHAR(100) NOT NULL,
  `priority` INT NULL,
  `repeatability` INT NULL,
  `time_limits` DATETIME(6) NULL,
  `done` TINYINT(1) NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `task_date` (
  `task_id` INT NOT NULL,
  `task_date` DATE NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `task_date` (
  `task_id` INT NOT NULL,
  `task_day` VARCHAR(9) NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `task_when` (
  `task_id` INT NOT NULL,
  `date` DATE NULL,
  `day` VARCHAR(9) NULL,
  `time` TIME(5) NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

