create schema i;

create table i.CUSTOMERS (
                             id int primary key auto_increment,
                             name varchar(50),
                             surname varchar(70),
                             age int check ( age > 0 ) not null,
                             phone_number long not null
);

create table i.ORDERS (
                          id int primary key auto_increment,
                          date timestamp not null default now(),
                          customer_id int not null,
                          product_name varchar(200),
                          amount int,
                          foreign key (customer_id) references i.CUSTOMERS (id)
);
