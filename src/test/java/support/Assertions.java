package support;

import java.util.Objects;

public final class Assertions {
    private Assertions() {
    }

    public static void assertEquals(Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError("Expected " + expected + " but was " + actual);
        }
    }

    public static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected condition to be true but was false");
        }
    }

    public static void assertFalse(boolean condition) {
        if (condition) {
            throw new AssertionError("Expected condition to be false but was true");
        }
    }

    public static void assertThrows(Class<? extends Throwable> expectedException, Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable throwable) {
            if (expectedException.isInstance(throwable)) {
                return;
            }
            throw new AssertionError("Expected exception " + expectedException.getName()
                    + " but caught " + throwable.getClass().getName());
        }
        throw new AssertionError("Expected exception " + expectedException.getName() + " but nothing was thrown");
    }
}
