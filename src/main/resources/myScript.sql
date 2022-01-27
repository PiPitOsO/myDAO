select a.name, b.product_name, b.amount
from i.CUSTOMERS a
         join i.ORDERS b on b.customer_id = a.id
where upper(a.name) = upper(:name);