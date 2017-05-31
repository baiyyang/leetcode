package datastruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomO1Duplicatesallowed {

	private List<Integer> list;
	private Map<Integer, Set<Integer>> map; 
	/** Initialize your data structure here. */
    public InsertDeleteGetRandomO1Duplicatesallowed() {
    	list = new ArrayList<Integer>();
        map = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {    	    	
    	boolean status = map.containsKey(val);
    	if(!status){
    		map.put(val, new HashSet<Integer>());    	
    	}
    	//Ìí¼ÓË÷Òý
		map.get(val).add(list.size());
		list.add(val);
		return !status;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
        	return false;
        }else {
        	if(!map.get(val).contains(list.size() - 1)){
        		int index = map.get(val).iterator().next();
        		int lastVal = list.get(list.size() - 1);        		
        		map.get(lastVal).remove(list.size() - 1);
        		map.get(lastVal).add(index);
        		map.get(val).remove(index);
        		map.get(val).add(list.size() - 1);
        		list.set(index, lastVal);
        	}
        	map.get(val).remove(list.size() - 1);
        	if(map.get(val).size() == 0)
        		map.remove(val);
        	list.remove(list.size() - 1);
        	return true;
		}
    }
    
    /** Get a random element from the collection. */ 
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
    
    public static void main(String[] args) {
		InsertDeleteGetRandomO1Duplicatesallowed random = new InsertDeleteGetRandomO1Duplicatesallowed();
		System.out.println(random.insert(9));
		System.out.println(random.insert(9));
		System.out.println(random.insert(1));
		System.out.println(random.insert(1));
		System.out.println(random.insert(2));
		System.out.println(random.insert(1));
		System.out.println(random.remove(2));
		System.out.println(random.remove(1));
		System.out.println(random.remove(1));
		System.out.println(random.insert(9));
		System.out.println(random.remove(1));
	}
}
