
public class Person {

	private String lastName;
	private String firstName;
	private int birthYear;

	public int getAge() {

		int year=java.util.Calendar.getInstance().get
				(java.util.Calendar.YEAR);
		return year-birthYear;
	}

	public String getName() {
		return firstName+" "+lastName;
	}

	public void setName(String l, String f) {
		lastName = l;
		firstName = f;
	}

	public void setAge(int age) {

		int year=java.util.Calendar.getInstance().get
				(java.util.Calendar.YEAR);

		birthYear = year-age;
	}

	public boolean sameAge(Person other) {
		return birthYear == other.birthYear;
	}

}

