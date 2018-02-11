package zikzakjack;

import java.util.Optional;
import java.util.Properties;

public class OptionalDemo {

	public static void main(String[] args) {
		Person person = new Person();
		try {
		System.out.println("InsuranceName : " + person.getCar().getInsurance().getName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/*************************************************************
		 * Create empty Optional Objects from static factory method
		 *************************************************************/
		PersonOpt personOpt = new PersonOpt();
		personOpt.setCarOpt(Optional.empty());
		System.out.println("\n* Create empty Optional Objects from static factory method");
		System.out.println("CarOpt : " + personOpt.getCarOpt());
		System.out.println("CarOpt : " + personOpt.getCarOpt().isPresent());

		/*************************************************************
		 * Create Optional Objects from a non null value
		 *************************************************************/
		PersonOpt personOpt1 = new PersonOpt();
		personOpt1.setCarOpt(Optional.of(new CarOpt()));
		System.out.println("\n* Create Optional Objects from a non null value");
		System.out.println("CarOpt : " + personOpt1.getCarOpt());
		System.out.println("CarOpt : " + personOpt1.getCarOpt().isPresent());

		/*************************************************************
		 * Create Optional Objects from a null value
		 *************************************************************/
		PersonOpt personOpt2 = new PersonOpt();
		CarOpt carOpt = null;
		personOpt2.setCarOpt(Optional.ofNullable(carOpt));
		System.out.println("\n* Create Optional Objects from a null value");
		System.out.println("CarOpt : " + personOpt2.getCarOpt());
		System.out.println("CarOpt : " + personOpt2.getCarOpt().isPresent());

		/*************************************************************
		 * Extracting value from Optionals
		 *************************************************************/
		PersonOpt person3 = new PersonOpt();
		CarOpt car3 = new CarOpt();
		InsuranceOpt insurance3 = new InsuranceOpt();

		Optional<InsuranceOpt> insuranceOpt3 = Optional.of(insurance3);
		Optional<CarOpt> carOpt3 = Optional.of(car3);
		Optional<PersonOpt> personOpt3 = Optional.of(person3);
		
		car3.setInsuranceOpt(insuranceOpt3);
		person3.setCarOpt(carOpt3);
		
		System.out.println("\n* Extracting value from Optionals");
		System.out.println(insuranceOpt3.map(InsuranceOpt::getNameOpt));
		insurance3.setNameOpt(null);
		System.out.println(insuranceOpt3.map(InsuranceOpt::getNameOpt));

		/*************************************************************
		 * Chaining Optional objects with flatMap
		 *************************************************************/
		System.out.println("\n* Chaining Optional objects with flatMap");
		String insuranceName = personOpt3.flatMap(PersonOpt::getCarOpt).flatMap(CarOpt::getInsuranceOpt).map(InsuranceOpt::getNameOpt).orElse("UNKNOWN");
		System.out.println("insuranceName : " + insuranceName);
		// reset as we need the data again
		insurance3.setNameOpt("NewName");
		insuranceName = personOpt3.flatMap(PersonOpt::getCarOpt).flatMap(CarOpt::getInsuranceOpt).map(InsuranceOpt::getNameOpt).orElse("UNKNOWN");
		System.out.println("insuranceName : " + insuranceName);

		/*************************************************************
		 * Putting it all together
		 *************************************************************/
		System.out.println("\n* Putting it all together");
		Properties props = new Properties();
		props.setProperty("a", "5");
		props.setProperty("b", "true");
		props.setProperty("c", "-3");
		System.out.println("Output : " + readDuration(props,"a"));
		System.out.println("Output : " + readDuration(props,"b"));
		System.out.println("Output : " + readDuration(props,"c"));
	}

	/**
	 * Return a positive integer only for a valid String representing a positive
	 * integer, otherwise return zero
	 * 
	 * @param props
	 * @param name
	 * @return
	 */
	public static int readDuration(Properties props, String name) {
		return Optional.ofNullable(props.get(name)).map(o -> (String) o).flatMap(OptionalUtil::stringToInt)
				.filter(i -> i > 0).orElse(0);
	}
}

class OptionalUtil {
	public static Optional<Integer> stringToInt(String s) {
		try {
			return Optional.of(Integer.parseInt(s));
		} catch (Exception e) {
			return Optional.empty();
		}
	}
}

class Person {
	Car car;
	public Car getCar() {return car;}
	public void setCar(Car car) {this.car = car;}
}

class Car {
	Insurance insurance;
	public Insurance getInsurance() {return insurance;}
	public void setInsurance(Insurance insurance) {this.insurance = insurance;}
}

class Insurance {
	String name = "itsgotaname";
	public String getName() {return name;}
}

class PersonOpt {
	Optional<CarOpt> carOpt;
	public Optional<CarOpt> getCarOpt() {return carOpt;}
	public void setCarOpt(Optional<CarOpt> carOpt) {this.carOpt = carOpt;}
	
}

class CarOpt {
	Optional<InsuranceOpt> insuranceOpt = Optional.of(new InsuranceOpt());
	public Optional<InsuranceOpt> getInsuranceOpt() {return insuranceOpt;}
	public void setInsuranceOpt(Optional<InsuranceOpt> insuranceOpt) {this.insuranceOpt = insuranceOpt;}
}

class InsuranceOpt {
	String nameOpt = "itsgotaname";
	public String getNameOpt() {return nameOpt;}
	public void setNameOpt(String nameOpt) {this.nameOpt = nameOpt;}
}

