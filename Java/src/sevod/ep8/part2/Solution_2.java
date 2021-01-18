package sevod.ep8.part2;

public class Solution_2 {
    public static void main(String[] args) {
    }
    public static class TransportResistance  {
        private void printlnUsage() {
            System.out.println(Constants.RESISTANCE);
        }
    }

    public static class TransportFirstOrder  {
        private void printlnUsage() {
            System.out.println(Constants.FIRSTORDER);
        }
    }
    public static class MultiTroopTranspor extends TransportResistance{
        private void printlnUsage() {
            //add your code here
            System.out.println(Constants.MTT);
        }
    }

    public static class AllTerrainArmoredTransport extends TransportFirstOrder {
        public void printlnUsage() {
            //add your code here
            System.out.println(Constants.ATAT);
        }
    }

    public static class Constants {
        public static String MTT = "I can transport drones";
        public static String ATAT = "I can shot";
        public static String RESISTANCE = "I am from Resistance";
        public static String FIRSTORDER = "I am from First Order";
    }
}
