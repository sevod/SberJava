https://partner.sberbank-school.ru/programs/9718/item/369256
#SELECT  И сортировка
* DISTINCT уникальные поля
```SELECT DISTINCT 
speed,
ram
FROM PC
```

* ORDER BY упорядочивание, 
```
DESC по убыванию
ASC по возрастанию
SELECT DISTINCT speed, ram
FROM PC
ORDER BY ram DESC;
 или
SELECT DISTINCT speed, ram
FROM PC
ORDER BY 2 DESC;
```
* сортировка по двум полям
```
SELECT DISTINCT speed, ram
FROM PC
ORDER BY ram DESC, speed DESC;
```
* WHERE горизонтальная выборка.
```
SELECT DISTINCT speed, ram
FROM PC
WHERE price < 500
ORDER BY 2 DESC;
```
* Сортировка по дате с использованием CONVERT.
Перед сортировкой все преобразуется в строку.
```
SELECT date
FROM Battles
ORDER BY CONVERT(CHAR(5),date,110);
```
* Сортировка по дате с использованием функций MONTH и DAY
```
SELECT 
	DAY(date) BD_day, 
	DATENAME(mm, date) BD_month, 
	name
FROM Battles
ORDER BY MONTH(date), DAY(date);
```
#Предикаты.
https://partner.sberbank-school.ru/programs/9718/item/369257
* Приоритеты NOT AND OR 
Есть упоминание INTERSECT и UNION

**BETWEEN между
```
SELECT model, speed
FROM PC
WHERE price BETWEEN 400 AND 600;
```
**IN -  в 
```
SELECT model, speed, hd
FROM PC
WHERE hd IN (10, 20) AND
 model IN (SELECT model
 FROM product
 WHERE maker = 'A');
```
**LIKE - подобно, сравнение строк
_ любой единичный символ
% последовательность символов или ничего
```
SELECT *
FROM Ships
WHERE class NOT LIKE '%go' AND
 class LIKE '%o' ; 
```
ESCAPE "Трафаретный символ"
LIKE '25|%' ESCAPE '|' --ищем %
'%#_%' ESCAPE '#'      --ищем _


**LIKE и регулярные выражения**

https://partner.sberbank-school.ru/programs/9718/item/369257

*NULL в условиях поиска*

IS [NOT] NULL
```
SELECT *
FROM PC
WHERE price IS NULL;

WHERE price = NULL ЭТО ОШИБКА
```
Упоминается CASE

https://partner.sberbank-school.ru/programs/11906/item/460438
#Переименование столбцов
*AS*
```
SELECT ram AS Mb, hd Gb
FROM PC
WHERE cd = '24x';
```
**можно расположить поясняющую информацию рядом с соответствующим значением
```
SELECT ram, 'Mb' AS ram_units, hd, 'Gb' AS hd_units
FROM PC
WHERE cd = '24x';
```
*Ограничители*
* в данном случае символьную константу 'SELECT' в столбце с именем SELECT. 
SELECT 'SELECT' "SELECT";

https://partner.sberbank-school.ru/programs/11906/item/460439
#Получение итоговых значений
*COUNT(*) - Возвращает количество строк источника записей (учитывает NULL)

*COUNT Возвращает количество значений в указанном столбце
```
SELECT COUNT(model) AS Qty_model
FROM Product
WHERE maker = 'A';
```
* SUM Возвращает сумму значений в указанном столбце (только для чисел)
* AVG Возвращает среднее значение в указанном столбце (только для чисел)
* MIN Возвращает минимальное значение в указанном столбце
```
SELECT 
	MIN(price) AS Min_price,
    MAX(price) AS Max_price
FROM PC;
```
* MAX Возвращает максимальное значение в указанном столбце

* Так же можно использовать DISTINCT по умолчанию ALL

#GROUP BY используется для определения групп выходных строк, к которым могут применяться агрегатные функции (COUNT, MIN, MAX, AVG и SUM).
```
SELECT 
	model, 
	COUNT(model) AS Qty_model,
    AVG(price) AS Avg_price
FROM PC
GROUP BY model;
```
* NULL-значения - все такие строки попадут в одну группу.
* Результат выполнения функции COUNT есть целое число (INTEGER). Другие агрегатные функции наследуют типы данных обрабатываемых значений.
* Если при выполнении функции SUM будет получен результат, превышающий максимально возможное значение для используемого типа данных, возникает ошибка.

