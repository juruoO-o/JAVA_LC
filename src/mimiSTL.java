public class mimiSTL {
    static int lower_bound(int[] nums,int start,int end,int target){
        int mid;
        while (start<end){
            mid = (start + end) >> 1;
            if (nums[mid] < target){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return end;
    }
    static int upper_bound(int[] nums,int start,int end,int target){
        int mid;
        while (start<end){
            mid = (start + end) >> 1;
            if (nums[mid] <= target){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return end;
    }
}
