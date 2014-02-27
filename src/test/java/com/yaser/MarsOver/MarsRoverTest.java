package com.yaser.MarsOver;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.yaser.MarsOver.components.MarsRover;
import com.yaser.MarsOver.components.Rover;
import com.yaser.MarsOver.exceptions.NonRoverException;
import com.yaser.MarsOver.exceptions.SpaceIndexOutOfBounds;
import com.yaser.MarsOver.exceptions.WrongCommand;
import com.yaser.MarsOver.exceptions.WrongDirection;
import com.yaser.MarsOver.util.Directons;

/**
 * @author yasar.yasa
 *
 */
public class MarsRoverTest {

	
	private static MarsRover marsRover1;
	private static MarsRover marsRover2;
	private static MarsRover marsRover3;
	
	
	/**
	 * 
	 * To test true addrover
	 * 
	 * Adds three {@link Rover} to marsRover1 object with true data, no exception shall be raised
	 * 
	 */
	@Test
	public void testTrueAddRover() {
		
		try {
			marsRover1.addRover(4, 2, 'E');
			marsRover1.addRover(1, 3, 'N');
			marsRover1.addRover(2, 0, 'W');
		} catch (WrongDirection e) {
			fail("Wrong direction. Detail : "+e.getMessage());
		} catch (SpaceIndexOutOfBounds e) {
			fail("Space index out of bounds. Detail : "+e.getMessage());
		}
	}
	
	/**
	 * 
	 * To test {@link WrongDirection}
	 * 
	 * Adds {@link Rover} with false direction command, {@link WrongDirection} exception shall be raised
	 * 
	 */
	@Test
	public void testWrongDirectionAddRover() {
		
		try {
			marsRover2.addRover(1, 3, 'n');
		} catch (WrongDirection e) {
			assertTrue(true);
		} catch (SpaceIndexOutOfBounds e) {
			fail("Space index out of bounds. Detail : "+e.getMessage());
		}
	}
	
	/**
	 * 
	 * To test {@link SpaceIndexOutOfBounds}
	 * 
	 * Adds {@link Rover} with invalid position, {@link SpaceIndexOutOfBounds} exception shall be raised
	 * 
	 */
	@Test
	public void testIndexOutAddRover() {
		
		try {
			marsRover3.addRover(1, -2, 'N');
		} catch (WrongDirection e) {
			fail("Wrong direction. Detail : "+e.getMessage());
		} catch (SpaceIndexOutOfBounds e) {
			assertTrue(true);
		}
	}

	/**
	 * 
	 * Success movement, change direction test
	 * 
	 * Changes the first rover of first mars rover object, it shall be South as it was East before command
	 * 
	 */
	@Test
	public void testChangeDirection() {
		
		try {
			marsRover1.sendCommand("R");
			Rover rover = marsRover1.getRovers().get(0);
			assertEquals(Directons.SOUTH, rover.getDirection());
		} catch (NonRoverException e) {
			fail("There is no rover to move. Detail :"+e.getMessage());
		} catch (WrongCommand e) {
			fail("Wrong command. Detail :"+e.getMessage());
		} catch (SpaceIndexOutOfBounds e) {
			fail("Space index out of bounds. Detail :"+e.getMessage());
		}
		
	}
	
	/**
	 * 
	 * Success movement
	 * 
	 * Second rover of first mars rover object is turned and moved, 
	 * after movement x = 2, y = 5 and direction shall be East
	 * 
	 */
	@Test
	public void testSendCommand() {
		
		try {
			
			marsRover1.sendCommand("MMRM");
			Rover rover = marsRover1.getRovers().get(1);
			assertEquals(2, rover.getX());
			assertEquals(5, rover.getY());
			assertEquals(Directons.EAST, rover.getDirection());
			
		} catch (NonRoverException e) {
			fail("There is no rover to move. Detail :"+e.getMessage());
		} catch (WrongCommand e) {
			fail("Wrong command. Detail :"+e.getMessage());
		} catch (SpaceIndexOutOfBounds e) {
			fail("Space index out of bounds. Detail :"+e.getMessage());
		}
		
	}
	
	/**
	 * 
	 * Fail movement, shall throw {@link WrongCommand} exception
	 * Wrong 'N' command is sent 
	 */
	@Test
	public void testSendCommandFail() {
		
		try {
			marsRover1.sendCommand("NMRM");
		}catch (NonRoverException e) {
			fail("There is no rover to move. Detail :"+e.getMessage());
		} catch (WrongCommand e) {
			assertTrue(true);
		} catch (SpaceIndexOutOfBounds e) {
			fail("Space index out of bounds. Detail :"+e.getMessage());
		}
		
	}
	
	@BeforeClass
	public static void prepareMarsRover() {
		marsRover1 = new MarsRover(5,5);
		marsRover2 = new MarsRover(5,5);
		marsRover3 = new MarsRover(5,5);
	}

}
