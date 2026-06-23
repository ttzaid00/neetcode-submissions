class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result=new int[k];
        HashMap<Integer,Integer> map=new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key: map.keySet()){
            queue.add(key);
            if (queue.size()>k){
                queue.poll();
            }
        }
        for (int j=0;j<k;j++){
            result[j]= queue.poll();
        }


        return result;
    }
}
