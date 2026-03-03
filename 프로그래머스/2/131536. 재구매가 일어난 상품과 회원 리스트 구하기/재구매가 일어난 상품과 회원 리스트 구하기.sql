-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
group by USER_ID, PRODUCT_ID
having count(*) > 1
order by user_id asc, product_id desc