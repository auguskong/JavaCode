// 允许出现重复值


class NumberAndIndex {
    public int number, index;
    public NumberAndIndex(int number, int index) {
        this.number = number;
        this.index = index;
    }
}

public class RandomizedCollection {
    // pair.number is the number, pair.index is the index in map value
    private List<NumberAndIndex> nums;
    // key is the number, value if the indices list in nums;
    private Map<Integer, List<Integer>> map;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean existed = map.containsKey(val);

        if (!existed) {
            map.put(val, new ArrayList<Integer>());
        }
        List<Integer> indices = map.get(val);
        indices.add(nums.size());
        nums.add(new NumberAndIndex(val, indices.size() - 1));

        return !existed;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        List<Integer> indices = map.get(val);
        int index = indices.get(indices.size() - 1);

        NumberAndIndex numIndex = nums.get(nums.size() - 1);
        nums.set(index, numIndex);
        nums.remove(nums.size() - 1);
        map.get(numIndex.number).set(numIndex.index, index);

        indices.remove(indices.size() - 1);
        if (indices.size() == 0) {
            map.remove(val);
        }

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int index = rand.nextInt(nums.size());
        return nums.get(index).number;
    }
}

// 使用LinkedHashSet来实现
public class RandomizedCollection {
    ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> locs;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Set<Integer>>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) locs.put( val, new LinkedHashSet<Integer>() );
        locs.get(val).add(nums.size());
        nums.add(val);
        return ! contain ;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        int loc = locs.get(val).iterator().next();
        locs.get(val).remove(loc);
        if (loc < nums.size() - 1 ) {
           int lastone = nums.get( nums.size()-1 );
           nums.set( loc , lastone );
           locs.get(lastone).remove( nums.size()-1);
           locs.get(lastone).add(loc);
        }
        nums.remove(nums.size() - 1);

        if (locs.get(val).isEmpty()) locs.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}