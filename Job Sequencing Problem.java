class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int maxDead = 0;
        for (Job job : arr) {
            maxDead = Math.max(maxDead, job.deadline);
        }
        boolean[] slot = new boolean[maxDead + 1];
        int jobs = 0;
        int totalProfit = 0;
        for (Job job : arr) {
            for (int j = job.deadline; j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    jobs++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        return new int[]{jobs, totalProfit};
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}