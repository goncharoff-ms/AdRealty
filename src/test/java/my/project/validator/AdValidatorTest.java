package my.project.validator;

import my.project.domain.Ad;
import my.project.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by max on 12.04.17.
 *
 * @author Max Goncharov
 */


public class AdValidatorTest {

    private AdValidator adValidator;


    private Errors errors = Mockito.mock(Errors.class);

    private Ad adTrue, adFalse;
    @Before
    public void setUp() throws Exception {
        adValidator = new AdValidator();

        adTrue = new Ad();
        adTrue.setName("Русский");
        adFalse = new Ad();
        adFalse.setName("%($");
    }

    @Test
    public void supports() throws Exception {
        boolean tresp = adValidator.supports(Ad.class);
        Assert.assertEquals(true, tresp);

        boolean fresp = adValidator.supports(Objects.class);
        Assert.assertEquals(false, fresp);

    }

    @Test
    public void validate() throws Exception {
        adValidator.validate(adTrue, errors);
        Mockito.verify(errors, Mockito.never()).rejectValue(Mockito.anyString(), Mockito.anyString());

        adValidator.validate(adFalse, errors);
        Mockito.verify(errors, Mockito.times(1)).rejectValue(Mockito.anyString(), Mockito.anyString());

    }

}