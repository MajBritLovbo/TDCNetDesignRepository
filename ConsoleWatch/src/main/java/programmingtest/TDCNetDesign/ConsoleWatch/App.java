package programmingtest.TDCNetDesign.ConsoleWatch;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) 
	{ 
		// Define the clock
		Clock cl=Clock.systemUTC(); 
		CommandClock cc = new CommandClock(cl); 
		
		int i; 
		for(i=1; i<4; i++){ 
			//update time + print
			cc.printClock();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//  print out error if interrupted during sleep 
				e.printStackTrace();
			}
		} 
		System.out.println("The claim that it is a fun date today are " + cc.funDate() );
	} 
}
