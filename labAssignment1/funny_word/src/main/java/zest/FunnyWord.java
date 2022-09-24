package zest;

/**
 * Solution inspired by: https://www.geeksforgeeks.org/funny-string/
 */
class FunnyWord {
    boolean checkFunny(String word) {
        if (word.length() < 11) {
            int i = 1;
            int j = word.length() - 2;
            word = word.toLowerCase();
            while (i <= j) {
                if ((Math.abs(word.charAt(i) - word.charAt(i - 1))) !=
                        Math.abs((word.charAt(j) - word.charAt(j + 1))))
                    return false;
                i++;
                j--;
            }
            return true;
        } else {
            return false;
        }
    }
}
