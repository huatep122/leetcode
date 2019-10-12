class Solution {
    public int climbStairs(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        int x1=1;
        int x2=2;
        int x3=0;
        for (int i = 2; i < n; i++) {
            x3= x1+x2;
            x1=x2;
            x2=x3;
        }         
        return x3;  
    }
}