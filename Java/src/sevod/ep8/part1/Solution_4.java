package sevod.ep8.part1;

public class Solution_4 {
    public static void main(String[] args) {
        Food food = new Food();
        Selectable selectable = new Food();
        Food newFood = (Food) selectable;
        foodMethods(food);
        selectableMethods(selectable);
    }
    public static void foodMethods(Food food) {
        //тут добавьте вызов методов для переменной food
        food.onEat();
    }
    public static void selectableMethods(Selectable selectable) {
        //тут добавьте вызов методов для переменной selectable
        selectable.onSelect();
    }
    interface Selectable {
        void onSelect();
    }
    static class Food implements Selectable {
        @Override
        public void onSelect() {
            System.out.println("The food was selected");
        }
        public void onEat() {
            System.out.println("The food was eaten");
        }
    }
}
