package my.project.validator.supporting;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created 03.03.17.
 *
 * @autor Max Goncharov
 */
public class LoginValidatorTest extends TestCase {

    @Test
    public void testMain() {
        LoginValidator loginValidator = new LoginValidator();
        Assert.assertEquals(true, loginValidator.validate("Asd_123Kks"));
    }

}