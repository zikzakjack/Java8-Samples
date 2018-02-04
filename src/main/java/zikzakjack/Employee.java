package zikzakjack;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {

	private Long employeeId;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	// private Date hireDate;
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
//		for (int i = 0; i < tokens.length; i++)
//			System.out.println(i + " = " + tokens[i] + ".");
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

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary="
				+ salary + ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", departmentName="
				+ departmentName + "]";
	}

}
