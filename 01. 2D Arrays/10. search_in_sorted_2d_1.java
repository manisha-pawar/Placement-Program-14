import java.util.*;
import java.io.*;

public class Main {

    /*your task is to complete this function which returns true if target exists in the matrix
    else return false*/
    public static boolean search(int[][]matrix,int target) {
        //write your code here
        
        //to find potential row for this target element
        int pr = potential_row(matrix,target);
        
        if(pr == -1) {
            return false;
        }
        
        //to find whether target is actually there in potential row
        boolean ans = isElementPresent(matrix,target,pr);
        
        return ans;
    }
    
    public static int potential_row(int[][]mat,int target) {
        int lo = 0;
        int hi = mat.length-1;
        int lci = mat[0].length-1; //last column index
        
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            
            if(target >= mat[mid][0] && target <= mat[mid][lci]) {
                return mid;
            }
            else if(target < mat[mid][0]) {
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        
        return -1;
    }

    public static boolean isElementPresent(int[][]mat,int target,int r) {
        int lo = 0;
        int hi = mat[0].length-1;
        
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            
            if(mat[r][mid] == target) {
                return true;
            }
            else if(mat[r][mid] > target){
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        
        return false;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][]matrix = new int[m][n];

        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                matrix[i][j] = scn.nextInt();
            }
        }

        int target = scn.nextInt();

        boolean isFound = search(matrix,target);
        System.out.println(isFound);

    }
}