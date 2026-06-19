package Tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        RegistrationTest.class,
        LoginTest.class,
        CalculationTest.class,
        CalculationHistoryTest.class,
        EditCalculationTest.class,
        DeleteCalculationTest.class
})
public class FullTestSuite {
}