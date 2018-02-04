package zikzakjack;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {

	private Long employeeId;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private LocalDate hireDate;

	private String jobId;

	private Double salary;

	private Float commissionPct;

	private Long managerId;

	private String departmentName;

	public Employee() {

	}

	public Employee(String employeeRecord) {
		String[] tokens = employeeRecord.split(",");
		// for (int i = 0; i < tokens.length; i++)
		// System.out.println(i + " = " + tokens[i] + ".");
		this.employeeId = Long.parseLong(tokens[0]);
		this.firstName = tokens[1];
		this.lastName = tokens[2];
		this.email = tokens[3];
		this.phoneNumber = tokens[4];
		this.hireDate = LocalDate.parse(tokens[5], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.jobId = tokens[6];
		this.salary = Double.parseDouble(tokens[7]);
		this.commissionPct = (tokens[8] != null && !tokens[8].trim().equals("")) ? Float.parseFloat(tokens[8]) : null;
		this.managerId = (tokens[9] != null && !tokens[9].trim().equals("")) ? Long.parseLong(tokens[9]) : null;
		this.departmentName = (tokens[10] != null && !tokens[10].trim().equals("")) ? tokens[10] : null;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public Double getSalary() {
		return salary;
	}

	public Float getCommissionPct() {
		return commissionPct;
	}

	public Long getManagerId() {
		return managerId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	@Override
	public String toString() {
		// return "[" + employeeId + " :: " + firstName + " " + lastName + " ::
		// " + departmentName + "]";
		return "" + employeeId;
	}

}
