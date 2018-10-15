public class CS211DateObject {

	// These are instance fields - each instance of CS211DateObject has
	// its own set

	private int day;
	private int year;
	private int month; //January = 1

	// you might find this array helpful

	private String[] months = {"January","February","March","April",
			"May","June","July","August","September",
			"October","November","December"};

	/*
	 * Note: You must store the month as an int, and January must be 1
	 * If you want to store the String month as well, you must be sure
	 * that when the program changes one, it also changes the other.
	 * */

	public CS211DateObject(String m, int d, int y) {
		setDate(m,d,y);
	}
	
	public void setDay(int d) {
		day = d;
	}

	public void setMonth(String m) {
	    switch(m){
	    case "January": month = 0; break;
	    case "February": month = 1; break;
	    case "March": month = 2; break;
	    case "April": month = 3; break;
	    case "May": month = 4; break;
	    case "June": month = 5; break;
	    case "July": month = 6; break;
	    case "August": month = 7; break;
	    case "September": month = 8; break;
	    case "October": month = 9; break;
	    case "November": month = 10; break;
	    case "December": month = 11; break;
	    }
	}

	public void setYear(int y) {
		year = y;
	}

	public void setDate(String month, int day, int year) {
		setMonth(month);
		setDay(day);
		setYear(year);		
	}

    public boolean leapYear()
    {
	if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
		return true;
	    } else {
		return false;
	    }
    }

    public String toString()
    {
	return ("Month: " + months[month] + " Day: " + day + " Year: " + year);
    }

	public int daysInMonth() {
	    if(month == 0 || month == 2 || month == 4 || month == 6 ||
	       month == 7 || month == 9 || month == 11) {
		return 31;
	    } else if(month == 1 && this.leapYear()) {
		return 29; 
	    } else if(month == 1) {
		return 28;
	    } else {
		return 30;
	    }
	}

	public void makeTomorrow() {
	    if(this.daysInMonth() == day) {
		if(month == 11) {
		    year++;
		    month = 0;
		    day = 1;
		} else {
		    month++;
		    day = 1;
		}
	    } else {
		day++;
	    }
	}

	public void makeTomorrow(int n) {
	    for(int i = 0; i < n; i ++) {
		this.makeTomorrow();
	    }
	}

	public CS211DateObject generateCopy() {
	    int newDay = day;
	    String newMonth = months[month];
	    int newYear = year;
	    return new CS211DateObject(newMonth, newDay, newYear);
	}

	public boolean sameDate(CS211DateObject obj) {
	    if (this.day == obj.day && months[month].equals(obj.months[month])
		&& this.year == obj.year) {
		return true;
	    } else { 
		return false;
	    }
	}

	public CS211DateObject generateTomorrow() {
	    CS211DateObject tomCopy = new CS211DateObject(months[month],day,year);
	    tomCopy.makeTomorrow();
	    return tomCopy;
	}
}