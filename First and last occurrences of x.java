import java.util.ArrayList;

class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        ArrayList<Integer> sol = new ArrayList<>(2);
        int first = -1;
        int last = -1;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                first = mid;
            }
            if (arr[mid] >= x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                last = mid;
            }
            if (arr[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        sol.add(first);
        sol.add(last);
        return sol;
    }
}