package my.project.validator;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import my.project.domain.Ad;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class AdValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Ad.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Ad ad = (Ad)target;

        if (!nameValidate(ad.getName())) {
            errors.rejectValue("name", "Не корректный логин!");
        }




    }

    private boolean nameValidate(String name) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9-А-Яа-я]{5,15}$");
        return pattern.matcher(name).matches();
    }
}
