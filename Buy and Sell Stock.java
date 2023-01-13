// Buy and Sell Stock
import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        int ans = Solution.bestTimeToBuyAndSell(n,a);
        System.out.println(ans);
    }
    
}
 
 
class Solution {
  static int bestTimeToBuyAndSell(int n, int[] prices) {
	int aux[] = new int[n];	
	  int max = Integer.MIN_VALUE;
	  int maxprofit = Integer.MIN_VALUE;
	  for(int i=n-1; i>=0;i--){
		  max = Math.max(max, prices[i]);
		  aux[i] = max;
	  }
	  for(int i=0; i<n; i++){
		  maxprofit = Math.max(maxprofit, aux[i] - prices[i]);
	  }
	  return maxprofit;
  }
}
