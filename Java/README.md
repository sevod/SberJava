###Чтение с клавиатуры
````
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    int age = scanner.nextInt();
    System.out.println(name);
    System.out.println(age);
````

       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       int i = Integer.parseInt(reader.readLine());

###finalize() срабатывает при удалении обьекта

    protected void finalize() throws Throwable{
    }
    
###Массив

    int[] nums = new int[4];
    OR
    int[] nums = new int[] { 1, 2, 3, 4 };     
    
    int length = nums1.length;
    
    int[][] nums = { { 0, 1, 2 }, { 3, 4, 5 } };
    
###Чтение массива циклом for

    for (int i : nums){                 
        System.out.println(i);
    }    
    
    //чтение духмерного масива
    for (int i = 0; i < nums.length; i++){
        for(int j=0; j < nums[i].length; j++){...
        
###ArrayList
    ArrayList<String> people = new ArrayList<String>();
    people.add("Tom"); //добавление в конец
    people.add(1, "Bob"); //добавление по индексу
    
    people.get(1); //получение по индексу
    people.set(1, "Robert"); //устновка нового значения по индексу
    
    //удаление
    people.remove("Robert");
    people.remove(0);
    
    //провека на наличие
    if(people.contains("Tom")){... 
    
    //обход элементов массива
    for(String person : people){              
                System.out.println(person);
    }
    
Удаление и добавление элементов ArrayList в цикле, через итератор
    
        ListIterator<String> listIterator = strings.listIterator();
        while (listIterator.hasNext()){
            str = listIterator.next();
            if (str.contains("d") && !str.contains("j"))
                listIterator.remove();
            else if (str.contains("s") && !str.contains("d"))
                listIterator.add(str);
        }    
        
#Коллекции
https://partner.sberbank-school.ru/programs/9719/item/369503

4 вида. списки (list), множества(set) и словари(map) и очередь(queue)

`List` Списки характерны тем, что это упорядоченная коллекция. Любой элемент имеет свой индекс, то есть определенный номер позиции, на которой он расположен. Списки реализованы через массивы.

`Set` Множества хранят данные в случайном порядке. Не может содержать дубликатов, данные хранятся в единственном экземляре.

`Map` Словари напоминают упорядоченные списки, однако каждому элементу можно присвоить свой уникальный идентификатор. Такая система называется пара "ключ-значение". Ключ - уникальный идентификатор, который не может повторяться.

`Queue` Очереди - особый интерфейс, который дает нам работать только с первыми элементами. Если мы хотим обратиться к следующему, то первый элемент необходимо удалить. 
 
````
Интерфейс	Класс	    Описание
List	    ArrayList	простой список элементов
            LinkedList	связанный список
            Vector	    вектор или динамический массив

Set	        HashSet	    хэш-множество, где каждый элемент обладает уникальным хэш-кодом
            TreeSet	    набор отсортированных элементов в виде дерева

Map	        HashMap	    хэш-словарь
            TreeMap	    словарь в виде дерева
            HashTable	хэш-таблица

Queue	    PriorityQueue	очередь приоритетов

````

###Операции с множествами Set:
   
   1. add() - добавляет элемент в множество
   
   2. remove() - удаляет элемент из множества
   
   3. contains() - определяет, есть ли элемент в множестве
   
   4. size() - возвращает размер множества
   
   5. clear() - удаляет все элементы из коллекции
   
   6. isEmpty() - возвращает true если множество пустое, и false если там есть хотя бы 1 элемент
   ````
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            if (iterator.next() > 10)
                iterator.remove();
        }   
   ````
###Операции со словарями Map:

1. put(K key, V value) - добавляет элемент в карту;

2. get(Object key) - ищет значение по его ключу;

3. remove(Object key) - удаляет значение по его ключу;

4. containsKey(Object key) - спрашивает, есть ли в карте заданный ключ;

5. containsValue(Object value) - спрашивает есть ли в карте заданное значение;

6. size() - возвращает размер карты (количество пар "ключ-значение").

Обход элеметов Map
````
        for (Map.Entry<String, String>par:pars.entrySet()){
            System.out.println(par.getKey() + " " + par.getValue());
        }
````

Класс `LinkedList` обладает методами которые определены в List и Queue, соответственно он соединяет функциональности списков и очередей.
````
add()
addLast()
addFirst()
size()
get()
set()
contains()
remove()
removeFirst()
removeLast()

````

`Date` хранит дату в миллисекундах, которые прошли с 1 января 1970 года.     
    
    Date today = new Date();
    long msDelay = newTime.getTime() - currentTime.getTime(); //вычисляем разницу 
         
    Date yearStartTime = new Date(); 
    yearStartTime.setHours(0); 
    yearStartTime.setMinutes(0); 
    yearStartTime.setSeconds(0); 
    yearStartTime.setDate(1); // первое число 
    yearStartTime.setMonth(0); // месяц январь, нумерация для месяцев 0-11
    
# try-catch
https://partner.sberbank-school.ru/programs/9719/item/369552

    try{                         // используем блок try
      
    }
    catch(Exception e){            // используем блок catch для перехвата ошибки
       
    }
    
`Exception` - это класс ислючений    

контролируемые(cheked) и неконтролируемые(uncheked)

Контролируемые исключения необходимо перехватывать.

    catch (Exception e){
            e.printStackTrace();
    
          