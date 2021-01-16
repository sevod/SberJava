package sevod.ep5.part2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution_12 {
    public static void main(String[] args) {
    }
    static class MyException extends IOException {
    }
    static class MyException2 extends FileNotFoundException {
    }
    static class MyException3 extends IndexOutOfBoundsException {
    }
    static class MyException4 extends ArithmeticException {
    }
}