#Предложение HAVING
* HAVING применяется после группировки для определения аналогичного предиката
```
SELECT 
	model, 
	COUNT(model) AS Qty_model,
	AVG(price) AS Avg_price
FROM PC
GROUP BY model
HAVING AVG(price) < 800;
```
#порядок обработки предложений в операторе SELECT:
1. FROM
2. WHERE
3. GROUP BY
4. HAVING
5. SELECT
6. ORDER BY
#ROLLUP
* Получение итоговых данных с помощью оператора ROLLUP
```
SELECT 
	CASE 
		WHEN point IS NULL THEN 'ALL' 
		ELSE CAST(point AS varchar) 
	END point,
SUM(inc) Qty
FROM Income 
GROUP BY point WITH ROLLUP;
```
* Если СУБД не поддерживает конструкцию ROLLUP, можно использовать либо UNION, либо _внешнее_ соединение (FULL JOIN)
```
SELECT 
	CAST(point AS varchar) point, 
	SUM(inc) Qty
FROM Income GROUP BY point
UNION ALL
SELECT 
	'ALL' AS point, 
	SUM(inc) AS Qty
FROM Income;
```
* Сортировка и NULL-значения
```
SELECT TOP 1 WITH ties model
FROM PC_
WHERE price IS NOT NULL  #УЧИТЫВАЕМ NULL занчения! исключаем их
ORDER BY price;
```
* Агрегатная функция от агрегатной функции
как пример
```
SELECT MAX(avg_price)
FROM (SELECT 
		AVG(price) avg_price
		FROM 
			Product P JOIN PC 
			ON P.model = PC.model
		GROUP BY maker
	) X;
```
###### Укажите количество имеющихся различных моделей ПК, выпускаемых производителем А.
###### вопрос плохо понятен, но пусть будет так.
```
SELECT 
	COUNT(DISTINCT model) AS model
	FROM PC
	WHERE model IN 
	(SELECT 
		model
	FROM Product
WHERE type = 'PC' AND maker = 'A')
```

# Использование в запросе нескольких источников записей
https://partner.sberbank-school.ru/programs/11906/item/460440

##### пример ниявного соединения
```
SELECT DISTINCT PC.model, maker
FROM PC, Product
WHERE PC.model = Product.model AND
price < 600;
```

##### Явные операции соединения
```
FROM <таблица 1>
 [INNER]
 {{LEFT | RIGHT | FULL } [OUTER]} JOIN <таблица 2>
[ON <предикат>]
```
Служебные слова INNER и OUTER можно опускать, 
поскольку внешнее соединение однозначно определяется его типом 
— LEFT (левое), RIGHT (правое) или FULL (полное), 
а просто JOIN будет означать внутреннее соединение.
* INNER JOIN
```
SELECT 
	maker, 
	Product.model AS model_1,
    PC.model AS model_2, 
	price
FROM 
	Product INNER JOIN PC 
		ON PC.model = Product.model
ORDER BY maker, model_2;
```
* LEFT JOIN
```
SELECT 
	maker, 
	Product.model AS model_1, 
	pc.model AS model_2, 
	price
FROM 
	Product LEFT JOIN PC 
	ON PC.model = Product.model
WHERE type = 'pc'
ORDER BY maker, PC.model;
```
`COALESCE`(m_pc.maker, m_printer.maker) - вывести в один столбец
```
SELECT COALESCE(m_pc.maker, m_printer.maker) FROM
(SELECT DISTINCT maker FROM Product WHERE type='pc') m_pc
FULL JOIN
(SELECT DISTINCT maker FROM Product WHERE type='printer') m_printer
ON m_pc.maker = m_printer.maker  
WHERE m_pc.maker IS NULL OR m_printer.maker IS NULL;
```

#####Эквисоединения
* Естественное соединение

`Таблица_1 NATURAL <тип соединения> JOIN  Таблица_2`

* USING соединение не по всем столбцам

`Таблица_1 <тип соединения> JOIN  Таблица_2 USING(<список столбцов>)`

#операции над множествами
https://partner.sberbank-school.ru/programs/11906/item/460441
##Декартово произведение - при декартовом произведении каждая строка из первой таблицы соединяется с каждой строкой второй таблицы.
* CROSS JOIN в явном виде
``
SELECT 
	Laptop.model, 
	Product.model
