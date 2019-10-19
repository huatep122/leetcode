class Solution {
    //动态规划
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
    //Binets
    public int climbStairs1(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        int[][] base = {{1,1},{1,0}};
        int[][] result = matrixPower(base,n-2);
        return 2*result[0][0] + result[0][1];
    }

    public int[][] matrixPower(int[][] m, int p){
        int[][] result= new int[m.length][m[0].length];
        //先将结果设置为单位阵
        for (int i = 0; i < result.length; i++) {
            result[i][i] = 1;
        }
        int[][] temp = m;
        for(;p!=0;p>>=1){
            if ((p&1) == 1) {
                result = matrixMult(result,temp);
            }
            //不管p最低位是否为1，都要扩大temp
            temp = matrixMult(temp,temp);
        }
        return result;
    }

    public int[][] matrixMult(int[][] m1, int[][] m2){
        int[][] result = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m1[0].length;k++){
                    result[i][j] += m1[i][k]*m2[k][j];
                }
            }
        }
        return result;
    }
}