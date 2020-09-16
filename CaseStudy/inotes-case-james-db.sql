drop database if exists inotes;
create database inotes;
use inotes;
select * from note;

truncate table note;
select * from note_type;
insert into note_type (id,name)
values
(1,"Work"),
(2,"Family"),
(3,"Myself");

insert into note (id,content,title,note_type_id) values
(1,"Mai đi sửa điện","ok",1);

select * from note where title like '%ok%' and note_type_id = 1