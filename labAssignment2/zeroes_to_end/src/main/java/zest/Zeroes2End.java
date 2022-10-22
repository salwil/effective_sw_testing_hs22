package zest;

/**
 * Solution inspired by: https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/math/NumberUtils.html#max-long-long-long-
 */
class Zeroes2End {

    public int[] pushZeroesToEnd(int arr[], int n) {
        if(n == 0 || arr.length != n){
            int temp[] = {};
            return temp;
        }
        int temp[] = new int[n];
        int t = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                temp[t] = arr[i];
                t += 1;
            }
        }
        while (t < arr.length){
            temp[t] = 0;
            t += 1;
        }
        return temp;
    }
}
