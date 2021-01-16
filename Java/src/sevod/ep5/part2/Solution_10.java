package sevod.ep5.part2;

import java.io.IOException;
import java.rmi.RemoteException;

public class Solution_10 {
    public static void main(String[] args) {
        handleExceptions(new Solution_10());
    }

    public static void handleExceptions(Solution_10 obj) {
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 0:
                        obj.method1();
                    case 1:
                        obj.method2();
                    case 2:
                        obj.method3();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void method1() throws IOException {
        throw new IOException();
    }

    public void method2() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public void method3() throws RemoteException {
        throw new RemoteException();
    }
}
