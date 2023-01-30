class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack<>(); 
        int n = nums.length;
        int max =0;
        for(int i=0; i<n; i++){ //create a non decreasing stack from given array
            if(st.empty() || nums[st.peek()]>nums[i]){
                st.push(i);
            }
        }

        for(int i=n-1; i>=0; i--){ //check from last position in arr if th element is greater then peek remove it from stack and create max from it and the array position;
            while(!st.empty() && nums[i]>= nums[st.peek()]){
                int j = st.pop();
                max = Math.max(max, i-j);
            }
        }
        return max;
    }
}
