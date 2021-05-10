-- comapnies --
insert into company (name) values ('Dell');
insert into company (name) values ('Microsoft');

-- categories --
insert into category (name) values ('Laptops');
insert into category (name) values ('OS');

-- products --
insert into product (name, company_id, price, stock) values ('Dell XPS 13', 1, 1499, 5);
insert into product (name, company_id, price, stock) values ('Windows 10 Home', 2, 399, 50);

-- productOptimisitcs --
insert into product_optimistic (name, company_id, price, stock) values ('Dell XPS 13', 1, 1499, 5);
insert into product_optimistic (name, company_id, price, stock) values ('Windows 10 Home', 2, 399, 50);

insert into category_products (categories_id, products_id) values (1, 1);
insert into category_products (categories_id, products_id) values (2, 2);