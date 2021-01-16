package sevod.ep5;

import java.util.HashMap;
import java.util.Map;

public class Starwars_2 {
    public static void main(String[] args) {
        //напишите тут ваш код
        Map<String, String> pars = new HashMap<>();
        pars.put("leia", "organa");
        pars.put("luke", "skywalker");
        pars.put("general", "hux");
        pars.put("captain", "phasma");
        pars.put("darth", "veider");
        pars.put("obi-wan", "kenobi");
        pars.put("anakin", "skywalker");
        pars.put("jar-jar", "binks");
        pars.put("count", "dooku");
        pars.put("master", "yoda");

        for (Map.Entry<String, String>par:pars.entrySet()){
            System.out.println(par.getKey() + " " + par.getValue());
        }
    }
}