FROM Laptop 
	CROSS JOIN
	Product;
*В неявном виде, тоже самое	
SELECT 
	Laptop.model, 
	Product.model
FROM Laptop ,
	Product;
``	
##UNION Объединение
* если определен параметр ALL, то сохраняются все дубликаты выходных строк, в противном случае в результирующем наборе присутствуют только уникальные строки
```
<запрос 1>
UNION [ALL]
<запрос 2>
```
```
SELECT 
	model, 
	price
FROM PC
UNION
SELECT 
	model, 
	price
FROM Laptop
ORDER BY price DESC;
```
##Пересечение и разность

* INTERSECT [ALL] (пересечение) -  попадают только те строки, которые присутствуют в обоих запросах
* EXCEPT [ALL] (разность) - те строки первого запроса, которые отсутствуют во втором
* по умолчанию DISTINCT
```
SELECT name FROM Ships
INTERSECT
SELECT ship FROM Outcomes;
```
```
SELECT ship FROM Outcomes
EXCEPT
SELECT name FROM Ships;
```
* ALL почему то не работает

* Порядок 
1. UNION, EXCEPT
2. INTERSECT

* EXISTS
```
SELECT DISTINCT maker
FROM Product AS lap_product
WHERE type = 'laptop' AND
 EXISTS (SELECT maker
 FROM Product
 WHERE type = 'printer' AND
 maker = lap_product.maker
 );
```
###### Задача Используя оператор UNION выяснить, какие модели производителя 'B' имеются в наличии. Выберите номер модели и тип.
```
SELECT model, type
FROM (
SELECT 
		model, type
FROM Product
WHERE maker = 'B'
UNION
SELECT 
	model, 
	NULL AS type
FROM PC) AS TAB
WHERE type is NOT NULL;	
```

# Реляционное деление
https://partner.sberbank-school.ru/programs/11906/item/460442

`Product[maker, type] DIVIDE BY Product[type]`

ее нет в языке SQL!

#####  через Группировка
```
SELECT maker
FROM Product
GROUP BY maker
HAVING COUNT(DISTINCT type) = (SELECT COUNT(DISTINCT type) FROM Product);
```

#SOME (ANY) и ALL с предикатами сравнения
https://partner.sberbank-school.ru/programs/11906/item/460443

`<выражение> <оператор сравнения> SOME | ANY (<подзапрос>)`

Если хотябы для одного ИСТИНА
```
SELECT DISTINCT maker
FROM Product
WHERE type = 'pc' AND
  NOT model = ANY (
	SELECT model
	FROM PC
 );
```

`<выражение> <оператор сравнения> ALL (<подзапрос>)`

Если для всех Истина
```
SELECT DISTINCT model, price
FROM Laptop
WHERE price > ALL (SELECT price
 FROM PC
);
```

#Преобразование типов и оператор CAST
https://partner.sberbank-school.ru/programs/11906/item/460444
```
SELECT 'Средняя цена = '+ CAST(AVG(price) AS CHAR(15))
FROM Laptop;
```

`CAST(<выражение> AS <тип данных>)`

````
SELECT CAST(AVG(CAST(launched AS NUMERIC(6,2))) AS NUMERIC(6,2))
FROM Ships;
````

#####CONVERT

`SELECT CONVERT(char(25), CONVERT(datetime,'20030722'));`

#Оператор CASE
https://partner.sberbank-school.ru/programs/11906/item/460445
````
SELECT DISTINCT product.model,
 CASE
 WHEN price IS NULL
 THEN 'Нет в наличии'
 ELSE CAST(price AS CHAR(20))
 END price
FROM Product LEFT JOIN
 PC ON Product.model = PC.model
WHERE product.type = 'pc';
````
1-я форма:
````
CASE <проверяемое выражение>
 WHEN <сравниваемое выражение 1>
 THEN <возвращаемое значение 1>
 …
 WHEN <сравниваемое выражение N>
 THEN <возвращаемое значение N>
 [ELSE <возвращаемое значение>]
END
````
2-я форма:
````
CASE
 WHEN <предикат 1>
 THEN <возвращаемое значение 1>
 …
 WHEN <предикат N>
 THEN <возвращаемое значение N>
 [ELSE <возвращаемое значение>]
