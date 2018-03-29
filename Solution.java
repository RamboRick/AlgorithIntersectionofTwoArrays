package leetcode350;
import java.util.HashMap;
import java.util.ArrayList;
//350. Intersection of Two Arrays II
// TreeMap
//时间复杂度: O(nlogn)
//空间复杂度: O(n)
public class Solution {
	public int[] intersect(int[] nums1, int[] nums2){
		
		HashMap<Integer, Integer> arr = new HashMap<Integer, Integer>();
		for(int num : nums1){
			if (!arr.containsKey(num)){
				arr.put(num, 1);
			}else {
				arr.put(num, arr.get(num)+1);
			}
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int num : nums2){
			if(arr.containsKey(num) && arr.get(num)>0){
				result.add(num);
				arr.put(num, arr.get(num)-1);
			}
		}
		
		int[] ret = new int[result.size()];
		int index = 0;
		for(Integer num : result){
			ret[index++] = num;
		}
		return ret;
				
	}
	private static void printArr(int[] arr){
        for(int e: arr)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution()).intersect(nums1, nums2);
        printArr(res);
    }
}
