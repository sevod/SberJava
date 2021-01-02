https://partner.sberbank-school.ru/programs/9718/item/369256
#SELECT  И сортировка
**DISTINCT уникальные поля
```SELECT DISTINCT 
speed,
ram
FROM PC
```

**ORDER BY упорядочивание, 
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
**сортировка по двум полям
```
SELECT DISTINCT speed, ram
FROM PC
ORDER BY ram DESC, speed DESC;
```
**WHERE горизонтальная выборка.
```
SELECT DISTINCT speed, ram
FROM PC
WHERE price < 500
ORDER BY 2 DESC;
```
**Сортировка по дате с использованием CONVERT.
Перед сортировкой все преобразуется в строку.
```
SELECT date
FROM Battles
ORDER BY CONVERT(CHAR(5),date,110);
```
**Сортировка по дате с использованием функций MONTH и DAY
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