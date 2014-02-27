package com.yaser.MarsOver.components;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yaser.MarsOver.exceptions.NonRoverException;
import com.yaser.MarsOver.exceptions.SpaceIndexOutOfBounds;
import com.yaser.MarsOver.exceptions.WrongCommand;
import com.yaser.MarsOver.exceptions.WrongDirection;
import com.yaser.MarsOver.util.Directons;

/**
 * @author yasar.yasa
 *
 */
public class MarsRover extends Space{

	
	private  Logger logger = LoggerFactory.getLogger(MarsRover.class);
	
	private Rover currentRover;
	private List<Rover> rovers = new ArrayList<Rover>();

	public MarsRover(int x, int y) {
		super(x, y);
	}

	
	/**
	 * 
	 * Adds new {@link Rover} to {@link MarsRover} space with the given x,y coordinates and direction character.
	 * <p>
	 * 	Direction character is converted to {@link Directons} enum type
	 * </p>
	 * <p>
	 * 	Defined directions are : 
	 * 	<ul>
	 * 		<b>
	 * 		<li>"E"</li>
	 * 		<li>"W"</li>
	 * 		<li>"N"</li>
	 * 		<li>"S"</li>
	 * 		</b>
	 * 	</ul> 
	 * 	Other any direction character will cause a {@link WrongDirection} exception
	 * </p>
	 * 
	 * @param x
	 * 			x coordinate of {@link Rover}
	 * @param y
	 * 			y coordinate of {@link Rover}
	 * @param direction
	 * 			First placement direction of {@link Rover} object
	 * @throws WrongDirection
	 * 			If direction is not recognized
	 * @throws SpaceIndexOutOfBounds
	 * 			If given x,y coordinates are over the bounds of {@link MarsRover} object
	 */
	public void addRover(int x, int y, char direction) throws WrongDirection, SpaceIndexOutOfBounds {

		if (x<0 || this.getX()<x || y<0 || this.getY()<y) {
			throw new SpaceIndexOutOfBounds("Space indexes can not be less than rover indexes");
		}
		
		rovers.add(new Rover(x, y, direction));
		logger.info("New Rover has been added to MarsRover!");
	}


	/**
	 * 
	 * Makes movement of current rover according to commands.
	 * 
	 * <p>
	 * 	Movement commands are :
	 * 	<ul>
	 * 		<b>
	 * 		<li>"L"</li>
	 * 		<li>"R"</li>
	 * 		<li>"M"</li>
	 * 	</b>
	 * 	</ul> 
	 * 	Any other command will make the method throw {@link WrongCommand} exception
	 * </p>
	 * 
	 * @param commands
	 * 			String of movement commands
	 * @throws NonRoverException
	 * 			If there is no rover or all rovers made movement,<em> throws {@link NonRoverException}</em>
	 * @throws WrongCommand
	 * 			If there is any character in commands which is not recognized, <em>throws {@link WrongCommand}</em>
	 * @throws SpaceIndexOutOfBounds
	 * 			If movement command makes the rover to go outside of space, <em>throws {@link SpaceIndexOutOfBounds}</em>
	 */
	public void sendCommand(String commands) throws NonRoverException, WrongCommand, SpaceIndexOutOfBounds {
		
		if(hasRover() && hasCurrentRover()){
			
			for (int i = 0; i < commands.length(); i++) {
				char command = commands.charAt(i);
				switch (command) {
				case 'L':
					setRoverDirection(currentRover.getDirection().getLeft()); // change the rover direction to left
					logger.info("Direction of Rover has rotated to left!");
					break;
					
				case 'R':
					setRoverDirection(currentRover.getDirection().getRigth()); // change the rover direction to right
					logger.info("Direction of Rover has rotated to right!");
					break;
					
				case 'M':
					if(checkBorder(currentRover.getX(), this.getX()))
						currentRover.setX(currentRover.getX()+currentRover.getDirection().getX()); // make movement
					else
						throw new SpaceIndexOutOfBounds("Rover can not go any further on X direction");
					if(checkBorder(currentRover.getY(), this.getY()))
						currentRover.setY(currentRover.getY()+currentRover.getDirection().getY());
					else
						throw new SpaceIndexOutOfBounds("Rover can not go any further on Y direction");
					logger.info("Rover has been moved!");
					break;

				default:
					throw new WrongCommand("Command '"+command+"' is not recognized... ");
				}
			}
		}else{
			throw new NonRoverException("You must add rover first");
		}
			
	}
	
	



	/**
	 * 
	 * Used to check borders of {@link MarsRover} space
	 * 
	 * @param bound1
	 * @param bound2
	 * @return
	 */
	private boolean checkBorder(int bound1, int bound2) {
		if(bound1>=0 && bound1<=bound2)
			return true;
		return false;
	}



	/**
	 * 
	 * Displays all rovers position and first character of directions 
	 * 
	 */
	public void getFinalPositions() {
		
		for (Rover r : rovers) {
			System.out.println(r.getX() +" "+ r.getY() +" "+ r.getDirection().getFirstLetter());
		}
		
	}
	
	/**
	 * 
	 * Converts the char and sets the {@link Directons} of the {@link Rover} object
	 * 
	 * 
	 * @param direction
	 * 					First character of {@link Directons}
	 */
	private void setRoverDirection(char direction) {
		switch (direction) {
		case 'E':
			currentRover.setDirection(Directons.EAST);
			break;
		case 'W':
			currentRover.setDirection(Directons.WEST);
			break;
		case 'N':
			currentRover.setDirection(Directons.NORTH);
			break;
		case 'S':
			currentRover.setDirection(Directons.SOUTH);
			break;
		}
	}
	
	
	
	/**
	 * 
	 * To check any rover has left to move
	 * 
	 * @return
	 */
	private boolean hasCurrentRover() {
		
		if(currentRover == null){
			currentRover = rovers.get(0);
			return true;
		}else{
			int indexOf = rovers.indexOf(currentRover);
			if(indexOf+1<=rovers.size()-1){
				currentRover = rovers.get(indexOf+1); // if any rover is left to move, it is assigned as currentRover
				return true;
			}else
				return false;
		}
	}

	/**
	 * 
	 * Checks if there is any rover in {@link MarsRover}
	 * 
	 * @return
	 */
	private boolean hasRover() {
		return (rovers.size()==0) ? false : true;
	}


	/**
	 * @return the rovers
	 */
	public List<Rover> getRovers() {
		return rovers;
	}
	
}
