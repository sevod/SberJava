###Чтение с клавиатуры
````
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    int age = scanner.nextInt();
    System.out.println(name);
    System.out.println(age);
````

finalize() срабатывает при удалении обьекта

    protected void finalize() throws Throwable{
    }