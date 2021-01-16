package sevod.ep5.part1;

import java.util.HashMap;
import java.util.Map;

public class Starwars_3 {
    public static void main(String[] args) throws Exception {
        String[] heroes = new String[]{"leia", "luke", "obi-wan", "solo", "anakin", "sidius", "yoda", "chewbacca", "windu", "vader"};
        Map<String, Hero> map = addHeroesToMap(heroes);
        for (Map.Entry<String, Hero> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
    public static Map<String, Hero> addHeroesToMap(String[] heroes) {
        //напишите тут ваш код
        Map<String, Hero> her = new HashMap<>();
        for (String hero:heroes){
            her.put(hero, new Hero(hero));
        }
        return her;
    }
    public static class Hero {
        String name;
        public Hero(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name != null ? name.toUpperCase() : null;
        }
    }
}
