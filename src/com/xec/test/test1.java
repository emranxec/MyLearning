package com.xec.test;

import java.util.HashMap;

public class test1 {

    public static void main(String[] args) {
        char[] s={'i','j','k','l','m','n','o','p','q'};
        //reverseString(s);
        int[] index={2,5,5,11};
        //pivotIndex(index);
        int[] find= new int[2];
        //twoSum(index,10,0,false,find,0);
        twoSum(index,10);


    }

    public static int[] twoSum(int[] nums, int target) {

        //  int[] find= new int[2];
        // return twoSum(nums, target,0,false,find,0);

        HashMap<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            int complement = target-nums[i];
            if (seen.containsKey(complement)) {
                return new int[] {seen.get(complement), i};
            } else {
                seen.put(nums[i], i);
            }
        }

        return new int[]{};

    }



    public static int[] twoSum(int[] nums, int target,int findCouple,boolean isFind,int[] find,int next) {
        //0,4,3,0 = 0

        for(int i=next;i<nums.length;i++){
            if(isFind && findCouple==nums[i]){
                find[1]=i;
                break;
            }
            if(!isFind){
                find[0]=i;
                findCouple=target-nums[i];
                isFind=true;
                twoSum(nums,target,findCouple,isFind,find,i+1);
                if(find[1]!=0){
                    return find;
                }
                isFind=false;
                findCouple=0;
            }

        }
        return find;

    }


    public static void reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            char temp=s[i];
            s[i]=s[s.length-i-1];
            s[s.length-i-1]=temp;
        }
        System.out.println(s);
    }

    public static int pivotIndex(int[] nums) {
        int l=0;
        int pivot=0;
        int r=0;

        for(int i=0;i<nums.length;i++){
            l=0;r=0;pivot=i;

            for(int j=0;j<pivot;j++){
                l+=nums[j];
            }
            for(int k=pivot+1;k<nums.length;k++){
                r+=nums[k];
            }
            if(l==r){
                return pivot;
            }

        }
        return -1;
    }
}