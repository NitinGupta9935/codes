CREATE TABLE USERS (
id bigint auto_increment primary key,
name varchar(255) not null,
email varchar(255) not null,
password varchar(255) not null
);

CREATE TABLE ADDRESSES (
id bigint auto_increment primary key,
street varchar(255) not null,
city varchar(255) not null,
zip varchar(255) not null,
user_id bigint not null,
foreign key (user_id) REFERENCES users (id)
);
