select * from books
select * from users
insert into books(id,author,category,title,year,owner_id)
values
(8,'Robert Kishnikov','horror','Last year',1998, 1),
(2,'Kimishov Nuar','comedy','happy',2000, 1),
(3,'Robertina','mystery','harry potter',1987, 7),
(4,'Mishka','animation',' year',1850, 7),
(5,'Queen','beaty book','lady women',1900, 5),
(6,'Love Dmila','comedy','good boy',2015, 5);


INSERT INTO public.users(
	id, email, name, surname)
	VALUES (1,'mia.khuda@korea.kr','Mia', 'Khuda'),
	(5,'jeon.jungkook@naver.com', 'Jungkook ','Jeon'),
	(7,'park.jimin@kan.kz','Jimin','Park');