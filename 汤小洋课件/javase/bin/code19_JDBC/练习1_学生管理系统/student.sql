create table t_class
(
	id int auto_increment primary key,
	name varchar(200)
)charset utf8;

create table t_student
(
	id int auto_increment primary key,
	name varchar(50) not null unique,
	age int,
	height double,
	birthday date,
	cid int,
	foreign key (cid) references t_class(id)
)charset utf8;

insert into t_class (name) values ('Java一班');
insert into t_class (name) values ('Java二班');
insert into t_class (name) values ('Python一班');
insert into t_class (name) values ('Python二班');
insert into t_student values (null,'汤小洋',20,180.5,'1990-12,4',1);
insert into t_student values (null,'张小小',18,180.5,'1990-12,4',1);
insert into t_student values (null,'唐伯虎',25,170.5,curdate(),3);