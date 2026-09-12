/* 1. Count frequencies using HashMap. 2. Create buckets (size = n + 1). 3. Put each number into its frequency bucket. 4. Create result array. 5. Traverse buckets from back (highest frequency). 6. Stop after collecting k numbers. */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> box= new HashMap<>();
        List<Integer>[] freq= new List[nums.length+1];

        for(int i=0; i<freq.length; i++){
            freq[i]= new ArrayList<>();
        }
        for(int n : nums){
            box.put(n,box.getOrDefault(n,0)+1);
        }
        for (Map.Entry<Integer, Integer> Entry: box.entrySet()){
            freq[Entry.getValue()].add(Entry.getKey());
        }
        int []result= new int[k];
        int index=0;
        for(int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                result[index++] = n;
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
/*class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // HashMap to store each number and how many times it appears.
        HashMap<Integer, Integer> count = new HashMap<>();

        // Bucket array where index = frequency.
        // Size is nums.length + 1 because max frequency can be nums.length.
        List<Integer>[] freq = new List[nums.length + 1];

        // Create an empty ArrayList in every bucket.
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Count frequency of every number in the array.
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Put each number into the bucket of its frequency.
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        // Result array to store top k frequent numbers.
        int[] res = new int[k];

        // Points to the next position in result array.
        int index = 0;

        // Traverse buckets from highest frequency to lowest.
        for (int i = freq.length - 1; i > 0 && index < k; i--) {

            // Take every number present in the current bucket.
            for (int n : freq[i]) {

                // Add the number to the result array.
                res[index++] = n;

                // Stop once we have collected k numbers.
                if (index == k) {
                    return res;
                }
            }
        }

        // Return result (backup return if loop finishes).
        return res;
    }
} */
