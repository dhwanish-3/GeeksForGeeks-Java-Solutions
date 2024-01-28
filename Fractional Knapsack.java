import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}



class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                double r1 = (double) a.value / a.weight;
                double r2 = (double) b.value / b.weight;
                if (r1 < r2) return 1;
                else if (r1 > r2) return -1;
                else return 0;
            }
        });
        double res = 0.0;
        for (int i = 0; i < n; i++) {
            if (arr[i].weight <= W) {
                res += arr[i].value;
                W -= arr[i].weight;
            } else {
                res += arr[i].value * ((double) W / arr[i].weight);
                break;
            }
        }
        return res;
    }
}