package kpfu.ITIS.Semestrovka1.Java.Helper;

import java.io.UnsupportedEncodingException;

public class Recode {
    public String recode(String s) throws UnsupportedEncodingException {
        return new String(s.getBytes("ISO-8859-1"),"UTF-8");
    }
}
