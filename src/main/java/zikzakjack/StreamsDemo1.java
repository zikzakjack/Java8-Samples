package zikzakjack;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class StreamsDemo1 {

	public static void main(String[] args) throws Exception {
		List<Integer> numSource = Arrays.asList(-5, -3, -1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6,
				6, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0);
		String[] wordSource = { "Hello", "World", "Bye", "World" };

		List<Integer> evenNumsList = numSource.stream().filter(i -> i % 2 == 0).collect(toList());
		System.out.print("\nevenNumsList: ");
		evenNumsList.forEach(s -> System.out.printf("%s ", s));

		List<Integer> distinctEvenNumsList = numSource.stream().filter(i -> i % 2 == 0).distinct().collect(toList());
		System.out.print("\ndistinctEvenNumsList: ");
		distinctEvenNumsList.forEach(s -> System.out.printf("%s ", s));

		List<Integer> truncatedList = numSource.stream().limit(3).collect(toList());
		System.out.print("\ntruncatedList: ");
		truncatedList.forEach(s -> System.out.printf("%s ", s));

		List<Integer> skippedList = numSource.stream().skip(3).collect(toList());
		System.out.print("\nskippedList: ");
		skippedList.forEach(s -> System.out.printf("%s ", s));

		List<Double> distinctNumsSqrtList = numSource.stream().skip(3).distinct().map(Math::sqrt).collect(toList());
		System.out.print("\ndistinctNumsSqrtList: ");
		distinctNumsSqrtList.forEach(s -> System.out.printf("%.2f ", s));

		List<String[]> wordsArray = Arrays.stream(wordSource).map(word -> word.split("")).distinct().collect(toList());
		System.out.print("\nwordsArray: ");
		wordsArray.forEach(System.out::print);

		List<String> wordsStream = Arrays.stream(wordSource).map(word -> word.split("")).flatMap(Arrays::stream)
				.distinct().collect(toList());
		System.out.print("\nwordsStream: ");
		wordsStream.forEach(s -> System.out.printf("%s ", s));

		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<String> numPairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> "(" + i + "," + j + ")"))
				.collect(toList());
		System.out.print("\nnumPairs: ");
		numPairs.forEach(s -> System.out.printf("%s ", s));

		List<String> numPairsDivsBy3 = numbers1.stream()
				.flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> "(" + i + "," + j + ")"))
				.collect(toList());
		System.out.print("\nnumPairsDivsBy3: ");
		numPairsDivsBy3.forEach(s -> System.out.printf("%s ", s));

	}

}