END
````
````
SELECT DISTINCT model, price,
 CASE price
	WHEN (SELECT MAX(price)
			FROM PC)
	THEN 'Самый дорогой'
	WHEN (SELECT MIN(price)
			FROM PC )
	THEN 'Самый дешевый'
	ELSE 'Средняя цена'
 END comment
FROM PC
ORDER BY price;
````

#####COALESCE - проверка на NULL
```
SELECT DISTINCT Product.model,
 COALESCE(CAST(price AS CHAR(20)),'Нет в наличии') price
FROM Product LEFT JOIN
 PC ON Product.model = PC.model
WHERE Product.type = 'pc';
```

#Операторы модификации данных INSERT UPDATE DELETE
https://partner.sberbank-school.ru/programs/11906/item/460446

#####INSERT
````
INSERT INTO <имя таблицы>[(<имя столбца>,...)]
{VALUES (<значение столбца>,…)}
| <выражение запроса>
| {DEFAULT VALUES}
````

`CREATE TABLE`

````
CREATE TABLE product
(
 maker char (1) NOT NULL,
 model varchar (4) NOT NULL,
 type varchar (7) NOT NULL
);
````
````
INSERT INTO Productdell
VALUES ('B', 1157, 'PC');
````

```
INSERT INTO Productdell	(type, model, maker)
VALUES ('PC', 1157, 'B');
```
Создание таблицу со значением по умолчанию.
````
CREATE TABLE product_D
(
 maker char (1) NULL,
 model varchar (4) NULL,
 type varchar (7) NOT NULL DEFAULT 'PC'
);
````

Используем `DEFAULT`

````
INSERT INTO Product_D
VALUES ('B', 1158, DEFAULT);
````

`INSERT INTO Product_D DEFAULT VALUES;`

Вставка данных с использованием подзапроса.

````
INSERT INTO Product_D
SELECT *
FROM Product
WHERE type = 'PC';
````

Вставка нескольких строк с использованием UNION

````
INSERT INTO Product_D
SELECT 'B' AS maker, 1158 AS model, 'PC' AS type
UNION ALL
SELECT 'C', 2190, 'Laptop'
UNION ALL
SELECT 'D', 3219, 'Printer';
````

#####Конструктор значений таблицы

````
VALUES
(<элемент конструктора>, <элемент конструктора>, ...),
(<элемент конструктора>, <элемент конструктора>, ...),
...
(<элемент конструктора>, <элемент конструктора>, ...)
````
````
CREATE TABLE Items (
item_no int PRIMARY KEY,
maker char(10),
type char(10) DEFAULT 'PC',
value int
);
````
````
INSERT INTO Items VALUES
(1, 'A', 'Laptop', 12),
(2, 'B', DEFAULT, NULL),
(3, 'C', 'Printer', (SELECT CAST(model AS int) FROM Printer WHERE code=1)),
(4, 'C', 'Printer', (SELECT CAST(model AS int) FROM Printer WHERE code=77));
````

#####Оператор UPDATE
````
UPDATE <имя таблицы>
SET {<имя столбца> = {<выражение для вычисления значения столбца>
| NULL
| DEFAULT},...}
[ {WHERE <предикат>}]
````
````
UPDATE Laptop
SET price = price*0.9;
````
````
UPDATE Laptop
SET hd = ram/2 
WHERE hd < 10;
````
````
UPDATE Laptop
SET hd = 
CASE
	WHEN ram < 128
	THEN 20
	ELSE 40
END;
````
````
UPDATE Laptop
SET speed = 
	(SELECT MAX(speed)
	FROM Laptop
	)
;
````

#####Оператор DELETE
````
DELETE FROM <имя таблицы >
[WHERE <предикат>];
````

````
DELETE FROM Laptop
WHERE screen < 12;
````

Полностью удалить таблицу.

````
DELETE FROM Laptop;
````

#Оператор MERGE
https://partner.sberbank-school.ru/programs/11906/item/460448

````
MERGE Ships AS target  -- таблица, которая будет меняться
USING (SELECT year(MIN(date)), ship, ship
       FROM outcomes O JOIN battles B ON O.battle= B.name
               JOIN Classes C ON C.class=O.ship GROUP BY ship
      ) AS source (min_year,ship, class)  -- источник данных, который мы рассмотрели выше
