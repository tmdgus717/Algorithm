-- 코드를 입력하세요
select count(base.name) as count
from(
    select name
    from ANIMAL_INS
    group by name
) base