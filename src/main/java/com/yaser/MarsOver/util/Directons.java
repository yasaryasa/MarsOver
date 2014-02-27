package com.yaser.MarsOver.util;

import com.yaser.MarsOver.components.MarsRover;
import com.yaser.MarsOver.components.Rover;

/**
 * 
 * This enumaration represents the direction of {@link Rover} object on {@link MarsRover}
 * 
 * <p>
 * 	Each {@link Directons} enum type consists of x, y movement values and left, right directions.
 * </p>
 * <p>
 * 	<em>For example :</em></br> 
 * 	WEST(-1,0, 'S','N') direction means, when {@link Rover} is moved to west, 
 * 	its <b>x</b> direction becomes closer to zero but <b>y</b> direction never changes. 
 * 	And it has SOUTH on left and NORTH on right.
 * 	</br></br> 
 * 	NORTH(0,1, 'W','E') direction means, when {@link Rover} is moved to north, 
 * 	its <b>x</b> direction doesn't change but <b>y</b> direction increases by one.
 * 	And it has WEST on left and EAST on right.
 * </p>
 * 
 * 
 * @author yasar.yasa
 *
 */
public enum Directons {

	WEST(-1,0, 'S','N'),
	NORTH(0,1, 'W','E'),
	EAST(1,0,'N','S'),
	SOUTH(0,-1, 'E','W');
	
	
	private int x;
	private int y;
	private char left;
	private char rigth;
	
	private Directons(int x, int y, char left, char right) {
		this.x = x;
		this.y = y;
		this.left = left;
		this.rigth = right;
	}

	/**
	 * 
	 * Returns the first letter of the {@link Directons} as wanted in code kata
	 * 
	 * @return
	 * 		First letter of {@link Directons}
	 */
	public char getFirstLetter() {
		return this.toString().charAt(0);
	}
	

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	/**
	 * @return the left
	 */
	public char getLeft() {
		return left;
	}


	/**
	 * @return the rigth
	 */
	public char getRigth() {
		return rigth;
	}
	
}
