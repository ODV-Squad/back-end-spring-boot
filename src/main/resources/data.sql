insert into users(id,login,password,role)
values ('c6a2d189-c3ad-462e-b623-57942d2dbec6','odv','$2a$10$dnbW/K2jbRNbjf0kv/sbZ.Ao3jJm9gN2EtiUjQ1coLXWt8g0giW.O','ADMIN');

insert into users(id,login,password,role)
values ('3a659504-f7de-4bfa-beab-4177259fe4d0','affiliate','$2a$10$0nazMpT3oys4.aTRF9MgyOTxnvtjyjgX1uUJwIQwZXkiIp4QtP1vG','AFFILIATE');

insert into product (id,name,price,description,is_featured,is_on_offer,category,amount,user_id)
values ('09511737-f447-4d92-9e0f-a50459200f66','iPhone',3500.00,'Laptop Dell',true,false,'ELECTRONIC',1,'c6a2d189-c3ad-462e-b623-57942d2dbec6');

insert into product (id,name,price,description,is_featured,is_on_offer,category,amount,user_id)
values ('c711eade-74de-4bec-8714-425db6be6082','MacBook',18900.00,'Macbook M2',true,true,'ELECTRONIC',5,'c6a2d189-c3ad-462e-b623-57942d2dbec6');

insert into product (id,name,price,description,is_featured,is_on_offer,category,amount,user_id)
values ('9298d6c6-0762-4d08-bede-8ee35a3be8e5','P�o',2.30,'P�o de Sal',false,false,'FOOD',8,'3a659504-f7de-4bfa-beab-4177259fe4d0');

insert into product (id,name,price,description,is_featured,is_on_offer,category,amount,user_id)
values ('9caa1c96-4fd9-47fa-8592-137b683ebde5','Coquinha',8.99,'Coquinha Zero Gelada',false,true,'BEVERAGE',15,'3a659504-f7de-4bfa-beab-4177259fe4d0');

