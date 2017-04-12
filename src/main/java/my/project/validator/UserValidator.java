package my.project.validator;


import my.project.domain.User;
import my.project.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {


    private final UserService userService;

    @Autowired
    public UserValidator(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User)o;

        if (!loginValidator(user.getLogin())) {
            errors.rejectValue("login", "NotCorrected.userForm.login");
        }

        if (userService.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.userForm.login");
        }

        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if (user.getPassword().length() < 5 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!emailValidator(user.getEmail())) {
            errors.rejectValue("email", "NotCorrected.userForm.email");
        }

    }


    private boolean emailValidator(String string) {
        String emailPattern = "^[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(emailPattern).matcher(string).matches();
    }

    private boolean loginValidator(String s) {
        String loginPattern = "^[_A-Za-z0-9-]{5,15}$";
        return Pattern.compile(loginPattern).matcher(s).matches();
    }

}
