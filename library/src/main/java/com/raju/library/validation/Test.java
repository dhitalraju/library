package com.raju.library.validation;

/**
 *
 * @author raju
 */
public class Test {

    public static void checkNumber() {
        String number = "123456789.";
        if (Validator.checkNumeric(number)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    public static void checkEmail() {
        String email = "123@.com";
        if (Validator.validateEmail(email)) {
            System.out.println("Email Test Passed");
        } else {
            System.out.println("Email Test Failed");
        }
    }

    public static void validateEmail() {
        String email = "123..@gmail.com";
        if (Validator.validateEmailUsingCommon(email)) {
            System.out.println("Email Test Passed");
        } else {
            System.out.println("Email Test Failed");
        }
    }

    public static void validateMobileNumber() {
        String number = "+9779851227548.";
        if (Validator.validateMobileNumber(number)) {
            System.out.println("Valid Mobile Number");
        } else {
            System.out.println("Invalid Mobile Number");
        }
    }

    public static void main(String[] args) {
        //Test.checkNumber();
        //Test.checkEmail();
        //Test.validateEmail();
        Test.validateMobileNumber();

    }
}
