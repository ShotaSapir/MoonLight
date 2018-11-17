package com.example.yarden.moonlight;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputVerifications {

    private static final int Phone_LENGTH = 10;



    public static String CheckNameValiduty(String name) {
        name.trim();
        if (name.isEmpty())
            return "The name cant be empty";
        if (name.contains(" ")) {
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) < (int)'a' || name.charAt(i) > (int)'z' )
                    if( name.charAt(i) != ' ') {
                        return "Please include only valid characters";
                    }
                else if(name.charAt(i)== ' ')
                {
                    if(name.charAt(i+1) < (int)'a' || name.charAt(i+1) > (int)'z')
                        return "Please enter last name and with one space only after first name";
                }
            }
            return "true";
        } else
            return "Please use space between first and last name";
    }

    public static String CheckEmailAddress(String mail) {
        String notValidMail = "Enter email in format example@example.com";
        if(mail.isEmpty())
            return  notValidMail;
        boolean isValidMail = isValid(mail);
         if (!mail.contains("@"))
            return notValidMail;
        else if (!mail.contains(".com"))
            return notValidMail;
        else if (!isValidMail)
            return notValidMail;
        else
            return "true";
    }

    public static String CheckPassword(String password) {
        String passwordMessage = "Password must contain minimum 8 letters and include upper and lower letter and special character";
        if(password.isEmpty())
            return passwordMessage;
        boolean passwordValidator = validate(password);
         if (!passwordValidator)
            return passwordMessage;         else
            return "true";

    }

    public static boolean validate(String password) {

        return true;
    }

    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static String CheckPhone(String phone) {
        if(phone.isEmpty())
            return "please enter phone number";
        if (phone.charAt(0) != '0')
            return " Phone number must start with 0";

        if (phone.length() > Phone_LENGTH) {
            if (phone.contains("-"))
                return "Please remove the character '-'";
        } else if (phone.length() < Phone_LENGTH) {
            return "The phone number must include 10 digits";
        } else {
            for (int i = 0; i < phone.length(); i++) {
                if (phone.charAt(i) < '0' || phone.charAt(i) > '9')
                    return "Please include only 10 digits";
            }
        }
        return "true";

    }

    public static String CheckBirthDate(String birthDate) {
        String dateFormat =  "Please enter date in format : dd/mm/yyyy";
        if(birthDate.isEmpty())
            return dateFormat;
        boolean valodator = validateDate(birthDate);
        if (!valodator)
            return dateFormat;
        else
            return "true";

    }


    private static boolean validateDate(String date) {

        String regEx =
                "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        Matcher matcherObj = Pattern.compile(regEx).matcher(date);
        if (matcherObj.matches())
            return true;
        else
            return false;
    }



}
