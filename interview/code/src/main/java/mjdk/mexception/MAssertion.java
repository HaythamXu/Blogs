package mjdk.mexception;

public class MAssertion {

    public static void testAssertionSucess() {
        assert 1 > 0;
    }

    public static void testAssertionFailed() {
        try {
            assert 0 > 1;
        } catch (Error e) {
            // assertionError 是Error的子类，可以背Error捕获
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MAssertion.testAssertionSucess();
        MAssertion.testAssertionFailed();
    }
}
