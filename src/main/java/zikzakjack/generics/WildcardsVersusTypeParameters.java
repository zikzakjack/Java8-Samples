package zikzakjack.generics;

import java.util.Arrays;
import java.util.List;

public class WildcardsVersusTypeParameters {

	public static void main(String... args) {

		// <?> stands for <? extends Object>

		Object obj_w1 = "one";
		List<Object> objs_w1 = Arrays.<Object>asList("one", 2, 3.14, 4);
		List<Integer> ints_w1 = Arrays.asList(2, 4);

		assert objs_w1.contains(obj_w1);
		System.out.println(objs_w1.contains(obj_w1));

		assert objs_w1.containsAll(ints_w1);
		System.out.println(objs_w1.containsAll(ints_w1));

		assert !ints_w1.contains(obj_w1);
		System.out.println(ints_w1.contains(obj_w1));

		assert !ints_w1.containsAll(objs_w1);
		System.out.println(ints_w1.containsAll(objs_w1));

		Object obj_w2 = 1;
		List<Object> objs_w2 = Arrays.<Object>asList(1, 3);
		List<Integer> ints_w2 = Arrays.asList(1, 2, 3, 4);

		assert ints_w2.contains(obj_w2);
		System.out.println(ints_w2.contains(obj_w2));

		assert ints_w2.containsAll(objs_w2);
		System.out.println(ints_w2.containsAll(objs_w2));

/*
		Object obj = "one";
		MyList<Object> objs = MyList.<Object>asList("one", 2, 3.14, 4);
		MyList<Integer> ints = MyList.asList(2, 4);
		assert objs.contains(obj);
		assert objs.containsAll(ints)
		assert !ints.contains(obj); // compile-time error
		assert !ints.containsAll(objs); // compile-time error
*/

	}

}

