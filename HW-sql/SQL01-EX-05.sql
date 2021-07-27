SELECT LPAD(REGEXP_SUBSTR(customername, '[^ ]+' ,1,1),2) 
        || REGEXP_REPLACE((substr(REGEXP_SUBSTR(customername, '[^ ]+' ,1,1),3,length(REGEXP_SUBSTR(customername, '[^ ]+' ,1,1)))) ,'.','*' )
       || ' ' || 
       LPAD(REGEXP_SUBSTR(customername, '[^ ]+' ,1,2),2) 
       || REGEXP_REPLACE((substr(REGEXP_SUBSTR(customername, '[^ ]+' ,1,2),3,length(REGEXP_SUBSTR(customername, '[^ ]+' ,1,2)))) ,'.','*' )
       || ' ' ||
       LPAD(REGEXP_SUBSTR(customername, '[^ ]+' ,1,3),2) 
       || REGEXP_REPLACE((substr(REGEXP_SUBSTR(customername, '[^ ]+' ,1,3),3,length(REGEXP_SUBSTR(customername, '[^ ]+' ,1,3)))) ,'.','*' )
FROM Q5;

