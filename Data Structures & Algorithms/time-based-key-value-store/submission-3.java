class TimeMap {
    private class Data {
        String value;
        int time;

        Data(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }

    private Map<String, List<Data>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int time) {
        map.computeIfAbsent(key, o -> new ArrayList<>()).add(new Data(value, time));
    }

    public String get(String key, int time) {
        List<Data> list = map.get(key);
        if (list == null)
            return "";

        int left = 0, right = list.size() - 1;
        String ans = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            Data data = list.get(mid);
            if (data.time <= time) {
                ans = data.value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
