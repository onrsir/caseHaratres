public class MergeString {

    public static String merge(String a, String b) {
        if (a.length() < 1 || a.length() > 2500 || b.length() < 1 || b.length() > 2500) {
            throw new IllegalArgumentException("Geçersiz değer");
        }

        StringBuilder result = new StringBuilder();

        int maxLength = Math.max(a.length(), b.length());

        for (int i = 0; i < maxLength; i++) {
            if (i < a.length()) {
                result.append(a.charAt(i));
            }
            if (i < b.length()) {
                result.append(b.charAt(i));
            }
        }

        return result.toString();
    }

}
