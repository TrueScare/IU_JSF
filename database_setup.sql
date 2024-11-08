create database if not exists like_hero_to_zero;
use like_hero_to_zero;
CREATE TABLE `users` (
                         `id` integer PRIMARY KEY AUTO_INCREMENT,
                         `username` varchar(255) UNIQUE,
                         `password` varchar(255) COMMENT 'should be stored as hash',
                         `roles` varchar(255) COMMENT 'defined by an ENUM'
);

CREATE TABLE `dataset_entry` (
                                 `id` integer PRIMARY KEY AUTO_INCREMENT,
                                 `owner` integer,
                                 `country` varchar(255),
                                 `emissions` integer,
                                 `year` integer,
                                 `created_at` datetime,
                                 `last_update` datetime
);

CREATE TABLE `dataset_entry_change` (
                                        `id` integer PRIMARY KEY AUTO_INCREMENT,
                                        `author` integer,
                                        `dataset_entry` integer,
                                        `comment` varchar(255),
                                        `country` varchar(255),
                                        `emissions` integer,
                                        `year` integer,
                                        `created_at` datetime,
                                        `approved` bool
);

ALTER TABLE `dataset_entry` ADD FOREIGN KEY (`owner`) REFERENCES `users` (`id`);

ALTER TABLE `dataset_entry_change` ADD FOREIGN KEY (`author`) REFERENCES `users` (`id`);

ALTER TABLE `dataset_entry_change` ADD FOREIGN KEY (`dataset_entry`) REFERENCES `dataset_entry` (`id`);

insert into `users` (username, password, roles)
values ('admin','aQc2WAVEJJAGlgDYtTtmv5dGlM7azB9Wet1res1bppfwieU9AiYsJHFT0Hgu/JScUekpTP4gCzQhvnKSxjXGHw==','ADMINISTRATOR')