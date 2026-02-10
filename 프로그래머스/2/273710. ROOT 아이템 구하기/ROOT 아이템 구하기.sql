-- 코드를 작성해주세요
select ii.ITEM_ID, ii.ITEM_NAME
from item_info as ii
join item_tree as it
on ii.item_id = it.item_id and parent_item_id is null
order by item_id asc