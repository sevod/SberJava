package sevod.ep5.part1;

import java.util.HashMap;
import java.util.Map;

public class Starwars_10 {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Obi", "Wan");
        map.put("Sky", "Worker");
        map.put("Luke", "Worker");
        return map;
    }
    public static int getCountFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int res = 0;
        for(Map.Entry<String, String> m: map.entrySet()){
            if (m.getKey().equals(name))
                res++;
        }
        return res;
    }
    public static int getCountLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int res = 0;
        for(Map.Entry<String, String> m: map.entrySet()){
            if (m.getValue().equals(lastName))
                res++;
        }
        return res;
    }
    public static void main(String[] args) {
        Map<String, String> map = createMap();
        System.out.println(getCountFirstName(map, "Luke"));
        System.out.println(getCountLastName(map, "Worker"));
    }
}
