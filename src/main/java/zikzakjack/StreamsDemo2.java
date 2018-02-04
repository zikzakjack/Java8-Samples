package zikzakjack;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.toSet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamsDemo2 {

	public static void main(String[] args) throws IOException, URISyntaxException {

		/**************************************************************************
		 * Reducing and Summarizing Examples - *
		 *************************************************************************/

		System.out.println(getEmployeeStream().count());

		// Counting
		System.out.println("\nEmployees Count :: " + getEmployeeStream().count());

		// Employee with Maximum Salary
		System.out.println("\nEmployee with Maximum Salary :: "
				+ getEmployeeStream().collect(maxBy(comparingDouble(Employee::getSalary))));

		// Total Salary paid to all Employees
		System.out.printf("\nTotal Salary paid to all Employees :: %.2f\n",
				getEmployeeStream().collect(summingDouble(Employee::getSalary)));

		// Average Salary paid to all Employees
		System.out.printf("\nAverage Salary paid to all Employees :: %.2f\n",
				getEmployeeStream().collect(averagingDouble(Employee::getSalary)));

		// Employee Salary Statistics
		System.out.println("\nEmployee Salary Statistics ::"
				+ getEmployeeStream().collect(summarizingDouble(Employee::getSalary)));

		// Joining example
		System.out.println("\n"
				+ getEmployeeStream().map(emp -> emp.getDepartmentName()).distinct().sorted().collect(joining(", ")));

		// Group by department
		System.out.println(
				"\nGroup By Departments :: " + getEmployeeStream().collect(groupingBy(Employee::getDepartmentName)));

		Function<Employee, SalaryLevel> salaryLevelClassifier = emp -> {
			if (emp.getSalary() < 5000)
				return SalaryLevel.K5SUB;
			else if (emp.getSalary() >= 5000 && emp.getSalary() < 10000)
				return SalaryLevel.K5to10;
			else if (emp.getSalary() >= 10000 && emp.getSalary() < 20000)
				return SalaryLevel.K10to20;
			else
				return SalaryLevel.K20UP;
		};

		/**************************************************************************
		 * Grouping Examples - *
		 *************************************************************************/

		// Group by Salary
		Map<SalaryLevel, List<Employee>> employeesBySalaryLevel = getEmployeeStream()
				.collect(groupingBy(salaryLevelClassifier));
		System.out.println("\nGroup by Salary ::" + employeesBySalaryLevel);

		// Group by Department and then by Salary
		Map<String, Map<SalaryLevel, List<Employee>>> employeesByDepartmentThenBySalaryLevel = getEmployeeStream()
				.collect(groupingBy(Employee::getDepartmentName, groupingBy(salaryLevelClassifier)));
		System.out.println("\nGroup by Department and then by Salary ::" + employeesByDepartmentThenBySalaryLevel);

		// Group by Salary
		Map<SalaryLevel, Long> countEmployeesBySalaryLevel = getEmployeeStream()
				.collect(groupingBy(salaryLevelClassifier, counting()));
		System.out.println("\nGroup by Salary & Count ::" + countEmployeesBySalaryLevel);

		// Highest paid Employee in each level
		Map<SalaryLevel, Optional<Employee>> highestPaidEmployeesInEachSalaryLevel = getEmployeeStream()
				.collect(groupingBy(salaryLevelClassifier, maxBy(comparingDouble(Employee::getSalary))));
		System.out.println("\nHighest paid Employee in each level ::" + highestPaidEmployeesInEachSalaryLevel);

		// Highest paid Employee in each level without Optional
		Map<SalaryLevel, Employee> highestPaidEmployeesInEachSalaryLevel1 = getEmployeeStream()
				.collect(groupingBy(salaryLevelClassifier,
						collectingAndThen(maxBy(comparingDouble(Employee::getSalary)), Optional::get)));
		System.out.println("\nHighest paid Employee in each level ::" + highestPaidEmployeesInEachSalaryLevel1);

		// Sum of salaries paid in each department
		Map<String, Double> sumOfSalariesForEachDepartment = getEmployeeStream()
				.collect(groupingBy(Employee::getDepartmentName, summingDouble(Employee::getSalary)));
		System.out.println("\nSum of salaries paid in each department ::" + sumOfSalariesForEachDepartment);

		// What Salary Levels are in each Department
		Map<String, Set<SalaryLevel>> salaryLevelsInEachDept = getEmployeeStream()
				.collect(groupingBy(Employee::getDepartmentName, mapping(salaryLevelClassifier, toSet())));
		System.out.println("\nWhat Salary Levels are in each department :: " + salaryLevelsInEachDept);

		/**************************************************************************
		 * Partitioning Examples - *
		 *************************************************************************/

	}

	private static Stream<Employee> getEmployeeStream() throws IOException, URISyntaxException {
		return Files.lines(Paths.get(ClassLoader.getSystemResource("employees.dat").toURI())).map(s -> new Employee(s));
	}
}

enum SalaryLevel {
	K5SUB, K5to10, K10to20, K20UP
}