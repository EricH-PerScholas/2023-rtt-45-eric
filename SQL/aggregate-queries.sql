
select * from employees where firstName = "Leslie";

select * from employees where VacationHours < 40;

select lastName, firstName from employees where firstName like "M%";

select e.firstName, e.lastName, c.customerName, c.phone, c.state
from employees e, customers c 
where e.employeeNumber = c.salesRepEmployeeNumber
order by e.firstName, e.lastName;

select * from employees;

update employees set extension = "JJJJ" where firstName like "J%";

insert into employees ( employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle, VacationHours) 
			values    (  2023, "Heilig", "Eric", "ext", "e@mail.com", 1, 1002, "TITLE", 500 );
            
delete from employees where employeeNumber = 2023;

select uuid();



select * from favorite where active = 0;




SELECT customerName, country, salesrepemployeenumber
FROM   classicmodels.customers
WHERE salesrepemployeenumber is NULL
ORDER BY customerName;

SELECT customerNumber, customerName, country,
IF(state IS NULL, 'N/A', state) as state 
FROM classicmodels.customers;

SELECT customerNumber, customerName, country, state,
IF(state IS NULL, 'N/A', state) as state 
FROM classicmodels.customers where state is null;

select * from customers where customerNumber not in ( 121, 125, 128, 141, 144);


select * from orderdetails;
SELECT   orderLineNumber, 
    CASE od.orderLineNumber
        WHEN 1  THEN 'NYC Warehouse'
        WHEN 2 THEN 'NJ Warehouse'
        WHEN 3 THEN 'CA Warehouse'
        WHEN 4 THEN 'PA Warehouse'
        ELSE   'ML warehouse'
    END AS Product_status    
FROM classicmodels.orderdetails od;

-- create a case statement if the price Each < 5o then print low, price < 100 print medium, price >= 100 then high
SELECT   orderLineNumber, priceEach,
    CASE 
        WHEN priceEach < 50  THEN 'Low' 
        WHEN priceEach < 100 then 'medium' 
        ELSE   'high' 
    END AS Product_status    
FROM classicmodels.orderdetails od;






select c.customerNumber, c.customerName, o.orderNumber, o.orderDate
from customers c, orders o
where c.customerNumber = o.customerNumber
order by customerName;


select c.customerNumber, c.customerName, count(o.orderNumber) as total_order_count , max(orderDate) as most_recent_order, min(orderDate) as first_order_date
from customers c, orders o
where c.customerNumber = o.customerNumber
group by c.customerNumber
order by customerName;

-- I want to see the customer name, order number, product code, product name and quantity ordered, price of the product and the MSRP
-- now I want to see the total price for each product ordered that the customer paid
-- now I Want to see the total margin for the order line item
-- this does not need a group by
select c.customerName, o.orderNumber, p.productCode, p.productName, od.quantityOrdered, p.buyPrice, p.MSRP, (p.MSRP - p.buyPrice) as product_margin,
		(p.MSRP * od.quantityOrdered) as customer_paid, ((p.MSRP - p.buyPrice) * od.quantityOrdered) as total_margin
from orders o, orderdetails od, products p, customers c
where od.productCode = p.productCode
and o.orderNumber = od.orderNumber
and c.customerNumber = o.customerNumber;

-- I want to see the customer name, product code, and the product name
-- and how many times a customer has purchased a particualr product ( not the quantity of products purchased )
select c.customerName, p.productCode, p.productName, count(p.productCode)
from customers c, products p, orderdetails od, orders o
where c.customerNumber = o.customerNumber
and od.productCode = p.productCode
and o.orderNumber = od.orderNumber
group by c.customerNumber, p.productCode
order by p.productCode;

-- I want to see all product codes and product names and how many times that product has been ordered ( not the quanitity ) 
-- now we want to order this by the product with the highest order count and then alphabetically
select p.productCode, p.productName, count(p.productCode) as order_count
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode
order by order_count desc, productName asc;

-- I want to see the productLine and the description and the number of products in that product line
select pl.productLine, pl.textDescription, count(p.productcode) as product_count
from productlines pl, products p
where p.productline = pl.productline
group by p.productline;

-- group by
select pl.productLine,  count(p.productCode), max(p.productCode), min(p.productCode)
from productlines pl, products p
where p.productline = pl.productline
group by p.productline
order by p.productline;



