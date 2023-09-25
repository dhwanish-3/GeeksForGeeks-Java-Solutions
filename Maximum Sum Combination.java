import java.util.*;

class Pair {
    int sum;
    int first;
    int second;
    Pair(int sum, int first, int second) {
        this.sum = sum;
        this.first = first;
        this.second = second;
    }
}

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p, q) -> Integer.compare(q.sum, p.sum));
        Set<String> set = new HashSet<>();
        pq.add(new Pair(A[N - 1] + B[N - 1], N - 1, N - 1));
        int n = N - 1;
        int m = N - 1;
        set.add(n + " " + m);;
        List<Integer> sol = new ArrayList<>();
        while (K > 0) {
            Pair cur = pq.poll(); 
            sol.add(cur.sum);
            int x = cur.first, y = cur.second; 
            if (x - 1 >= 0 && !set.contains((x - 1) + " " + y)) { 
                set.add((x - 1) + " " + y); 
                pq.add(new Pair(A[x - 1] + B[y], x - 1, y)); 
            }
            if (y - 1 >= 0 && !set.contains(x + " " + (y - 1))) { 
                set.add(x + " " + (y - 1)); 
                pq.add(new Pair(A[x] + B[y - 1], x, y - 1)); 
            }
            K--;
        }
        return sol;
    }

    public static void main(String[] args) {
        int N = 17;
        int K = 6;
        int[] A = {371, 349, 552, 343, 331, 721, 46, 572, 512, 469, 890, 608, 917, 719, 830, 104, 159};
        int[] B = {681, 150, 595, 597, 209, 778, 666, 965, 203, 658, 273, 404, 389, 898, 847, 253, 959};
        System.out.println(maxCombinations(N, K, A, B));
    }
}