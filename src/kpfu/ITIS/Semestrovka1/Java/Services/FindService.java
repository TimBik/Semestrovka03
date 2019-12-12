package kpfu.ITIS.Semestrovka1.Java.Services;

public class FindService {
    public boolean prefixFunction(String forPrefix, int chek) {
        int[] prefix = new int[forPrefix.length()];
        for (int i = 1; i < prefix.length; i++) {
            int j = prefix[i - 1];
            while (j > 0 && forPrefix.charAt(j) != forPrefix.charAt(i)) {
                j = prefix[j - 1];
            }
            if (forPrefix.charAt(i) == forPrefix.charAt(j)) {
                j++;
                if (chek <= j) return true;
            }
            prefix[i] = j;

        }
        return false;
    }
}
