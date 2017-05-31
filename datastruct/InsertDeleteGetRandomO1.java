package datastruct;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomO1 {

	private Set<Integer> set;
	
	/** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        set = new HashSet<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!set.contains(val)){
        	set.add(val);
        	return true;
        }else {
			return false;
		}
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.contains(val)){
        	set.remove(val);
        	return true;
        }else {
			return false;
		}
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	Random random = new Random();    	
    	int index = random.nextInt(set.size());    	
    	int count = 0;
    	int ans = 0;
    	Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
        	if(count == index){
        		ans = iterator.next();
        		break;
        	}
        	count ++;
        	iterator.next();
        }
        return ans;
    }
    
    public static void main(String[] args) {
		InsertDeleteGetRandomO1 randomO1 = new InsertDeleteGetRandomO1();
		randomO1.insert(1);
		randomO1.insert(10);
		randomO1.insert(20);
		randomO1.insert(30);
		System.out.println(randomO1.getRandom());
		System.out.println(randomO1.getRandom());
		System.out.println(randomO1.getRandom());
		System.out.println(randomO1.getRandom());
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
