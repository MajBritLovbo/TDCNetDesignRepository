package programmingtest.TDCNetDesign.ConsoleWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Hello world!
 *
 */
public class App 
{
	private static int frequency=1; // 1/1000s
	private static BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	private static Clock cl = Clock.systemUTC();
	private static CommandClock cc = new CommandClock(cl); 
	private static String input="";

	public static void main( String[] args ) 
	{ 

		initFrequency();
		runProgram();
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

	private static void runProgram(){
		//notifying the user of his options
		printHelp();



		while(true){
			try{
				(new App()).timedInput();
			} catch(Exception e){
				e.printStackTrace();
			}

		} 
	}

	private void execute(String input){
		if (input.equals("Q")){
			//exit the program
			System.out.println("Bye for now");
			System.exit(0);
		}
		else if (input.equals("")){
			//update + print
			cc.printClock();
		}
		else if (input.equals("P")){
			System.out.println("The system has been paused. Press [ENTER] to continue ...");
			try{
				//wait for input
				bufferRead.readLine();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		else if (input.equals("H")){
			printHelp();
		}
	}

	private static void printHelp() {
		System.out.println("\n The avaiable commands are: \n h - Help \n p - Pause system \n q - Quit system \n"); 
	}

	private void timedInput(){
		//create and start timer
		Timer timer = new Timer();

		//wait for input in freqyency 1/1000 seconds, if no input print time, else act on the input
		timer.schedule(task,0,frequency);

		try{
			//Receive input from user
			input = bufferRead.readLine();

		} catch (IOException e){
			e.printStackTrace();
		}
		timer.cancel();
	}

	TimerTask task = new TimerTask(){
		public void run(){
			//convert to upper case
			input=input.toUpperCase();

			//if the input are recognized
			if(input.equals("") || input.equals("H") || input.equals("P") || input.equals("Q")){
				execute(input);
			}

			//reset input
			input="";
		}
	};
}
