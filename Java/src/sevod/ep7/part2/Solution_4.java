package sevod.ep7.part2;

public class Solution_4 {
    public static void main(String[] args) throws Exception {
        ShirivukTranslator shirivukTranslator = new ShirivukTranslator();
        System.out.println(shirivukTranslator.translate());
    }

    public static abstract class Translator {
        public abstract String getLanguage();

        public String translate() {
            return "I am " + getLanguage() + " translator";
        }
    }

    public static class ShirivukTranslator extends Translator{
        @Override
        public String getLanguage() {
            return "shirivuk";
        }
    }
}
