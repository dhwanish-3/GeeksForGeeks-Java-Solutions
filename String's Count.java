class Solution 
{ 
    static long countStr(long n)
	{
	    long all_a = 1;
        long at_most_one_b = n;
        long at_most_one_c = n;
        long exactly_one_b_and_one_c = n * (n - 1);
        long exactly_two_c = (n * (n - 1)) / 2;
        long one_b_and_two_c = (n * (n - 1) * (n - 2)) / 2;
        return all_a + at_most_one_b + at_most_one_c + exactly_one_b_and_one_c + exactly_two_c + one_b_and_two_c;
	}
}