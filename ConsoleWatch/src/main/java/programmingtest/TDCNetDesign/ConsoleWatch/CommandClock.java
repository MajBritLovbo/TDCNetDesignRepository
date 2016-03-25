package programmingtest.TDCNetDesign.ConsoleWatch;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CommandClock { 
	
	private Instant last_time; 
	
	public CommandClock(Clock cl){ 
		this.last_time=cl.instant();
	} 

	public void printClock(){
		// Setting the new print time
		updateLast_time();
		
		// Converting last_time into LocalDayTime
		LocalDateTime ldt = LocalDateTime.ofInstant(last_time, ZoneId.systemDefault());
		
		// Creating a formating standard
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd / HH:mm:ss");

		// Display the last_time with the standard formatting
		System.out.println(ldt.format(formatter));
	} 
	
	public void setLast_time(Clock cl){
		this.last_time=cl.instant();
	}
	
	public Instant updateLast_time(){
		// Update the time to the current time
		this.last_time=Clock.systemUTC().instant();
		return last_time;
	}
} 
