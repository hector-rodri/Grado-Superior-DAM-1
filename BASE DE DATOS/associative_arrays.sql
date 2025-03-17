DECLARE 
TYPE t_sales IS TABLE OF NUMBER INDEX BY VARCHAR2(20);
sales t_sales;
BEGIN 
SELECT 
sales('Blake') := 12000;
sales('Daisy') := 15000;
sales('Lily') := 18000;
DBMS_OUTPUT.PUT_LINE(
    sales('Blake')+'Ventas: ' || sales('Blake')
);
DBMS_OUTPUT.PUT_LINE(
    sales('Daisy')+'Ventas: ' || sales('Blake')
);
DBMS_OUTPUT.PUT_LINE(
    sales('Lily')+'Ventas: ' || sales('Blake')
);
END;
/