ON (target.name = source.ship)  -- условие связи между источником и изменяемой таблицей
WHEN MATCHED AND target.launched IS NULL -- если головной корабль есть в таблице Ships
           -- с неизвестным годом
    THEN UPDATE SET target.launched = source.min_year -- обновление
WHEN NOT MATCHED  -- если головного корабля нет в таблице Ships
    THEN INSERT VALUES(source.ship, source.class, source.min_year) -- вставка
OUTPUT $action, inserted.*, deleted.*; -- можно вывести измененные строки
````

#Функции ранжирования
https://partner.sberbank-school.ru/programs/11906/item/460449
#####Функция ROW_NUMBER

`ROW_NUMBER`  нумерует строки, возвращаемые запросом. 

`OVER` - задает порядок нумерации строк.

````
SELECT 
	row_number() over(ORDER BY trip_no) num,
    trip_no, 
	id_comp
FROM trip
WHERE ID_comp < 3
ORDER BY id_comp, trip_no;
````

`PARTITION BY` задает группы строк, для которых выполняется независимая нумерация

````
SELECT 
	row_number() over(partition BY id_comp ORDER BY id_comp,trip_no) num,
	trip_no, 
	id_comp
FROM trip
WHERE ID_comp < 3
ORDER BY id_comp, trip_no;
````

#####Функции RANK() и DENSE_RANK()
так же нумерует строки
````
SELECT *, ROW_NUMBER() OVER(ORDER BY type) num,
RANK() OVER(ORDER BY type) rnk,
DENSE_RANK() OVER(ORDER BY type) dense_rnk
FROM Printer;
````


#####Функция NTILE
функция возвращает номер группы, в которую попадает соответствующая строка результирующего набора.
````
SELECT 
	*, 
	NTILE(3) OVER(PARTITION BY v_color ORDER BY v_id) gr
FROM utv ORDER BY v_color, v_id;
````

#Оконные функции
https://partner.sberbank-school.ru/programs/9718/item/369270

ХЗ чего они хотели объяснить в этой теме.

`PARTITION BY ` определяет «окно», т.е. набор строк, 
характеризуемых равенством значений списка выражений, 
указанного в этом предложении. 

`OVER()`

````
CREATE PROCEDURE paging
@n int -- число записей на страницу
, @p int =1 -- номер страницы, по умолчанию - первая
AS
SELECT * FROM
 (SELECT *,
   CASE WHEN num % @n = 0 THEN num/@n ELSE num/@n + 1 END AS page_num,
   CASE WHEN total % @n = 0 THEN total/@n ELSE total/@n + 1 END AS num_of_pages
  FROM
  (SELECT *,
         ROW_NUMBER() OVER(ORDER BY price DESC) AS num,
         COUNT(*) OVER() AS total FROM Laptop
  ) X
 ) Y
WHERE page_num = @p;
GO
````

`exec paging @n=2, @p=2`

Стандарт SQL Server 2012
````
ORDER BY <выражение>
    [ ASC | DESC ]
    [ ,...n ]
[
OFFSET <целочисленное_выражение_1> { ROW | ROWS }
[FETCH { FIRST | NEXT } <целочисленное_выражение_2> { ROW | ROWS } ONLY]
]
````


````
CREATE PROC paging
  @n int =2 -- число записей на страницу, по умолчанию 2
, @p int =1 -- номер страницы, по умолчанию - первая
AS
SELECT * FROM Laptop
ORDER BY price DESC OFFSET @n*(@p-1) ROWS FETCH NEXT @n ROWS ONLY;
````

Дальше забил на эту тему.

#CROSS APPLY / OUTER APPLY
https://partner.sberbank-school.ru/programs/9718/item/369271

`CROSS APPLY` - появился в SQL Server 2005. Он позволяет выполнить соединение двух табличных выражений.

`OUTER APPLY`

Тему не прошел.

#Конкатенация строк
https://partner.sberbank-school.ru/programs/9718/item/369272

`SELECT 1+2+3+4 a, '1'+'2'+'3'+'4' b;`

`CONCAT` - В SQL Server 2012 появилась функция CONCAT, 
которая выполняет конкатенацию, 
неявно преобразуя типы аргументов к строковому типу данных.

Изучил вскользь.

