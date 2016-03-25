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

		initFrequency();
		run();
	}

	private static void setFrequency(int newTime) {
		frequency=newTime*1000;		
	} 

	private static void setClock(Clock clock){
		cl=clock;
	}

	private static void initFrequency(){
		System.out.println("How often shall the program update time(in seconds) n"); 

		boolean succes=false;
		String input;
		while(!succes){
			try { 
				input=bufferRead.readLine(); 

				try{ 
					int newTime =Integer.parseInt(input); 
					setFrequency(newTime); 
					succes=true;
				} catch(IllegalArgumentException e){ 
					//e.printStackTrace(); 
				} 

			} catch (IOException e1) {  
				//e1.printStackTrace(); 
			} finally{
				input="";
				if(!succes){
					System.out.println("Choose a integre number to continue...");
				}
			}
		}
	}

	private static void run(){
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
	}
}
