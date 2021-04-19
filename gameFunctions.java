import java.util.Scanner;
import java.awt.*;  
import javax.swing.*; 
/**
 * This class contains some of the methods necessary for starting and ending the game, a method that allows the user to set their desired difficulty
 *   at the start of the game, and a method to display the games' maps.
 * 
 * @author  Spencer Childers
 * @version  1.0
 * @since  18 April 2021
 */
public class gameFunctions
{
	public String answer; //String that is used to store the responses of the player. Dictates the move of the player.
	Scanner scan = new Scanner(System.in);
	public static boolean normalDifficulty; //boolean value that sets the game to normal mode if true.
	
	
	
	
	/**
	 * Empty constructor for gameFunctions class
	 */
	public gameFunctions()
	{
		
	}
	
	
	
	
	/**
	 * This method is used to ask the player if they would like to start the game. If they say "yes", the program proceeds to start. If "no", the program terminates.
	 */
	public void startGame()
	{
		System.out.println("\nTo perform commands, use the number pad. \nAll available maps are given to the player at the start (only 2).\n ");
		System.out.println("Would you like to play \"The Golden Feather\"?"); 
		System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
			answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				setDifficulty();
				System.out.println("\n\n\n\t====STARTING GAME====\n\n\n");
				try {
					House yaya = House.class.newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
			{
				System.out.println("\n\n\n\t====TERMINATING PROGRAM====");
				//System.exit(0) terminates program if called. In this case, if the player doesn't want to play anymore, program will terminate.
				System.exit(0);
			}
	}
	
	
	
	
	
	/**
	 * This method is used to ask the player if they would like to play the game again. If they say "yes", the program is restarted from the beginning and all entities are reset
	 * 	to their default values. If "no", the program is terminated.
	 */
	public void restartGame()
	{
		System.out.println("\n\nWould you like to try again?"); 
		System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
			answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("\n\n\n\t====RESTARTING GAME====");
				setDifficulty();
				try {
					House yaya = House.class.newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
			{
				System.out.println("\n\n\n\tThank you for playing!");
				//System.exit(0) terminates program if called. In this case, if the player doesn't want to play anymore, program will terminate.
				System.exit(0);
			}
	}
	
	
	
	
	
	/**
	 * This method is used to set the difficulty at the start of the game. If the player chooses "Safety Mode", the player returns to their previous location when killed.
	 * 	If the player chooses "Normal Mode", the player returns to the start of the game upon death.
	 */
	public void setDifficulty()
	{
		System.out.println("\n\nChoose your difficulty."); 
		System.out.println("\n(1) Safety Mode \n\t-Player returns to previous position upon death. \n(2) Normal Mode \n\t-Player is forced to start over upon death.");
			answer = scan.nextLine();
			
		if (answer.equalsIgnoreCase("Safety Mode") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
		{
			System.out.println("\nDifficulty set to Safety Mode.");
			normalDifficulty = false;
			
		}
		else if (answer.equalsIgnoreCase("Normal Mode") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
		{
			System.out.println("\nDifficulty set to Normal.");
			normalDifficulty = true;
		}	
	}
	
	
	
	
	
	/**
	 * This method is used to display the two maps that are used within the game. 
	 */
	public void displayMaps()
	{
		JFrame basement = new JFrame("Basement Map");
		JFrame house = new JFrame("House Map");
		
		ImageIcon houseMap = new ImageIcon (new ImageIcon("Map of House.jpg").getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT));
		ImageIcon basementMap = new ImageIcon (new ImageIcon("Map of Basement.jpg").getImage().getScaledInstance(1100, 660, Image.SCALE_DEFAULT));
		
		JLabel houseLabel , basementLabel;
		
		JPanel subPanel1 = new JPanel();
		subPanel1.setPreferredSize(new Dimension(400,400));
		subPanel1.setBackground(Color.WHITE);
		
		JPanel subPanel2 = new JPanel();
		subPanel2.setPreferredSize(new Dimension(400,400));
		subPanel2.setBackground(Color.WHITE);
		
		houseLabel = new JLabel (null , houseMap , SwingConstants.CENTER);
		basementLabel = new JLabel (null , basementMap , SwingConstants.CENTER);
		
		subPanel1.add(houseLabel);
		subPanel2.add(basementLabel);
		
		house.setSize(1000,700);
		house.setVisible(true);
		house.add(subPanel1);
		basement.setSize (1000,700);
		basement.setVisible(true);
		basement.add(subPanel2);
	}
		
}

