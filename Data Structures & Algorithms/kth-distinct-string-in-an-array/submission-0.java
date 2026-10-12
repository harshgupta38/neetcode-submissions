class Solution {
    public String kthDistinct(String[] arr, int k) {
        int n = arr.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                arr[map.get(arr[i])] = "";
                arr[i] = "";
            } else
                map.put(arr[i], i);
        }

        for (int i = 0, j = 0; i < n; i++)
            if (!arr[i].isEmpty()) {
                ++j;
                if (j == k)
                    return arr[i];
            }
        return "";
    }
}