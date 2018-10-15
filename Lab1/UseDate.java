
public class UseDate {

	public static void main(String[] args) {

		CS211DateObject day1 = new CS211DateObject("September",12, 1998);
		System.out.println(day1);
		day1.setMonth("February");
		System.out.println(day1);
		day1.setYear(2016);
	        System.out.println(day1.leapYear());
		day1.setYear(2015);
		System.out.println(day1.leapYear());
		day1.setYear(2016);
		System.out.println("Testing Days:");
		System.out.println(day1);
		System.out.println(day1.daysInMonth());
		day1.setMonth("December");
		System.out.println(day1);
		System.out.println(day1.daysInMonth());
		System.out.println("Testing make tomorrow:");
		day1.makeTomorrow();
		System.out.println(day1);
		day1.makeTomorrow(25);
		System.out.println(day1);	
	        System.out.println("Testing Generate Copy");
		CS211DateObject newDate = day1.generateCopy();
		System.out.println(day1.sameDate(newDate));
		System.out.println("Testing Generate Tomorrow");
		CS211DateObject test = day1.generateTomorrow();
		System.out.println(day1);
		System.out.println(test);

		
		

	}


}
