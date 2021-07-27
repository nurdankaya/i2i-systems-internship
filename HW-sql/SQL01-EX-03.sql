SELECT DISTINCT SUBSTR(E1.PHONE_NUMBER, 1, 3), COUNT(*) 
FROM HR.EMPLOYEES E1
JOIN HR.EMPLOYEES E2 
ON E1.PHONE_NUMBER LIKE SUBSTR(E2.PHONE_NUMBER, 1, 3) || '%' 
GROUP BY E1.PHONE_NUMBER;



SELECT * FROM (SELECT SUBSTR(E1.PHONE_NUMBER, 1, 3) X 
FROM HR.EMPLOYEES E1
JOIN HR.EMPLOYEES E2 
ON E1.PHONE_NUMBER LIKE SUBSTR(E2.PHONE_NUMBER, 1, 3) || '%' 
GROUP BY E1.PHONE_NUMBER) T
PIVOT
(
COUNT(*) FOR X IN(515,590,603,011,650)
);