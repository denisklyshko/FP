package imperative;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PerfectNumber {
	
	public static Set<Integer> divisors1(int n) {
		
		Set<Integer> res = new HashSet<>();
		for (int i = 1; i <= n; i++) 
			if (n % i == 0) 
				res.add(i);
		return res;	
	}
	
	public static Set<Integer> divisors(int n) {
		Set<Integer> tmp =  IntStream.range(1, (int) Math.sqrt(n)+1)
				.boxed()
				.filter(i -> n % i == 0)
				.collect(Collectors.toSet());
		Set<Integer> res = new HashSet<>();
		tmp.forEach((e) -> {
			res.add(e);
			if (n/e != e) res.add(n/e);
		});
		return res;
	}
		
	public static STATE process(int n) {
		return STATE.fromId((IntStream.range(1, n)
			.boxed()
			.filter(i -> n % i == 0)
			.reduce(0, Integer::sum)
			.compareTo(n))); 
	}
	

	public enum STATE {
		PERFECT(0),
		DEFICIENT(-1),
		ABUNDANT(1);
		
		public final int num;
		
		STATE(int num) {
			this.num = num;
		}
		
        public static STATE fromId(int id) {
            return Arrays.stream(STATE.values())
            	.filter(e -> e.num == id)
            	.findFirst()
            	.orElse(null);
        }	
	}
}

