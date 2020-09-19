CREATE or REPLACE procedure calculateNetSal(empnum IN emp.empno % TYPE, p_output OUT emp.sal %NUMBER)
IS 
	p_emp_no %TYPE,
	p_ename %TYPE,
	gross number,
	it number,
	net number;
	
BEGIN 

	select sal+comm into gross from emp where empno = empnum;
	
	select CASE 
    	WHEN comm=null THEN it:=gross*0.1
    	WHEN comm<500 THEN it:=gross*0.15
    	ELSE it:=gross*0.2
	END AS IT_CAL
	from 
		EMP 
	WHERE 
		empno = empnum;
	
	select 
		gross-it into p_output,
	from emp
	WHERE empno = empnum;
		
END;
