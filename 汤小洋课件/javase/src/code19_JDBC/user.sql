create table t_user
(
	id int primary key auto_increment,
	username varchar(50) not null unique,
	password varchar(50),
	age int
) charset utf8;

insert into t_user(username,password,age) values ('admin','123',19);
insert into t_user(username,password,age) values ('tom','456',20);