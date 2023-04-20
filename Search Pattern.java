// https://course.acciojob.com/idle?question=7e2f8ed3-69ab-4d0c-ad56-467a99335a5b

import java.util.*;

class Solution {

	public int[] computelps (String pat){
		int len =0,  i =1, m = pat.length();
		int lps[] = new int[m];
		lps[0] =0;
		while(i<m){
			if(pat.charAt(i) == pat.charAt(len)){
				len++;
				lps[i] = len;
				i++;
			}
			else{
				if(len!= 0){
					len = lps[len -1];
				}
				else lps[i++] = len;
			}
		}
		return lps;
	}
    public ArrayList<Integer> FindIndices(String a, String b) {
        //Write your code here
		int n = a.length();
		int m = b.length();
		int i=0;
		int j = 0;
		ArrayList <Integer> ans = new ArrayList<>();
		int lps[] = computelps(b);
		boolean found = false;
		while((n-i) >= (m-j)){
			if(a.charAt(i) == b.charAt(j)){
				i++; j++;
			}
			if(j == m){
				found = true;
				ans.add(i-j+1);
				j = lps[j-1];
			}
			else if(i<n && a.charAt(i) != b.charAt(j)){
				if(j!=0){
					j = lps[j-1];
				}
				else i++;
			}
		}
		if(found == false){
			ans.add(-1);
		}
		return ans;

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
	    Solution Obj = new Solution();
        ArrayList<Integer> ans = Obj.FindIndices(a, b);
        for(int x : ans)
            System.out.print(x + " ");
    }
}
