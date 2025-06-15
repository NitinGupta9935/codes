Create Table Categories (
id tinyint primary key auto_increment,
name varchar(225) not null
);

create Table Products (
id bigint primary key auto_increment,
name varchar(225) not null,
price decimal(10, 2) not null,
category_id tinyint,
constraint fk_category foreign key (category_id) REFERENCES categories (id)
on delete restrict
);