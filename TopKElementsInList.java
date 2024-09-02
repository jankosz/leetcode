import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKElementsInList {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            if (count.containsKey(i)) {
                int currentCount = count.get(i);
                count.put(i, ++currentCount);
            } else {
                count.put(i, 1);
            }
        }

        TreeMap<Integer, List<Integer>> sortedByCount = new TreeMap<>();

        for(Map.Entry<Integer, Integer> e : count.entrySet()) {
            int number = e.getKey();
            int numberCount = e.getValue();

            if (sortedByCount.containsKey(numberCount)) {
                List<Integer> list = sortedByCount.get(numberCount);
                list.add(number);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(number);
                sortedByCount.put(numberCount, list);
            }
        }

        List<Integer> result = new ArrayList<>(k);

        while(result.size() < k) {
            Map.Entry<Integer, List<Integer>> topEntry =  sortedByCount.pollLastEntry();
            result.addAll(topEntry.getValue());
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
