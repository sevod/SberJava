package sevod.ep4.part1;

public class CloneTroopers_5 {
    private static int cloneCount = 0;
    public CloneTroopers_5() {
        cloneCount++;
    }
    public static int getCloneCount() {
        //напишите тут ваш код
        return cloneCount;
    }
    public static void setCloneCount(int cloneCount) {
        //напишите тут ваш код
        CloneTroopers_5.cloneCount = cloneCount;
    }
    public static void main(String[] args) {
    }
}
