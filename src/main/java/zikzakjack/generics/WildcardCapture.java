package zikzakjack.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardCapture {

	public static void main(String[] args) {

		List<?> list_wild = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list_type = Arrays.asList(1, 2, 3, 4, 5);

		System.out.println("list_wild = " + list_wild);
		System.out.println("list_type = " + list_type);

		reverse(list_wild);
		reverse(list_type);

		System.out.println("reverse list_wild = " + list_wild);
		System.out.println("reverse list_type = " + list_type);

	}

	public static <T> void reverse1(List<T> list) {
		List<T> tmp = new ArrayList<T>(list);
		for (int i = 0; i < list.size(); i++) {
			list.set(i, tmp.get(list.size() - i - 1));
		}
	}

	public static void reverse2(List<?> list) {
		List<Object> tmp = new ArrayList<Object>(list);
		for (int i = 0; i < list.size(); i++) {
//			list.set(i, tmp.get(list.size() - i - 1)); // compile-time error
		}
	}

	public static void reverse(List<?> list) {
		rev(list);
	}

	// T has captured the wildcard
	private static <T> void rev(List<T> list) {
		List<T> tmp = new ArrayList<T>(list);
		for (int i = 0; i < list.size(); i++) {
			list.set(i, tmp.get(list.size() - i - 1));
		}
	}
}
