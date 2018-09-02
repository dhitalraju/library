package com.raju.library.validation;

/**
 *
 * @author raju
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

public class Validator {

    private Validator() {
    }

    public static boolean checkNumeric(String number) {
        return StringUtils.isNumeric(number);
    }

    public static boolean validateEmail(String email) {
        boolean result = true;
        try {
            InternetAddress emailaddr = new InternetAddress(email);
            emailaddr.validate();
        } catch (AddressException exception) {
            System.out.println("ERROR :: " + exception.getMessage());
            result = false;
        }
        return result;
    }

    public static boolean validateEmailUsingCommon(String email) {

        return EmailValidator.getInstance().isValid(email);
    }

    public static boolean validateMobileNumber(String number) {
        String regex = "^\\+?[0-9]{10,25}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