#Операторы PIVOT и UNPIVOT
https://partner.sberbank-school.ru/programs/9718/item/369273

Чтобы объяснить, что такое PIVOT, лучше начать с электронных таблиц EXCEL.

Тему пропустил.

#Общие табличные выражения (CTE)
https://partner.sberbank-school.ru/programs/9718/item/369274

CTE - Common Table Expression

Забил.

#Функция EOMONTH
https://partner.sberbank-school.ru/programs/9718/item/369275

В SQL Server 2012 появилась функция EOMONTH, которая позволяет сделать то же самое без применения "процедурной" логики.
````
SELECT CAST(
dateadd(dd, -day(dateadd(mm, 1, current_timestamp)),
dateadd(mm, 1, current_timestamp)) AS date
) old_way, eomonth(current_timestamp) new_way;
````

Тему пропустил.

#Типы данных

О самих типах данных почти ничего нет. Мало понятно для чего это.

#CHAR и VARCHAR
https://partner.sberbank-school.ru/programs/9718/item/369277


`СНAR` – фиксированные текстовые строки до 2000 байт.

`VARCHAR` — текстовые строки переменной длины до 4000 байт

* значение по умолчанию, для VARCHAR равно 30 (это о T-SQL?)

* Согласно стандарту, если для типов CHAR и VARCHAR размер не указан, то подразумевается CHAR(1) и VARCHAR(1) соответственно.

#Float(n)
https://partner.sberbank-school.ru/programs/9718/item/369278

#Целочисленное деление
https://partner.sberbank-school.ru/programs/9718/item/369279

Операция "/" просто обозначает целочисленное деление 
(а именно, дает в результате неполное частное) если операнды являются целыми числами.

`SELECT CAST(1 AS DEC(12,4))/3 AS a, 5./3 AS b;`

Операция получения остатка от деления в SQL Server обозначается "%"

`SELECT 1 % 3 AS a, 5 % 3 AS b;`

#Методы типа данных XML
https://partner.sberbank-school.ru/programs/9718/item/369280

Тип данных XML впервые появился в SQL Server 2005. 
Он может содержать до 2 Гб данных.

* query() – используется для извлечения XML фрагментов из XML документов;
* value() – используется для извлечения значений конкретных узлов или атрибутов XML документов;
* exist() – используется для проверки существования узла или атрибута. Возвращает 1, если узел или атрибут найден, и 0, если не найден;
* modify() – изменяет XML документ;
* nodes() – разделяет XML документ на несколько строк по узлам.

Зачем нам XML в SQL??? Дальше забил.

#Функции для работы с данными типа даты/времени
https://partner.sberbank-school.ru/programs/9718/item/369282

#####Функция DATEADD (datepart, number, date) 
Функция DATEADD (datepart, number, date) возвращает значение типа datetime,

````
Datepart
Допустимые сокращения
Year — год
yy, yyyy
Quarter — квартал
qq, q
Month — месяц
mm, m
Dayofyear — день года
dy, y
Day — день
dd, d
Week — неделя
wk, ww
Hour — час
hh
Minute — минута
mi, n
Second — секунда
ss, s
Millisecond - миллисекунда
ms
````
````
SELECT DATEADD(day, 7, current_timestamp);
SELECT DATEADD(ww, 1, current_timestamp);
````

#####Функция DATEDIFF

`DATEDIFF(datepart, startdate, enddate)`

````
SELECT DATEDIFF(dd, 
	(SELECT MIN(date)
	FROM pass_in_trip),
	(SELECT MAX(date)
	FROM pass_in_trip)
 );
````

#####Функция DATEPART
`DATEPART(datepart , date)`
````
SELECT DATEPART(hh, time_out)*60 + DATEPART(mi, time_out)
FROM Trip
WHERE trip_no = 1123;
````

#####Функция DATENAME

Функция DATENAME( datepart, date ) возвращает символьное представление составляющей (datepart) указанной даты (date).
````
SELECT DATENAME(weekday, '20171231' )+', ' + DATENAME(day, '20171231') +
 ' ' + DATENAME(month, '20171231') + ' ' + DATENAME(year,'20171231');
````

#####Первый день недели
Пропустил

#####Функция DATEFROMPARTS

`SELECT DATEFROMPARTS(2017, 5, 25);`

#Функции для работы со строками
https://partner.sberbank-school.ru/programs/9718/item/369283

