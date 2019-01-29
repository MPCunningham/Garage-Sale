DROP DATABASE IF EXISTS GarageSales;

create database GarageSales;

use GarageSales;

create table RoleTable(
RoleID int not null auto_increment,
primary key(RoleID),
Role varChar(30)
);

Create table UserTable(
UserID int not null auto_increment,
primary key(UserID),
ContactName varChar(30),
PhoneNumber varChar(10),
Email varChar(30),
UserName varchar (30) not null,
UserPassword varchar(100) not null,
`enabled` boolean not null
);

create table userrole(
UserID int not null,
RoleID int not null,
primary key (UserID,RoleID),
foreign key(UserID) references UserTable(UserID),
foreign key(RoleID) references RoleTable(RoleID)
);

Create Table GarageSales(
GarageSaleID int not null auto_increment,
primary key(GarageSaleID),
Address varchar(30) not null,
City varchar(30) not null,
State varChar(30) not Null,
ZipCode varchar(5) not null
);

create table UserGarageSales(
UserID int,
foreign key(UserID) references UserTable(UserID),
GarageSaleID int,
foreign key(GarageSaleID) references GarageSales(GarageSaleID),
primary key (UserID, GarageSaleID)
);

Create table FeaturedItems(
ItemID int not null auto_increment,
primary key(ItemID),
ItemCategory varchar(30),
ItemName varchar(30),
ItemDescription varchar(30),
GarageSaleID int,
foreign key(GarageSaleID) references GarageSales(GarageSaleID)
);