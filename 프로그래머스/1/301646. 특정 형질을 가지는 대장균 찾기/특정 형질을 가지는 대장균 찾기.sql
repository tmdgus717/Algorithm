-- 코드를 작성해주세요
select count(*) as "count"
from ECOLI_DATA
where genotype & (1<<1) = 0 
    and (genotype & (1<<0) != 0
    or genotype & (1<<2) != 0)