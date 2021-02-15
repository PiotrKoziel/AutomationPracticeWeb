package helper;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AggregatedAsserts {

        private static final String NEW_LINE = System.lineSeparator();
        private List<Error> errors = new ArrayList<>();
        private boolean printStackTraces = false;

        public void assertEquals(String message, Object expected, Object actual) {
            try {
                Assert.assertEquals(message, expected, actual);
            } catch (AssertionError e) {
                errors.add(e);
            }
        }

        public void assertTrue(String message, boolean condition) {
            try {
                Assert.assertTrue(message, condition);
            } catch (AssertionError e) {
                errors.add(e);
            }
        }


        public void assertNotNull(String message, Object object) {
            try {
                Assert.assertNotNull(message, object);
            } catch (AssertionError e) {
                errors.add(e);
            }
        }


        public void fail(String message) {
            try {
                Assert.fail(message);
            } catch (AssertionError e) {
                errors.add(e);
            }
        }


        public void processAllAssertions() {
            if (errors.isEmpty()) {
                System.out.println("No Assertion errors were thrown"); //replace with Logger if desired
            } else {
                StringBuilder msgBuilder = new StringBuilder();
                for (Error error : errors) {
                    msgBuilder.append(NEW_LINE);
                    msgBuilder.append(AssertionError.class.getSimpleName());
                    msgBuilder.append(" ");
                    msgBuilder.append(errors.indexOf(error) + 1);
                    msgBuilder.append(": ");
                    if (printStackTraces) {
                        msgBuilder.append(NEW_LINE);
                        msgBuilder.append(ExceptionUtils.getStackTrace(error)); //converts stack trace to String
                    } else {
                        msgBuilder.append(error.getMessage());
                    }
                }
                Assert.fail(errors.size() + " " + AssertionError.class.getSimpleName() + "(s) were thrown:" + NEW_LINE
                        + msgBuilder.toString());
            }
        }

        public void includeStackTraces() {

            this.printStackTraces = true;
        }

}



