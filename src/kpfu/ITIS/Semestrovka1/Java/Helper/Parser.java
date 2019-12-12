package kpfu.ITIS.Semestrovka1.Java.Helper;

public class Parser {
    public int parse(String ss) {
        String[] ii = (ss).split("");
        String i = "";
        for (String s :
                ii) {
            if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-') i += s;
        }
        return Integer.parseInt(i);
    }
}
