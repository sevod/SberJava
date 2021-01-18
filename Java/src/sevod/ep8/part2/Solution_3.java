package sevod.ep8.part2;

public class Solution_3 {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }
    public static void printMatrix(int m, int n, String value) {
        System.out.println("fill with String objects");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m){

    }

    public static void printMatrix(int m, int n){

    }
    public static void printMatrix(String value){

    }
    public static void printMatrix(int m, String value){

    }
    public static void printMatrix(String value, int m){

    }
    public static void printMatrix(Object value){

    }
    public static void printMatrix(int m, Object value){

    }
    public static void printMatrix(){

    }


}
