package com.yaser.MarsOver.components;

import com.yaser.MarsOver.exceptions.WrongDirection;
import com.yaser.MarsOver.util.Directons;

/**
 * @author yasar.yasa
 *
 */
public class Rover extends Space{

	private Directons direction;

	public Rover(int x, int y, Directons direction) {
		super(x, y);
		this.direction = direction;
	}
	
	
	public Rover(int x, int y, char direction) throws WrongDirection {
		super(x, y);
		defineDirection(direction);
	}

	/**
	 *
	 * Determines the {@link Directons} of the {@link Rover} according to direction character
	 * 
	 * @param direction
	 * @throws WrongDirection
	 */
	private void defineDirection(char direction) throws WrongDirection {
		
		switch (direction) { // Defines the Direction enum type according to given direction character
		case 'E':
			setDirection(Directons.EAST);
			break;
		case 'W':
			setDirection(Directons.WEST);
			break;
		case 'N':
			setDirection(Directons.NORTH);
			break;
		case 'S':
			setDirection(Directons.SOUTH);
			break;

		default:
			throw new WrongDirection("Direction "+direction+" is not recognized...");
		}
	}

	/**
	 * @return the direction
	 */
	public Directons getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Directons direction) {
		this.direction = direction;
	}
	
}
