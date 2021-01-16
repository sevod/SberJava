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