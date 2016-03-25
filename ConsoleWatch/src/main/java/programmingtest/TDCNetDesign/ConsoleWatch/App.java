package programmingtest.TDCNetDesign.ConsoleWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	private static int frequency=1; // 1/1000s
	private static BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	private static Clock cl = Clock.systemUTC();
	
	public static void main( String[] args ) 
	{ 
		System.out.println("How often shall the program update time(in seconds) n"); 
		String input;
		try { 
			input=bufferRead.readLine(); 

			try{ 
				int newTime =Integer.parseInt(input); 
				setFrequency(newTime); 
			} catch(IllegalArgumentException e){ 
				e.printStackTrace(); 
			} 

		} catch (IOException e1) {  
			e1.printStackTrace(); 
		} 

		CommandClock cc = new CommandClock(cl); 

		int i; 
		for(i=1; i<4; i++){ 
			//update time + print
			cc.printClock();

			try {
				Thread.sleep(frequency);
			} catch (InterruptedException e) {
				//  print out error if interrupted during sleep 
				e.printStackTrace();
			}
		} 
		System.out.println("The claim that it is a fun date today are " + cc.funDate() );
		LocalDateTime tp = LocalDateTime.now().withDayOfMonth(12);
		Clock newCl = Clock.fixed(tp.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
		cc.printClock(newCl);
		
		
	}

	private static void setFrequency(int newTime) {
		frequency=newTime*1000;		
	} 
	
	private static void setClock(Clock clock){
		cl=clock;
	}
}
