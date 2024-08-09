class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int i = 0, j = 0;
        while (i < arr1.length || j < arr2.length) {
            int sol = -1;
            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    sol = arr1[i];
                    i++;
                } else {
                    sol = arr2[j];
                    j++;
                }
            } else if (i < arr1.length) {
                sol = arr1[i];
                i++;
            } else {
                sol = arr2[j];
                j++;
            }
            k--;
            if (k == 0) {
                return sol;
            }
        }
        return -1;
    }
}