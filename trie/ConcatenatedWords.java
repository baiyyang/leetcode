package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
	
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
    	List<String> ans = new ArrayList<>();    
    	Set<String> set = new HashSet<>();
    	Arrays.sort(words , new Comparator<String>() {
    		public int compare(String s1 , String s2){
    			return s1.length() - s2.length();
    		}
		});
    	for(int i=0;i<words.length;i++){
    		if(solve(words[i], set)){
    			ans.add(words[i]);
    		}
    		set.add(words[i]);
    	}
    	return ans;
	}
    
    public static boolean solve(String word , Set<String> set){
    	if(set.isEmpty()){
    		return false;
    	}else {
    		boolean[] dp = new boolean[word.length() + 1];
    		dp[0] = true;
			for(int i=1;i<=word.length();i++){
				for(int j=0;j<i;j++){
					if(dp[j] == false){
						continue;
					}else {
						if(set.contains(word.substring(j, i))){
							dp[i] = true;
							break;
						}
					}
				}
			}
			return dp[word.length()];
		}
    }
    
    //Ç°×ºÊ÷
    static class Trie{
    	public Trie[] sons = new Trie[26];
    	public boolean isEnd;
    }
	
    //add
    public static void addTrie(String s , Trie root){
    	Trie current = root;
    	for(int i=0;i<s.length();i++){
    		if(current.sons[s.charAt(i) - 'a'] == null){
    			current.sons[s.charAt(i) - 'a'] = new Trie();
    		}
    		current = current.sons[s.charAt(i) - 'a'];
    	}
    	current.isEnd = true;
    }
    
    public static boolean dfs(Trie root , int index , String s , int count){
    	Trie current = root;
    	for(int i = index;i<s.length();i++){
    		if(current.sons[s.charAt(i)-'a'] == null){
    			return false;
    		}    		
			if(current.sons[s.charAt(i) - 'a'].isEnd == true){
				if(i == s.length()-1){
					return count >= 1;
				}
				if(dfs(root, index+1, s, count+1)) {
					return true;
				}
			}			
    		current = current.sons[s.charAt(i)-'a'];
    	}
    	return false;
    }
    
    public static List<String> findAllConcatenatedWordsInADict1(String[] words){    	
    	List<String> ans = new ArrayList<String>();
    	Trie root = new Trie();
    	for(String string : words){
    		addTrie(string, root);
    	}
    	for(String string : words){
    		if(dfs(root, 0, string, 0)){
    			ans.add(string);
    		}
    	}
    	return ans;
    }
    
	public static void main(String[] args) {
		String[] words = new String[]{"c","c","d","ccd"};
		for(String string : findAllConcatenatedWordsInADict1(words)){
			System.out.println(string);
		}
	}

}