Пропустил

#Числовые функции в SQL Server
https://partner.sberbank-school.ru/programs/9718/item/369284
#####Функция ROUND
`SELECT round(AVG(hd),2) AS avg_hd FROM pc;`

Пропустил

#CREATE TABLE
https://partner.sberbank-school.ru/programs/9718/item/369286

`CREATE TABLE <имя таблицы>(<список спецификаций столбцов и ограничений>);`

````
CREATE TABLE Product (
	maker varchar(10), 
	model varchar(50), 
	type varchar(50));
````
#Категорная целостность или целостность сущностей
https://partner.sberbank-school.ru/programs/9718/item/369287

`Потенциальный ключ`

`PRIMARY KEY` (первичный ключ) и `UNIQUE` (уникальный ключ). 
Первичный ключ может быть только один в таблице, 
уникальных же ключей может быть несколько. 

````
CREATE TABLE Product (
maker varchar(10),
model varchar(50) PRIMARY KEY,
type varchar(50)
);
````
ИЛИ
````
CREATE TABLE Product (
maker varchar(10),
model varchar(50),
type varchar(50),
CONSTRAINT product_PK PRIMARY KEY (model)
);
````
````
SELECT CONSTRAINT_NAME
FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
WHERE TABLE_NAME='Product' AND CONSTRAINT_TYPE ='primary key';
````
Два первичных ключа (составной ключ)
````
CREATE TABLE Outcomes (
ship varchar(50),
battle varchar(20),
result varchar(10),
PRIMARY KEY(ship, battle)
);
````

`UNIQUE` можеть быть несколько для одной таблицы
````
CREATE TABLE Outcomes (
ship varchar(50),
battle varchar(20),
result varchar(10),
out_id int,
PRIMARY KEY(ship, battle),
UNIQUE (out_id)
);
````
#Проверочные ограничения
`CHECK (<предикат>)`
````
DROP TABLE Product;
CREATE TABLE Product (
maker varchar(10),
model varchar(50),
type varchar(50),
CONSTRAINT product_PK PRIMARY KEY (model),
CONSTRAINT maker_ch CHECK(maker IS NOT NULL),
CONSTRAINT type_ch CHECK(type IS NOT NULL)
);
````

ИЛИ
````
DROP TABLE Product;
CREATE TABLE Product (
maker varchar(10) NOT NULL,
model varchar(50) PRIMARY KEY,
type varchar(50) NOT NULL
);
````

#Оператор ALTER TABLE
https://partner.sberbank-school.ru/programs/9718/item/369289

`ALTER TABLE` позволит нам изменять структуру таблицы, не пересоздавая её

Можно выделить следующие уровни проверочных ограничений:
 * уровень атрибута (столбца),
 * уровень кортежа (строки),
 * уровень отношения (таблицы).
 
 `CHECK (type IN('printer', 'pc', 'laptop'))`
 
 ````
 ALTER TABLE Product 
 ADD CONSTRAINT chk_type CHECK (type IN('pc', 'laptop', 'printer'));
 ````
````
ALTER TABLE Product
ADD constraint chk_maker_Z CHECK ((maker='Z' AND type= 'printer') OR maker <>'Z');
````

#Значения по умолчанию
https://partner.sberbank-school.ru/programs/9718/item/369290

#Ссылочная целостность: внешний ключ
https://partner.sberbank-school.ru/programs/9718/item/369291

`Внешний ключ (FOREIGN KEY)` – это ограничение, которое поддерживает согласованное состояние данных между двумя таблицами

`FOREIGN KEY(<список столбцов 1> REFERENCES <имя главной таблицы>(<список столбцов 2>)`
````
ALTER TABLE PC
ADD CONSTRAINT fk_pc_product
FOREIGN KEY(model) REFERENCES Product(model);
````

Опция для удаления

`ON DELETE <опция>`

Возможны следующие значения опции:
````
CASCADE   
SET NULL
SET DEFAULT
NO ACTION (работает по умолчанию)
````

#Вложенные запросы в проверочных ограничениях
https://partner.sberbank-school.ru/programs/9718/item/369292

Пропустил, есть разность T-SQL и SQL

#Проверочное ограничение уровня таблицы
https://partner.sberbank-school.ru/programs/9718/item/369293

Пропустил, есть разность T-SQL и SQL



