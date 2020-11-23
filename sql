create table dvdcart
(
id int not null primary key generated always as identity (START WITH 1, INCREMENT BY 1),
id_catalog int not null,
foreign key (id_catalog) references DVDCATALOG(ID),	
quantity integer
);


create table dvdcatalog
(
id int not null primary key generated always as identity (START WITH 1, INCREMENT BY 1),
name varchar(80);
rate varchar(10);
years int,
price double,
quantity integer
);
