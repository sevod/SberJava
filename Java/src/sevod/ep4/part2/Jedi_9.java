package sevod.ep4.part2;

public class Jedi_9 {
    public static void main(String[] args) {
        // напишите тут ваш код
        Jedi joda = new Jedi("Joda", true, 150);
        Jedi obi = new Jedi("Obi", true, 50, "joda");
        Jedi anikin = new Jedi("Anikin", true, 25, "Obi");

        System.out.println(joda);
        System.out.println(obi);
        System.out.println(anikin);
    }

    public static class Jedi {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        String teacher;

        public Jedi(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Jedi(String name, boolean sex, int age, String teacher) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.teacher = teacher;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            if (this.teacher != null) {
                text += ", учитель: " + this.teacher;
            }
            return text;
        }
    }
}
