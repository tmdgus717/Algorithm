-- 코드를 입력하세요
SELECT ugb.title, ugb.board_id, ugr.reply_id, ugr.writer_id, ugr.contents, DATE_FORMAT(ugr.created_date,'%Y-%m-%d') as created_date
from USED_GOODS_BOARD as ugb
join USED_GOODS_REPLY as ugr
on ugb.BOARD_ID = ugr.BOARD_ID
where year(ugb.created_date) = 2022 and month(ugb.created_date) = 10 
order by ugr.created_date asc, ugb.title asc