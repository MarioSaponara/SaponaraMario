#1.Select all smartphones in the database;
select * from smartphone;

#2.Select all smartphones in the database with projection: name, ram, size and cpu;
select name, ram, size, cpu from smartphone;

#3.Select name of smartphones with display resolution equal to 1080x1920;
select name from smartphone where displayResolution = '1080x1920';

#4.Select name of smartphones with display resolution equal to 1080x1920 and 3Gb ram;
select name from smartphone where displayResolution= '1080x1920' and ram="3Gb";

#5.Select all Galaxy smartphones; 
select * from smartphone where name Like 'Galaxy%';

#6.Select all Galaxy smartphones with dual-core cpu;
select * from smartphone where cpu Like '%dual-core%' and name Like 'Galaxy%';

#7.Select all smartphones with weight greater than or equal 150 grams;
select * from smartphone where weight>=150;

#8.Select all smartphones with weight less than 150 grams;
select * from smartphone where weight<150;

#9.Select all smartphones sorted by display ppi;
select * from smartphone order by displayPpi;

#10.Select all smartphones descendant sorted by display ppi;
select * from smartphone order by displayPpi desc;

#11.Select name and brand of all smartphones in the database;
select s.name, b.name from smartphone as s inner join brand as b on s.brand =b.id;

#12.Select name and opSys of all smartphones in the database sorted by opSys, name; 
select s.name, o.description from smartphone as s inner join opSys as o on s.opSys =o.id order by o.description, s.name;
#select S.name , O.description as opSys from smartphone as S inner join opsys as O on S.opsys = O.id
#order by O.description, S.name;

#13.Select name and opSys of all Android smartphones in the database descendant sorted by weight;
select s.name, o.description as opSys, s.weight from smartphone as s inner join opSys as o on o.description="Android" order by weight desc;

#14.Select name, brand, country of all smartphones in the database sorted by country, brand, name;
select s.name, b.name as brand, c.name as country   from smartphone as s inner join brand as b on s.brand=b.id inner join country as c
on b.country=c.code order by c.name, b.name, s.name;

#15.Select count of smartphones in the database with 3Gb ram;
select count(id) from smartphone where ram = "3Gb";

#16.Select count of smartphones for each opSys in the database;
select count(s.id), o.description from smartphone as s inner join 
opsys as o on s.opSys=o.id group by o.description; 

#17.Select count of smartphones for each country in the database;
select count(s.id), c.name as country from smartphone as s inner join brand as b on s.brand = b.id inner join 
country as c on b.country = c.code group by c.name;