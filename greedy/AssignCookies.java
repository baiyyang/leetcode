package greedy;

import java.util.Arrays;

public class AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
        if(g == null || s == null)
        	return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = g.length - 1;
        int j = s.length - 1;
        while(i >= 0 && j >= 0){
        	if(s[j] >= g[i]){
        		count ++;
        		j--;
        		i--;
        	}
        	else {
        		i--;
			}
        }
        return count;
    }
}
