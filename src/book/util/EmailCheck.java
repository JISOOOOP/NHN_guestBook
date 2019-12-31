package book.util;

import java.util.regex.Pattern;

public class EmailCheck {
    public static boolean checkEmail(String email){
        if(email == null) {
            return false;
        }
        return Pattern.matches(
                "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+",
                email.trim());
    }
}
