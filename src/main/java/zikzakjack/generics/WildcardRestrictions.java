package zikzakjack.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardRestrictions {

	public static void main(String[] args) {

		List<Number> nums = new ArrayList<Number>();
		List<? super Number> sink = nums;
		List<? extends Number> source = nums;

		for (int i = 0; i < 10; i++)
			sink.add(i);

		double sum = 0;
		for (Number num : source)
			sum += num.doubleValue();

		System.out.println("source = " + source);
		System.out.println("sink = " + sink);

		/**
		 * 
		 * 1. no wildcard allowed in instance creation
		 * 
		 * 2. In Generic method calls, If an explicit type parameter is passed, it must
		 * not be a wildcard:
		 * 
		 * 3. In a class declaration, if the supertype or any superinterface has type
		 * parameters, these types must not be wildcards.
		 * 
		 */

	}

}
