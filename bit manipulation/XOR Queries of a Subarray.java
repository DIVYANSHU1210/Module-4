import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	  public static void main(String[] args) throws Throwable {
		  Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int q = sc.nextInt();
	        int [] arr= new int[n];
	        for(int i=0;i<n;i++){
	            arr[i]=sc.nextInt();
	        }
	        int [][] queries= new int[q][2];
	        for(int i=0;i<q;i++){
	            for(int j=0;j<2;j++){
	                queries[i][j]=sc.nextInt();
	            }
	        }
	        Solution Obj= new Solution();
	        
	        int [] result = Obj.xorQueries(arr,queries);
	        for(int i=0;i<result.length;i++){
	            System.out.print(result[i]+" ");
	    }
	}
}
	
class Solution{
  
	 public static int[] xorQueries(int[] A, int[][] queries) {
	    int xor = A[0]; 
		int []px= new int[A.length];
		 px[0] = A[0];
		for(int i=1; i<A.length; i++){
			xor = xor^A[i];
			px[i] = xor;
		}

		int ans [] = new int [queries.length];
		for(int i=0; i<queries.length; i++){
			int a = queries[i][0];
			int b = queries[i][1];
			if(a ==0){
				ans[i] = px[b];
			}
			else{
				ans[i] =  px[b] ^ px[a-1];
			}
 		}
		return ans;
	}   
}
