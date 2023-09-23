class Solution
{
    static int majorityElement(int a[], int size)
    {
        int majority = a[0];
        int votes = 1;
        for (int  i = 1; i < size; i++) {
            if (a[i] == majority) {
                votes++;
            } else {
                votes--;
            }
            if (votes == 0) {
                majority = a[i];
                votes = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == majority) {
                count++;
            }
        }
        return count > (size / 2) ? majority : -1;
    }
}