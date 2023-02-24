
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


-- I want to see the total profit for each item including the number of items purchased
-- so .. if product x was ordered 10 times and had 50 items ordered in each order I want to see the total gross margin

