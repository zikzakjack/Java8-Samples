
select
(CASE WHEN employee_id is not null THEN to_char(employee_id) ELSE '' END) as employee_id ,
(CASE WHEN first_name is not null THEN to_char(first_name) ELSE '' END) as first_name,
(CASE WHEN last_name is not null THEN to_char(last_name) ELSE '' END) as last_name ,
(CASE WHEN email is not null THEN to_char(email) ELSE '' END) as email ,
(CASE WHEN phone_number is not null THEN to_char(phone_number) ELSE '' END) as phone_number ,
(CASE WHEN hire_date is not null THEN to_char(hire_date) ELSE '' END) as hire_date ,
(CASE WHEN job_id is not null THEN to_char(job_id) ELSE '' END) as job_id ,
(CASE WHEN salary is not null THEN to_char(salary) ELSE '' END) as salary ,
(CASE WHEN commission_pct is not null THEN to_char(commission_pct) ELSE '' END) as commission_pct ,
(CASE WHEN manager_id is not null THEN to_char(manager_id) ELSE '' END) as manager_id ,
(CASE WHEN department_id is not null THEN to_char(department_id) ELSE '' END) as department_id ,
(CASE WHEN department_id is not null THEN to_char(department_id) ELSE '' END) as department_id
from employees

-- to create employees.csv

select
(CASE WHEN employee_id is not null THEN to_char(employee_id) ELSE '' END) || ',' ||
(CASE WHEN first_name is not null THEN to_char(first_name) ELSE '' END) || ',' ||
(CASE WHEN last_name is not null THEN to_char(last_name) ELSE '' END) || ',' ||
(CASE WHEN email is not null THEN to_char(email) ELSE '' END) || ',' ||
(CASE WHEN phone_number is not null THEN to_char(phone_number) ELSE '' END) || ',' ||
(CASE WHEN hire_date is not null THEN FORMATDATETIME(hire_date , 'yyyy-MM-dd') ELSE '' END) || ',' ||
(CASE WHEN job_id is not null THEN to_char(job_id) ELSE '' END) || ',' ||
(CASE WHEN salary is not null THEN to_char(salary) ELSE '' END) || ',' ||
(CASE WHEN commission_pct is not null THEN to_char(commission_pct) ELSE '' END) || ',' ||
(CASE WHEN manager_id is not null THEN to_char(manager_id) ELSE '' END) || ',' ||
(CASE WHEN (select department_name from departments where department_id = e.department_id) is not null THEN to_char(select department_name from departments where department_id = e.department_id) ELSE '' END) as employees_data
from employees e

FORMATDATETIME(hire_date , 'yyyy-MM-dd')
