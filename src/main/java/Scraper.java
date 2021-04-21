package JavaClass;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scraper {
    List<String> extractEmails(String url) throws IOException {
        ArrayList<String> email = new ArrayList<>();
        URL website = new URL(url);
        Scanner sc = new Scanner(website.openStream());
        StringBuffer sb = new StringBuffer();
        while (sc.hasNext()) { sb.append(sc.next()); }
        String result = sb.toString();
        Matcher m = Pattern.compile("(mailto:([a-z0-9.@A-Z]+))").matcher(result);
        while (m.find()) { email.add(m.group(2)); }
        return email;
    }

    public static void main(String[] args) throws IOException {
        Scraper n = new Scraper();
        ArrayList<String> a = (ArrayList<String>) n.extractEmails("https://lcm.touro.edu/about-us/contact-us/");
        for (String s : a) {
            System.out.println(s);
        }
    }
}