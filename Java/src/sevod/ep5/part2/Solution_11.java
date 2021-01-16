package sevod.ep5.part2;

public class Solution_11 {
    public static void main(String[] args) {
        handleExceptions(new Solution_11());
    }

    public static void handleExceptions(Solution_11 obj) {
        for (int i = 0; i < 3; i++) {
            try {
                if (i == 0)
                    obj.method1();
                if (i == 1)
                    obj.method2();
                if (i == 2)
                    obj.method3();
            } catch (RuntimeException e) {
                printStack(e);
            }catch (Exception e){

            }
        }
    }

    public static void printStack(Throwable throwable) {
        System.out.println(throwable);
        for (StackTraceElement element : throwable.getStackTrace()) {
            System.out.println(element);
        }
    }

    public void method1() {
        throw new NullPointerException();
    }

    public void method2() {
        throw new IndexOutOfBoundsException();
    }

    public void method3() {
        throw new NumberFormatException();
    }
}
