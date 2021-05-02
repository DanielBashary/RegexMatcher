import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExMatcher {

    public boolean isProperName(String name) {
        Pattern pattern = Pattern.compile("[A-Z][a-z]+");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public boolean isInteger(String number) {
        Pattern pattern = Pattern.compile("^[+-][0][.][0-9]+$|^[+-][1-9][0-9]+[.][0-9]+$|^[1-9][0-9]+" +
                "[.][0-9]+$|^[0][.][0-9]+$|^[0]$|^[+-][1-9][0-9]+$|^[1-9][0-9]+$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public boolean isAncestor(String person) {
        Pattern pattern = Pattern.compile("^(([great-]+)?grand)?father$|^(([great-]+)?grand)?mother$");
        Matcher matcher = pattern.matcher(person);
        return matcher.matches();
    }

    public boolean isPalindrome(String pal) { //todo check null and ""
        if(pal == null || pal.length() < 2){return false;}
        Pattern pattern = Pattern.compile("^(.?)(.?)(.?)(.?)(.?)(.?)(.?)\\6\\5\\4\\3\\2\\1$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(pal);
        return matcher.matches();
    }
}
