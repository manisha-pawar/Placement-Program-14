import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][]mat = new int[n][m];
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < m;j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        
        int s = scn.nextInt();
        int r = scn.nextInt();
        
        rotateShell(mat,s,r);
        display(mat);
        
    }
    
    public static void rotateShell(int[][]mat,int s,int r) {
        //1. fill 1d array using 's' shell of matrix
        int[]arr = fill1DArray(mat,s);
        
        //2. rotate this array by 'r'
        rotate(arr,r);
        
        //3. fill 2d 's' shell using rotated array
        fill2dArray(mat,s,arr);
    }
    
    public static int[] fill1DArray(int[][]mat,int s) {
        int n = mat.length;
        int m = mat[0].length;
        
        int rs = s-1;
        int cs = s-1;
        int re = n-s;
        int ce = m-s;
        
        int tes =  2*(re-rs+1) + 2*(ce-cs+1) - 4; //total elements in 's' shell
        
        int[]arr = new int[tes];
        
        int idx = 0;
        
        //left wall
        for(int r = rs ; r <= re;r++) {
            arr[idx] = mat[r][cs];
            idx++;
        }
        cs++;
        
        //bottom wall
        for(int c = cs; c <= ce;c++) {
            arr[idx] = mat[re][c];
            idx++;
        }
        re--;
        
        //right wall
        for(int r=re;r >= rs;r--) {
            arr[idx] = mat[r][ce];
            idx++;
        }
        ce--;
        
        //top wall
        for(int c = ce; c >= cs;c--) {
            arr[idx] = mat[rs][c];
            idx++;
        }
        rs++;
        
        return arr;
    }
    
    public static void reverse(int[]arr,int lo,int hi) {
        while(lo < hi) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            
            lo++;
            hi--;
        }    
    }
    
    public static void rotate(int[]arr,int r) {
        
        int n = arr.length;
        
        r = r % n;
        
        if(r < 0) {
            r = r + n;
        }
        
        reverse(arr,0,n-1);
        reverse(arr,0,r-1);
        reverse(arr,r,n-1);
    }
    
    
    public static void fill2dArray(int[][]mat,int s,int[]arr) {
        int n = mat.length;
        int m = mat[0].length;
        
        int rs = s-1;
        int cs = s-1;
        int re = n-s;
        int ce = m-s;
        
        
        int idx = 0;
        
        //left wall
        for(int r = rs ; r <= re;r++) {
            mat[r][cs] = arr[idx];
            idx++;
        }
        cs++;
        
        //bottom wall
        for(int c = cs; c <= ce;c++) {
            mat[re][c] = arr[idx];
            idx++;
        }
        re--;
        
        //right wall
        for(int r=re;r >= rs;r--) {
            mat[r][ce] = arr[idx];
            idx++;
        }
        ce--;
        
        //top wall
        for(int c = ce; c >= cs;c--) {
            mat[rs][c] = arr[idx];
            idx++;
        }
        rs++;
        
    }
    
    

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}