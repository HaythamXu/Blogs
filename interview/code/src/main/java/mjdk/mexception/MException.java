package mjdk.mexception;

import java.util.Collection;

public class MException {

    public static void throwException() throws Exception {
        throw new Exception();
    }

    public static void testCatchException() {
        try {
            MException.throwException();
        } catch (Exception e) {
            // current is root caused, get null
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public static void testExceptionSuppressedNotRuntimeException() throws Exception {
        try {
            throw new Exception("exception in try");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            throw new Exception("exception in finally");
        }
    }

    // 异常屏蔽仅仅会在try中抛出非RuntimeException, 并且在catch中被封装为RuntimeException, 且在finally中抛出RuntimeException是发生.
    // Throwable 具有 private List<Throwable> suppressedExceptions， 可以用于存放被屏蔽的异常.
    public static void testExceptionShieldRunTimeException() {
        Exception origin = null;
        try {
            throw new Exception("exception in try");
        } catch (Exception e) {
            origin = new RuntimeException(e);
            throw origin;
        } finally {
            RuntimeException e = new RuntimeException("exception in finally");
            e.addSuppressed(origin);
            throw e;
        }
    }

    public static void testFinally() {
        try {
            System.out.println("try");
            return;
        } finally {
            System.out.println("finally");
        }
    }

    public static void testNullPointerException() {
        Collection<String> strings = null;
    }

    public static void main(String[] args) {
        MException.testFinally();
        MException.testCatchException();
        try { MException.testExceptionSuppressedNotRuntimeException(); } catch (Exception e) { e.printStackTrace(); }
        MException.testExceptionShieldRunTimeException();
    }

}