-- a) I want to see the product code, product name, total quantity ordered, cost of goods sold (COGS), net sales, and total profit for each product that was purchased
-- a) so .. if product x was ordered 10 times and had 50 items ordered in each order I want to see the total gross margin
-- b) now .. lets increase the complixity 
-- b) I want to use a subtable to calculate total profit and profit margin percentage and I want to see the lowest margin products first
select subtable.*, subtable.net_sales - subtable.COGS as total_profit, (net_sales - COGS) / net_sales * 100 as profit_margin
from 
	(
		select p.productCode, p.productName, p.buyPrice, p.MSRP, sum(od.quantityOrdered) as total_quantity_ordered, 
			sum(p.buyPrice * od.quantityOrdered) as COGS, sum(p.MSRP * od.quantityOrdered) as net_sales
		from products p, orderdetails od
		where p.productCode = od.productCode
		group by p.productCode
	) as subtable
order by profit_margin asc;

-- answer to part a
select p.productCode, p.productName, count(quantityOrdered) as quantity_sold, sum(buyPrice * quantityOrdered) as COGS, sum(MSRP * quantityOrdered) as net_sales, 
	sum(MSRP * quantityOrdered) - sum(buyPrice * quantityOrdered)  as total_profit
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode
order by total_profit desc;



-- Homeowrk #1 of all the customer that have made orders, I want to see the customer name, first order date, month of the first order, the last order date, 
-- year of the last order and how long this customer has been a customer ( now() - first ) in days
select customerName, min(o.orderDate), month(min(o.orderDate)), max(o.orderDate), year(max(o.orderDate)), datediff( now() , min(o.orderDate) )
from customers c, orders o
where c.customerNumber = o.customerNumber
group by c.customerNumber
order by o.customerNumber;

-- Homework #2 I want know the average margin for all orders sorted by the order with the highest average margin first.   This includes the margin on the quantity of products sold
select o.orderNumber, avg(MSRP - buyPrice) as avg_margin
from orders o, orderdetails od, products p
where o.orderNumber = od.orderNumber
and od.productCode = p.productCode
group by o.orderNumber
order by avg_margin desc;

-- Homework #3 - EXTRA HARD - I want to see my most profitable custoemrs by the avergae profit margin of all their orders.  I only care about my customers that
-- have an average margin greather than 1800
select c.customerNumber, c.customerName, avg((MSRP - buyPrice)*quantityOrdered) as avg_margin
from orders o, orderdetails od, products p, customers c
where o.orderNumber = od.orderNumber
and od.productCode = p.productCode
and o.customerNumber = c.customerNumber
group by c.customerNumber
having avg((MSRP - buyPrice)*quantityOrdered) > 1800
order by avg_margin desc;



-- Homework - having 1 
-- I want to see all order that have more than 2 line items in that order.  Show me the order number and the count of line items and order by the highest line items first
-- hint : first write a query that will give you the count of all line items then add a having to limit

-- Homework - subquery 1
-- I want to see the most expensive order based on msrp and item quantity

-- homework 3 
-- I want to see the all customers that are in states in which we have an office
-- change this query to use a regular join ( hard becasue will need left join )
select * from offices;
select state from offices where state is not null;
select * from customers c where c.state in (select o.state from offices o where state is not null);
-- same query using a sub table
select * 
from customers c, 
	(select o.state from offices o where state is not null) os
where c.state = os.state;

-- using an in staement
select * from customers where state = 'NY' or state = 'CA' or state = 'NJ' or state ='MD' or state = 'CO';
select * from customers where state in ( 'NY', 'CA', 'NJ', 'MD', 'CO' );


-- self join
select e.lastName as employeeLastName, e.firstName as employeeFirstName, rt.lastName as reprotToLastName, rt.firstName as reporstToFN
from employees e, employees rt
where e.reportsTo is null or e.reportsTo = rt.employeeNumber;




-----------------------------------------
-- refactor of class models database adding an id column to products
-- 1) we need to remove the foreign key from orderdetails.productCode
-- 2) remove the PK from products.productCode
-- 3) we create a new id column on products table that is INT PK NN AI
select * from products where id = 23;
-- 4) we need to create a product_id column on the orderdetail table  as INT  ( this will be our new FK ) we allow null values for now
select * from orderdetails where product_id = 23;
-- 5) now we have update the values in our orderdteails table to set the product_id column to the products.id column
update orderdetails od set od.product_id = ( select id from products p where p.product_code = od.product_code);
-- 6) now we can make our product_id not null and apply
-- 7) craete our new foreign key relationship between orderdetails.product_id and products.id
-- 8) drop the orderdetail.product_code column because we already have a linkage between orderdetails.product_id = products.id
-- both of these queries are the same thus .. we can drop the orderdetails.product_code column
select od.order_number, p.* from products p, orderdetails od where p.product_code = od.product_code and order_number = '10100' order by order_number;
select od.order_number, p.* from products p, orderdetails od where p.id = od.product_id and order_number = '10100' order by order_number;
-- 9) remove PK from existing 2 colums, delete FK to the orders table, create new PK id not nn ai
-- 10) create PK on orders table and start going throug same steps to fix that table

--   where x = null -- will never return results
--   where x is null -- this is proper