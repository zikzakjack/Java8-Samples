package zikzakjack;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class StreamsDemo2 {

	public static void main(String[] args) throws IOException, URISyntaxException {
		System.out.println(LocalDate.parse("17-06-87", DateTimeFormatter.ofPattern("dd-MM-yy")));
		System.out.println(getEmployeeStream().count());
		getEmployeeStream().map(s -> new Employee(s)).forEach(System.out::println);
	}

	private static Stream<String> getEmployeeStream() throws IOException, URISyntaxException {
		return Files.lines(Paths.get(ClassLoader.getSystemResource("employees.dat").toURI()));
	}
}
