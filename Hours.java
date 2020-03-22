import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Hours {

	// TODO add hourly rate, week name, and total earnings via read from file and modify
	// TODO a confirm changes verification 

	public static int globalHours = 0;

    public static void main(String[] args) {


    	Scanner scanner = new Scanner(System.in);


    	// entering days worked via scan
    	System.out.printf("Enter work week schedule: ");
    	String inputDaysString = scanner.nextLine();
    	System.out.println( "String read from console is: " + inputDaysString);


    	
    	openFile(processString(inputDaysString), Integer.toString(globalHours));
       
    }

    // check if input string for weekly schedule is valid
    public static void isValidString(){

    }

    // entering times function
    public static String timeEntry(String day){

    	int totalHoursWorked = 0;

    	String hoursWorked = "";

    	Scanner scanner = new Scanner(System.in);

    	System.out.printf("Enter start time for " + day + ": ");
    	String startTime = scanner.nextLine();
    	//System.out.println("start time is: " + startTime);
    	System.out.printf("Enter end time for " + day + ": ");
    	String endTime = scanner.nextLine();
    	//System.out.println("end time is: " + startTime);



    	hoursWorked = day + ": " + startTime + " - " + endTime; //+ " ?convert? : " + newTimeString(startTime) + " to " + newTimeString(endTime);
    	//System.out.println("test: " + hoursWorked);

    	// now count the num of hours worked
    	//dailyHoursCount(converter24(startTime), converter24(endTime));

    	//System.out.println("total work hrs: " + Integer.toString(converter24(endTime) - converter24(startTime))  );

    	totalHoursWorked += (converter24(endTime) - converter24(startTime));
    	globalHours += totalHoursWorked;
    	//System.out.println("T: " + totalHoursWorked);
    	//System.out.println("G: " + globalHours);	
    	//System.out.println(converter24(startTime) + " cc " + converter24(endTime));


    	System.out.println(hoursWorked);
    	System.out.println("Total hours worked: " + Integer.toString(globalHours));

    	return hoursWorked;

    }

    // convert to 24hr clock from string
    public static int converter24(String twelveTime){

    	int time = 0;

    	switch(twelveTime){
    		case "12am":
    			time = 0;
    			break;

    		case "1pm":
    		case "2pm":
    		case "3pm":
    		case "4pm":
    		case "5pm":
    		case "6pm":
    		case "7pm":
    		case "8pm":
    		case "9pm":
    		case "10pm":
    		case "11pm":
    			time = Integer.parseInt(newTimeString(twelveTime)) + 12;
    			break;

    		default:
    			time = Integer.parseInt(newTimeString(twelveTime));
    			break;


    	}

    	return time;
    }

    

    // string size converter for input start/end times
    public static String newTimeString(String inputTime){

    	String newStr = "";

    	// convert sample 4PM to 4
    	if(inputTime.length() == 3){
    		 newStr = inputTime.substring(0,1);
    		 //System.out.println(newStr);
    	}

    	// convert sample 12PM to 12
    	else{
    		 newStr = inputTime.substring(0,2);
    		 //System.out.println(newStr);
    	}

    	return newStr;
    }


    // process valid input string
    public static String processString(String week){


    	int hoursWorked = 0;
    	String day = "";
    	String myWeek = week;
    	String weeklyOutput = "";

    	// iterate through the string
    	for(int i = 0; i < week.length(); i++){

    		char c = myWeek.charAt(i);
    		//System.out.println(c);

    		if(c != '-'){

    			switch(i){

    				// monday
    				case 0:
    					day = "Mon";
    					//System.out.println("Mon");
    					weeklyOutput += timeEntry(day) + "\n";
    					break;

    				// tuesday
    				case 1:
    					day = "Tues";
    					weeklyOutput += timeEntry(day) + "\n";
    					//System.out.println("Tue");
    					break;

    				// wednesday
    				case 2:
    					day = "Wed";
    					//System.out.println("Wed");
    					weeklyOutput += timeEntry(day) + "\n";
    					break;

    				// thursday
    				case 3:
    					day = "Thurs";
    					//System.out.println("Wed");
    					weeklyOutput += timeEntry(day) + "\n";
    					break;

    				// friday
    				case 4:
    					day = "Fri";
    					//System.out.println("Wed");
    					weeklyOutput += timeEntry(day) + "\n";
    					break;

    				// saturday
    				case 5:
    					day = "Sat";
    					//System.out.println("Wed");
    					weeklyOutput += timeEntry(day) + "\n";
    					break;

    				// sunday
    				case 6:
    					day = "Sun";
    					//System.out.println("Wed");
    					weeklyOutput += timeEntry(day) + "\n";
    					break;


    			}
    		}
    	}

    	return weeklyOutput;
    }
	


    // modify text file
	public static void openFile(String workDays, String workHours){
		
		try{
        		String path = "results.txt";
        		File file = new File(path);
        		FileWriter fileWriter = new FileWriter(file,true);
				BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);

        		fileWriter.append("\n\n" + workDays + "\n" + "Total work hours: " + workHours + "\n\n");


        		bufferFileWriter.close();

       			//System.out.println("User Registration Completed");

    		}catch(Exception ex){
        		System.out.println(ex);
    		}
	}


}