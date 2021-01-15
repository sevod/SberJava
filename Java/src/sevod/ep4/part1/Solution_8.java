package sevod.ep4.part1;

public class Solution_8 {
    public static class ItsMessage{
        public String getDescription(){
            return "any text";
        }

    }
    public static void printMessage(ItsMessage itsMessage){
        System.out.println(itsMessage.getDescription());
    }

    public static void main(String[] args) {
        printMessage(new ItsMessage());
    }
}
