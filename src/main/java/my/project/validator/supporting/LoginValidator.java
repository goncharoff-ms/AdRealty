package my.project.validator.supporting;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created 03.03.17.
 *
 * @autor Max Goncharov
 */
@Component
public class LoginValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String LOGIN_PATTERN =
            "^[_A-Za-z0-9-]{5,20}$";

    public LoginValidator() {
        pattern = Pattern.compile(LOGIN_PATTERN);
    }

    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
