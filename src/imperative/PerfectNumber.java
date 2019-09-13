package imperative;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class PerfectNumber {
	
	public static Set<Integer> divisors(int n) {
		
		Set<Integer> res = new HashSet<>();
		for (int i = 1; i <= n; i++) 
			if (n % i == 0) 
				res.add(i);
		return res;	
	}
	
	public static STATE process(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) 
			if (n % i == 0) 
				sum = sum += i;
		if      (sum < n)  return STATE.DEFICIENT;
		else if (sum > n)  return STATE.ABUNDANT;
		return STATE.PERFECT;
	}
	
	public enum STATE {
		PERFECT,
		DEFICIENT,
		ABUNDANT
	}

}

