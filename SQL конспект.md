https://partner.sberbank-school.ru/programs/9718/item/369256
#SELECT  И сортировка
**DISTINCT уникальные поля
SELECT DISTINCT 
speed,
ram
FROM PC

**ORDER BY упорядочивание, 
DESC по убыванию
ASC по возрастанию
SELECT DISTINCT speed, ram
FROM PC
ORDER BY ram DESC;
 или
SELECT DISTINCT speed, ram
FROM PC
ORDER BY 2 DESC;

**сортировка по двум полям
SELECT DISTINCT speed, ram
FROM PC
ORDER BY ram DESC, speed DESC;

**WHERE горизонтальная выборка.
SELECT DISTINCT speed, ram
FROM PC
WHERE price < 500
ORDER BY 2 DESC;

**Сортировка по дате с использованием CONVERT.
Перед сортировкой все преобразуется в строку.
SELECT date
FROM Battles
ORDER BY CONVERT(CHAR(5),date,110);

**Сортировка по дате с использованием функций MONTH и DAY
SELECT 
	DAY(date) BD_day, 
	DATENAME(mm, date) BD_month, 
	name
FROM Battles
ORDER BY MONTH(date), DAY(date);

#Предикаты.
https://partner.sberbank-school.ru/programs/9718/item/369257
**Приоритеты NOT AND OR 
Есть упоминание INTERSECT и UNION

**BETWEEN между
SELECT model, speed
FROM PC
WHERE price BETWEEN 400 AND 600;

**IN -  в 
SELECT model, speed, hd
FROM PC
WHERE hd IN (10, 20) AND
 model IN (SELECT model
 FROM product
 WHERE maker = 'A');

**LIKE - подобно, сравнение строк
_ любой единичный символ
% последовательность символов или ничего
SELECT *
FROM Ships
WHERE class NOT LIKE '%go' AND
 class LIKE '%o' ; 

ESCAPE "Трафаретный символ"
LIKE '25|%' ESCAPE '|' --ищем %
'%#_%' ESCAPE '#'      --ищем _


**LIKE и регулярные выражения
---------------------------
https://partner.sberbank-school.ru/programs/9718/item/369257
NULL в условиях поиска
-----------------------
IS [NOT] NULL

SELECT *
FROM PC
WHERE price IS NULL;

WHERE price = NULL ЭТО ОШИБКА

Упоминается CASE

https://partner.sberbank-school.ru/programs/11906/item/460438
#Переименование столбцов
**AS
SELECT ram AS Mb, hd Gb
FROM PC
WHERE cd = '24x';

**можно расположить поясняющую информацию рядом с соответствующим значением
SELECT ram, 'Mb' AS ram_units, hd, 'Gb' AS hd_units
FROM PC
WHERE cd = '24x';

**Ограничители
*в данном случае символьную константу 'SELECT' в столбце с именем SELECT. 
SELECT 'SELECT' "SELECT";

https://partner.sberbank-school.ru/programs/11906/item/460439
#Получение итоговых значений

*COUNT(*) - Возвращает количество строк источника записей (учитывает NULL)

*COUNT Возвращает количество значений в указанном столбце
SELECT COUNT(model) AS Qty_model
FROM Product
WHERE maker = 'A';
*SUM Возвращает сумму значений в указанном столбце (только для чисел)

*AVG Возвращает среднее значение в указанном столбце (только для чисел)

*MIN Возвращает минимальное значение в указанном столбце
SELECT 
	MIN(price) AS Min_price,
    MAX(price) AS Max_price
FROM PC;
*MAX Возвращает максимальное значение в указанном столбце

* Так же можно использовать DISTINCT по умолчанию ALL

#GROUP BY используется для определения групп выходных строк, к которым могут применяться агрегатные функции (COUNT, MIN, MAX, AVG и SUM).
SELECT 
	model, 
	COUNT(model) AS Qty_model,
    AVG(price) AS Avg_price
FROM PC
GROUP BY model;
* NULL-значения - все такие строки попадут в одну группу.
* Результат выполнения функции COUNT есть целое число (INTEGER). Другие агрегатные функции наследуют типы данных обрабатываемых значений.
* Если при выполнении функции SUM будет получен результат, превышающий максимально возможное значение для используемого типа данных, возникает ошибка.

#Предложение HAVING
*HAVING применяется после группировки для определения аналогичного предиката
SELECT 
	model, 
	COUNT(model) AS Qty_model,
	AVG(price) AS Avg_price
FROM PC
GROUP BY model
HAVING AVG(price) < 800;

#порядок обработки предложений в операторе SELECT:

1.FROM
2.WHERE
3.GROUP BY
4.HAVING
5.SELECT
6.ORDER BY

#ROLLUP
*Получение итоговых данных с помощью оператора ROLLUP
SELECT 
	CASE 
		WHEN point IS NULL THEN 'ALL' 
		ELSE CAST(point AS varchar) 
	END point,
SUM(inc) Qty
FROM Income 
GROUP BY point WITH ROLLUP;

*Если СУБД не поддерживает конструкцию ROLLUP, можно использовать либо UNION, либо _внешнее_ соединение (FULL JOIN)

SELECT 
	CAST(point AS varchar) point, 
	SUM(inc) Qty
FROM Income GROUP BY point
UNION ALL
SELECT 
	'ALL' AS point, 
	SUM(inc) AS Qty
FROM Income;

*Сортировка и NULL-значения

SELECT TOP 1 WITH ties model
FROM PC_
WHERE price IS NOT NULL  #УЧИТЫВАЕМ NULL занчения! исключаем их
ORDER BY price;

*Агрегатная функция от агрегатной функции
как пример

SELECT MAX(avg_price)
FROM (SELECT 
		AVG(price) avg_price
		FROM 
			Product P JOIN PC 
			ON P.model = PC.model
		GROUP BY maker
	) X;

*Укажите количество имеющихся различных моделей ПК, выпускаемых производителем А.
вопрос плохо понятен, но пусть будет так.

SELECT 
	COUNT(DISTINCT model) AS model
	FROM PC
	WHERE model IN 
	(SELECT 
		model
	FROM Product
WHERE type = 'PC' AND maker = 'A')






