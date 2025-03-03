import java.util.HashMap;
import java.util.Map;

class Merge2D{
    static void mergeArrays(int[][] nums1, int[][] nums2){
            
        int[] count = new int[1001];

        for(int[] pair : nums1){
            count[pair[0]] += pair[1];
        }
        for(int[] pair : nums2){
            count[pair[0]] += pair[1];
        }

        int size = 0;
        for(int freq : count){
            if(freq > 0) size++;
        }

        int[][] ans = new int[size][2];

        for(int i = 0, index = 0; i < count.length; i++){
            if(count[i] > 0){
                ans[index++] = new int[] {i, count[i]};
            }
        }

        for(int[] arr : ans){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] nums1 = {{1,2},{2,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};
        mergeArrays(nums1, nums2);
    }
}