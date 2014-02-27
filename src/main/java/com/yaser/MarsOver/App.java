package com.yaser.MarsOver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yaser.MarsOver.components.MarsRover;
import com.yaser.MarsOver.exceptions.NonRoverException;
import com.yaser.MarsOver.exceptions.SpaceIndexOutOfBounds;
import com.yaser.MarsOver.exceptions.WrongCommand;
import com.yaser.MarsOver.exceptions.WrongDirection;

public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MarsRover m = new MarsRover(5, 5);
		
		try {
			
			m.addRover(1, 3, 'N');
			m.addRover(1, 2, 'E');
			m.sendCommand("MLM");
			m.sendCommand("MLM");
			m.getFinalPositions();
			
		} catch (NonRoverException e) {
			logger.error(e.getMessage());
		} catch (WrongCommand e) {
			logger.error(e.getMessage());
		} catch (WrongDirection e) {
			logger.error(e.getMessage());
		} catch (SpaceIndexOutOfBounds e) {
			logger.error(e.getMessage());
		}
		
	}

}
