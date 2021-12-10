drop table if exists `country` CASCADE;
create table `country`(`id` integer PRIMARY KEY AUTO_INCREMENT, 
`name` varchar(255) not null, 
`population` integer, 
`location` varchar(255), 
`size` integer);
