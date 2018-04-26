create database customers;

use customers;

create table `customers`(
	`id` int primary key auto_increment,
    `name` nvarchar(200) not null,
    `email` nvarchar(200) not null,
    `address` nvarchar(200) not null
);
