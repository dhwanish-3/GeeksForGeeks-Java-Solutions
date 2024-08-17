class Solution {
    public int sumOfMiddleElements(int[] a1 , int[] a2) {
       // code here
       List<Integer> arr1 = new ArrayList<Integer>();
       List<Integer> arr2 = new ArrayList<Integer>();
       
       for(int i : a1) arr1.add(i);
       for(int i : a2) arr2.add(i);
       int n = arr1.size();
       int l = 0, r = n - 1;
       int total = 2 * n;
       while (l <= r) {
           int m1 = (l + r) / 2;
           int m2 = n - m1 - 2;
           int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
           int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
           if (m1 + 1 < n) r1 = arr1.get(m1 + 1);
           if (m2 + 1 < n) r2 = arr2.get(m2 + 1);
           if (m1 >= 0) l1 = arr1.get(m1);
           if (m2 >= 0) l2 = arr2.get(m2);
           if (l1 <= r2 && r1 >= l2) {
               // if (n % 2 == 1) return Math.max(l1, l2);
               return Math.max(l1, l2) + Math.min(r1, r2);
           } else if (l1 > r2) {
               r = m1 - 1;
           } else {
               l = m1 + 1;
           }
       }
       return 0; // This case will never occur for valid input
   }
}