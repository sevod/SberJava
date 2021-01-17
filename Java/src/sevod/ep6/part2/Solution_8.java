package sevod.ep6.part2;

public class Solution_8 {
    public static void main(String[] args) {
    }
    public class Jedi {
        private String name;
        private int age;
        private String rank;
        private int power;
        public Jedi(String name, int age, String rank, int power) {
            this.name = name;
            this.age = age;
            this.rank = rank;
            this.power = power;
        }
        private String getName() {
            return name;
        }
        private void setName(String name) {
            this.name = name;
        }
        private int getAge() {
            return age;
        }
        private void setAge(int age) {
            this.age = age;
        }
        public int getPower() {
            return power;
        }
        private void setPower(int power) {
            this.power = power;
        }
        private boolean Duel(Sith sith) {
            return this.power > sith.getPower();
        }
    }
    public class Sith {
        private String name;
        private int age;
        private String rank;
        private int power;

        public Sith(String name, int age, String rank, int power) {
            this.name = name;
            this.age = age;
            this.rank = rank;
            this.power = power;
        }

        private String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        private int getAge() {
            return age;
        }

        private void setAge(int age) {
            this.age = age;
        }

        public int getPower() {
            return power;
        }

        private void setPower(int power) {
            this.power = power;
        }

        private boolean Duel(Jedi jedi) {
            return this.power > jedi.getPower();
        }
    }
}
