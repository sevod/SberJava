package sevod.ep5;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Starwars_6 {
    public static void main(String[] args) {
        System.out.println(getInsertTime(new ArrayList()));
        System.out.println(getInsertTime(new LinkedList()));
    }
    public static long getInsertTime(List list) {
        // напишите тут ваш код
        Date time1 = new Date();
        insert10000(list);
        // напишите тут ваш код
        Date time2 = new Date();
        long time = time2.getTime() - time1.getTime();
        return time;
    }
    public static void insert10000(List list) {
        for (int i = 0; i < 100000; i++) {
            list.add(0, new Object());
        }
    }
}
