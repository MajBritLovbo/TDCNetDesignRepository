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
		LocalDateTime ldt = LocalDateTime.ofInstant(last_time, ZoneId.systemDefault());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd / HH:mm:ss");

		System.out.println(ldt.format(formatter));
	} 
} 
