package zikzakjack.generics;

import java.util.Arrays;
import java.util.List;

public class Arrays_Covariant_Generics_Invariant_Example {

	public static void main(String[] args) {

		// array subtyping is covariant, meaning that type S[] is considered to be a
		// subtype of T[] whenever S is a subtype of T.

		Integer[] ints_arr = new Integer[] { 1, 2, 3, 4, 5 };
		Number[] nums_arr = ints_arr; // According to substitution principle, this assignment is legal
		nums_arr[2] = 3.14; // array store exception
		assert Arrays.toString(ints_arr).equals("[1, 2, 3.14, 4, 5]"); // uh oh!

		/**
		 * 
		 * When the above Integer array is allocated, it is tagged with (reified type)
		 * runtime representation of Integer. and everytime an array is assigned into,
		 * an array store exception is raised if the reified type is not compatible with
		 * the assigned value
		 * 
		 */

		// generics subtyping is invariant, meaning that type List<S> is not considered
		// to be a subtype of List<T> even though S is a subtype of T.

		List<Integer> ints_gen = Arrays.asList(1, 2, 3);
//		List<Number> nums_gen = ints_gen; // compile-time error :: Type mismatch: cannot convert from List<Integer> to List<Number>
//		nums_gen.set(2, 3.14);
//		assert ints_gen.toString().equals("[1, 2, 3.14]"); // uh oh!

		// Wildcards reintroduce covariant subtyping for generics, in that type List<S>
		// is considered to be a subtype of List<? extends T> when S is a subtype of T.

		List<Integer> ints_gen1 = Arrays.asList(1, 2, 3);
		List<? extends Number> nums_gen1 = ints_gen1;
//		nums_gen1.set(2, 3.14); // compile-time error
		assert ints_gen1.toString().equals("[1, 2, 3.14]"); // uh oh!

		/**
		 * 
		 * The assignment violates the Get and Put Principle, because you cannot put a
		 * value into a type declared with an extends wildcard.
		 * 
		 */
	}

}
