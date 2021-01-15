package sevod.ep3.part2;

public class Enemy_8 {
    String name;
    int count;
    public static void main(String[] args) {
        Enemy_8 enemy = new Enemy_8();
        System.out.println("Enemy name: \"" + enemy.name + "\"\nCount of midichlorians: " + enemy.count);
    }
    //напишите тут ваш код


    public Enemy_8() {
        this.name = "Anakin Skywalker";
        this.count = 20000;
    }
}
