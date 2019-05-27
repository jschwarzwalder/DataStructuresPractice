public class TwoSum {

    public int[] twoSumNotOrdered(int[] nums, int target) {
        int[] indexes = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indexes[0] = i;
                    indexes[1] = j;
                    return indexes;
                }
            }
        }
        return indexes;

    }

    public int[] twoSumOrdered(int[] numbers, int target) {
        int[] indexes = new int[2];
        int i = 0;
        int j = numbers.length -1;
        while (i < j ){
            if (numbers[i] + numbers[j] == target) {
                indexes[0] = i+1;
                indexes[1] = j+1;
                return indexes;

            } else if (numbers[i] + numbers[j] < target){
                i++;
            }else if (numbers[i] + numbers[j] > target){
                j--;
            }
        }

        return indexes;
    }
}

