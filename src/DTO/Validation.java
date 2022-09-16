package DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Validation {

    public static boolean isValidEmail(String emailAddrToValidate) {
        final String emailValidationRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailValidationRegex, emailAddrToValidate);
    }

    public static boolean validateJavaDate(String strDate) {
        if (strDate.trim().equals("")) {
            return true;
        } else {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy/MM/dd");
            sdfrmt.setLenient(false);
            try {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate + " is valid date format");
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }

    public static Date dateFromString(String strDate) {
        SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy/MM/dd");
        sdfrmt.setLenient(false);
        try {
            return sdfrmt.parse(strDate);
        } catch (ParseException e) {
            System.out.println(strDate + " is Invalid Date format");
            return null;
        }
    }

    public static boolean validarRut(int rut, char dv) {

        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;

        }
        return Character.toUpperCase(dv) == (char) (s != 0 ? s + 47 : 75);
    }
}
