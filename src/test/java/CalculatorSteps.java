import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class CalculatorSteps {

    private Calculator calculator;
    private int number;
    private int result;
    private Exception exception;

    @Given("a number $number")
    public void aNumber(int number) {
        calculator = new Calculator();
        this.number = number;
    }

    @When("we divide it by $number")
    public void devideItBy(int number) {
        try {
            result = calculator.divide(this.number, number);
        }catch (ArithmeticException e) {
            exception = e;
        }
    }

    @Then("the result is $number")
    public void assertResult(int number) {
        assertThat(result, equalTo(number));
    }

    @Then("we get an error")
    public void assertException() {
        assertThat(exception, allOf(notNullValue(), instanceOf(ArithmeticException.class)));
    }

}
