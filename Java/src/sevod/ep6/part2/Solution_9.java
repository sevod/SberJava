package sevod.ep6.part2;

public class Solution_9 {
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
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }
    }
}
