package sevod.ep7.part2;

public class Solution_1 {
    public static void main(String[] args) throws Exception {
    }

    public class Screen implements Selectable, Updatable{
        @Override
        public void onSelect() {
            
        }

        @Override
        public void refresh() {

        }
    }

    interface Selectable{
        void onSelect();
    }

    interface Updatable{
        void refresh();
    }
}
