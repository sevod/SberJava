package sevod.ep5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Starwars_9 {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(1);
        set.add(3);
        set.add(12);
        set.add(22);
        set.add(4);
        set.add(5);
        set.add(32);
        set.add(2);
        set.add(6);
        return set;
    }
    public static Set<Integer> removeGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            if (iterator.next() > 10)
                iterator.remove();
        }
        return set;
    }
    public static void main(String[] args) {
        Set<Integer> set = createSet();
        removeGreaterThan10(set);
    }
}
