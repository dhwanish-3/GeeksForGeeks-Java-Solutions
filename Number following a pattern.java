class Solution{
    static String printMinNumberForPattern(String S){
        int n = s.length();
        int count = 1;
        char[] sol= new char[n + 1];
        for(int i = 0; i <= n; i++){
            if(i == n || s.charAt(i) == 'I'){
                for(int j = i - 1 ; j >= -1; j--){
                    sol[j + 1]= (char)('0' + count);
                    count++;
                    if(j >= 0 && s.charAt(j) == 'I') {
                        break;
                    }
                }
            }
        }
        return new String(sol);
    }
}
