package calendar;
import java.util.InputMismatchException;

/*
 * Jacquelyn Gboyor
 * 10/27/17
 * Calender Program
 */
import javax.swing.JOptionPane;
public class Calendar_Program {

	public static void main(String[] args) {
		
		//Declare variables
		int year = 0;
		int days = 0;
		int [] starts = new int [12];
		int startDay = 0;
		int spaces = 0;
		String space = " ";
		String [] months = {"January", "February", "March", "April", "May", "June", 
							"July", "August", "September", "October", "November", "December"};
		
		//Enter Year
		try {
			year = Integer.parseInt(JOptionPane.showInputDialog("What is the current year?"));
		}
		catch(NumberFormatException exception) {
			year = Integer.parseInt(JOptionPane.showInputDialog("Please enter the current year? (Integers Only)"));			
		}
		
		//Enter Start Day
		try {
			startDay = Integer.parseInt(JOptionPane.showInputDialog("What day would you like to start on? \n"
				+ "1 = Sunday \n2 = Monday \n3 = Tuesday \n4 = Wednesday \n5 = Thursday \n6 = Friday \n7 = Saturday"));
		}catch(NumberFormatException exception) {
			startDay = Integer.parseInt(JOptionPane.showInputDialog("What day would you like to start on? \n"
					+ "1 = Sunday \n2 = Monday \n3 = Tuesday \n4 = Wednesday \n5 = Thursday \n6 = Friday \n7 = Saturday"
					+ "\n(Integers Only)"));
		}
		while(startDay < 1 || startDay > 7) {
			startDay = Integer.parseInt(JOptionPane.showInputDialog("Please enter a valid start day. \n"
					+ "1 = Sunday \n2 = Monday \n3 = Tuesday \n4 = Wednesday \n5 = Thursday \n6 = Friday \n7 = Saturday"
					+ "\n(Integers Only)"));
		}
		//Print out The year and Start Day of the year
		System.out.println("Year: " + year);
		switch (startDay) {
			case 1: day_of_week = "Sunday";
				break;
			case 2: day_of_week = "Monday";
				break;
			case 3: day_of_week = "Tuesday";
				break;
			case 4: day_of_week = "Wednesday";
				break;
			case 5: day_of_week = "Thursday";
				break;
			case 6: day_of_week = "Friday";
				break;
			case 7: day_of_week = "Saturday";
				break;
		
		}
		System.out.println("Start Day: " + day_of_week);
		System.out.println();
		
		
		//for loop to print out calendar
		for(int i = 0; i < 12; i++) {
			System.out.println("            " + months[i] + " " + year);
			daysOfWeek();//Call method to get days of the week
			days = monthDays(months, i, days, year); //Call method to get number of days in each month
	
			/**************************************************************/
			/*
			 * To get the correct start day for each month I created an array (starts[]) to hold each new starting day.
			 * Lets say my start day for the year in January is 5(Thursday). 
			 * For the next month of February, I use this formula 'starts[1] = (((starts[0] - 1) + 31) % 7) + 1;'
			 * starts[0] = 5, subtract 1 from that to get the number of days before that start day
			 * add the total(4) to the number of days in the previous month(31) and get 35.
			 * 35 % 7 = 0, then add 1 to shift the start day to the next day of the week so it can fall in-line with
			 * the previous month
			 */
			switch (months[i]) {
				case "January": starts[0] = startDay;
								spaces = numSpaces(i, startDay, starts, spaces);
								startSpace(spaces, space);
								print(days, space, starts, i);
					break;
					/*****************************/
				case "February":starts[1] = (((starts[0] - 1) + 31) % 7) + 1;
								spaces = numSpaces(i, startDay, starts, spaces);
								startSpace(spaces, space);
								print(days, space, starts, i);
					break;
					/*****************************/
				case "March": 	if(year % 4 == 0) {
								starts[2] = (((starts[1] - 1) + 29) % 7) + 1;
								}else {
									starts[2] = (((starts[1] - 1) + 28) % 7) + 1;
								}
								spaces = numSpaces(i, startDay, starts, spaces);
								startSpace(spaces, space);
								print(days, space, starts, i);
					break;
					/*****************************/
				case "April": 	starts[3] = (((starts[2] - 1) + 31) % 7) + 1;
								spaces = numSpaces(i, startDay, starts, spaces);
								startSpace(spaces, space);
								print(days, space, starts, i);
					break;
					/*****************************/
				case "May": 	starts[4] = (((starts[3] - 1) + 30) % 7) + 1;
								spaces = numSpaces(i, startDay, starts, spaces);
								startSpace(spaces, space);
								print(days, space, starts, i);
					break;
					/*****************************/
				case "June": 	starts[5] = (((starts[4] - 1) + 31) % 7) + 1;
								spaces = numSpaces(i, startDay, starts, spaces);
								startSpace(spaces, space);
								print(days, space, starts, i);
					break;
					/*****************************/
				case "July": 	starts[6] = (((starts[5] - 1) + 30) % 7) + 1;
								spaces = numSpaces(i, startDay, starts, spaces);
								startSpace(spaces, space);
								print(days, space, starts, i);
					break;
					/*****************************/
				case "August": 	starts[7] = (((starts[6] - 1) + 31) % 7) + 1;
								spaces = numSpaces(i, startDay, starts, spaces);
								startSpace(spaces, space);
								print(days, space, starts, i);
					break;
					/*****************************/
				case "September": starts[8] = (((starts[7] - 1) + 31) % 7) + 1;
								spaces = numSpaces(i, startDay, starts, spaces);
								startSpace(spaces, space);
								print(days, space, starts, i);
					break;
					/*****************************/
				case "October": starts[9] = (((starts[8] - 1) + 30) % 7) + 1;
								spaces = numSpaces(i, startDay, starts, spaces);
								startSpace(spaces, space);
								print(days, space, starts, i);
					break;
					/*****************************/
				case "November":starts[10] = (((starts[9] - 1) + 31) % 7) + 1;
								spaces = numSpaces(i, startDay, starts, spaces);
								startSpace(spaces, space);
								print(days, space, starts, i);
					break;
					/*****************************/
				case "December":starts[11] = (((starts[10] - 1) + 30) % 7) + 1;
								spaces = numSpaces(i, startDay, starts, spaces);
								startSpace(spaces, space);
								print(days, space, starts, i);
					break;
			}//switch
			System.out.println();
			System.out.println();
			
		}//for
	}//Main
/******************************************************************/
	public static void daysOfWeek() {
		System.out.println(" SUN  MON  TUE  WED  THU  FRI  SAT");
	}//End
/******************************************************************/	
	public static int monthDays(String [] months, int i, int days, int year) {
		switch (months[i]) {
			case "January": days = 31;
				break;
			case "February": if(year % 4 == 0) {
								days = 29;
								}else {
									days = 28;
								}
				break;
			case "March": days = 31;
				break;
			case "April": days = 30;
				break;
			case "May": days = 31;
				break;
			case "June": days = 30;
				break;
			case "July": days = 31;
				break;
			case "August": days = 31;
				break;
			case "September": days = 30;
				break;
			case "October": days = 31;
				break;
			case "November": days = 30;
				break;
			case "December": days = 31;
				break;
		}
		return days;
	}//End
/******************************************************************/
	public static int numSpaces(int i, int startDay, int [] starts, int spaces) {
		switch (starts[i]) {
		case 0: spaces = 0;
			break;
		case 1: spaces = 1;
			break;
		case 2: spaces = 6;
			break;
		case 3: spaces = 11;
			break;
		case 4: spaces = 16;
			break;
		case 5: spaces = 21;
			break;
		case 6: spaces = 26;
			break;
		case 7: spaces = 31;
			break;
		}//switch
		return spaces;
	}//end
/******************************************************************/
public static void print(int days, String space, int [] starts, int i) {
	int increment = 0;
	int counter = 0;
	for(int k = 1; k <= days; k++ ) {
		increment++;
		counter = increment + (starts[i] - 1);
		if(counter % 7 == 0) {
			if(k > 9) {
				System.out.print(space + space + k + space);
				System.out.println();
			}else {
				System.out.print(space + space + k + space + space);
				System.out.println();
			}
		}else {
			if(k > 9) {
				System.out.print(space + space + k + space);
			}else {
				System.out.print(space + space + k + space + space);
			}	
		}//else
	}//for
}//End
/******************************************************************/
public static void startSpace(int spaces, String space) {
	for(int j = 0; j < spaces - 1; j++) {
		System.out.print(space);
	}//for
}//End startSpace

}//Class














