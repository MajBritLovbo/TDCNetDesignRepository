package programmingtest.TDCNetDesign.ConsoleWatch;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( AppTest.class );
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp()
	{
		CommandClock cc = new CommandClock(Clock.systemUTC());
		ZoneId zoneID = ZoneId.systemDefault();

		// The current date and time
		LocalDateTime timePointNow = LocalDateTime.now();

		//set the clock
		Clock clock = Clock.fixed(timePointNow.atZone(zoneID).toInstant(), zoneID);

		//set last_time
		cc.setLast_time(clock);

		assertTrue(clock.instant().equals(cc.getLast_time()));
	}

	public void testFunDate()
	{
		CommandClock cc = new CommandClock(Clock.systemUTC());
		ZoneId zoneID = ZoneId.systemDefault();

		// The current date and time
		LocalDateTime timePointNow = LocalDateTime.now();

		//set the clock to 13/12-2012
		LocalDateTime timePointNotFun = timePointNow.withDayOfMonth(13).withMonth(12).withYear(2012);
		Clock clockNotFun = Clock.fixed(timePointNotFun.atZone(zoneID).toInstant(), zoneID);

		//set last_time
		cc.setLast_time(clockNotFun);

		//Test
		assertFalse(cc.funDate());

		//set the clock to 12/12-2012
		LocalDateTime timePointFun = timePointNotFun.withDayOfMonth(12);
		Clock clockFun = Clock.fixed(timePointFun.atZone(zoneID).toInstant(), zoneID);

		//set last_time
		cc.setLast_time(clockFun);

		//Test
		assertTrue(cc.funDate());
	}

	public void testFrequency(){ 
		App app = new App(); 
		int num = 3; 
		App.setFrequency(num); 

		assertTrue( num==app.getFrequency() ); 
		assertFalse((num+1)==app.getFrequency()); 
	}
}
