class Solution
{
    private static void swap(int a[], int i ,int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void sort012(int a[], int n)
    {
        int mid = 0;
        int low = 0;
        int high = n - 1;
        while (mid <= high) {
            if (a[mid] == 0) {
                swap(a, mid, low);
                low++;
                mid++;
            } else if (a[mid] == 2) {
                swap(a, mid, high);
                high--;
            } else {
                mid++;
            }
        }
    }
    public static void main(String[] args) {
        int a[] = {0, 2, 1, 2, 0};
        sort012(a, a.length);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}