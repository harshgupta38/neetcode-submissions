class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0, count1 = 0;
        int num2 = 0, count2 = 0;

        for (int num : nums) {
            if (count1 == 0) {
                num1 = num;
            } else if (count2 == 0) {
                num2 = num;
            }

            if (num == num1)
                ++count1;
            else if (num == num2)
                ++count2;
            else {
                --count1;
                --count2;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == num1)
                ++count1;
            else if (num == num2)
                ++count2;
        }
        int min = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        if (count1 > min)
            list.add(num1);
        if (count2 > min)
            list.add(num2);
        return list;
    }
}