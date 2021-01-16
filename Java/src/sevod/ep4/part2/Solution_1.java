package sevod.ep4.part2;

import java.io.IOException;

public class Solution_1 {
    public static void main(String[] args) throws Exception {
        int[] array = initArr();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initArr() throws IOException {
        int [] array = new int[] {23, 2, 123, 312, 3, 34, 55, 1, -2, -5, 21, 12, 1, 2, 3, 4, 5, 6, 7, 8};
        return array;
    }

    public static int max(int[] array) {
        int max = array[0];

        for (int i: array){
            if (i > max)
                max = i;
        }
        return max;
    }
}
