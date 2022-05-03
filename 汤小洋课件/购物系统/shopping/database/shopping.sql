-- 创建数据库
drop database if exists shopping;
create database shopping charset utf8;
use shopping;

-- 创建表
create table t_product
(
	id int primary key auto_increment,
	name varchar(50) not null,
	price double
)charset utf8;

create table t_user
(
	id int primary key auto_increment,
	username varchar(50) unique not null,
	password varchar(200),
	phone varchar(50),
	address varchar(200),
	status int 

)charset utf8;

create table t_order
(
	id int primary key auto_increment,
	user_id int,
	no varchar(50) unique not null,
	price double,
	createdate datetime,
	foreign key (user_id) references t_user(id)
)charset utf8;

create table t_item
(
	id int primary key auto_increment,
	product_id int,
	num int,
	price double,
	order_id int,
	foreign key (product_id) references t_product(id),
	foreign key (order_id) references t_order(id)
)charset utf8;


-- 插入数据
insert into t_product (name,price) value ('面包',4.5);
insert into t_product (name,price) value ('牛奶',5.2);
insert into t_product (name,price) value ('方便面',5);
insert into t_product (name,price) value ('矿泉水',2);
insert into t_product (name,price) value ('口香糖',9);
insert into t_product (name,price) value ('巧克力',25.5);
insert into t_product (name,price) value ('薯片',8);
insert into t_product (name,price) value ('可乐',4.5);


-- 根据订单编号查询订单明细
 select 
 	i.id 'i.id',i.num 'i.num',i.price 'i.price',p.id 'p.id',p.name 'p.name',p.price 'p.price' 
 from 
 		t_item i
 	left join 
 		t_product p 
 			on i.product_id=p.id
 	left join	
 		t_order o
 			on i.order_id=o.id
 where 
 	i.order_id=1 and o.user_id=1;




