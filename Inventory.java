/**
 * This class contains the code required for the player's inventory to store various strings (items) as well as display the inventory to the player when called.
 * This class inherits from the gameFunctions class.
 * 
 * @author Spencer Childers
 * @version 1.0
 * @since 15 April 2021
 */
public class Inventory extends gameFunctions
{
	String [] backpack = new String [10]; //This is the array used to store all of the items that the player finds throughout the game.
	

/* List of all items to be stored in the inventory:
 * 		0 House Blueprint
 * 		1 Crystal Key
 * 		2 Silver Key
 * 		3 Gold Key
 * 		4 Ham Hock
 * 		5 Hexagonal Disk
 * 		6 Stone
 * 		7 Basement Map
 * 		8 Good Boy Toy
 * 		9 Sledgehammer
 */	
	
	
	/**
	 * Empty constructor for Inventory class.
	 */
	public Inventory()
	{
		
	}
	
	
	
	
	/**
	 * This method is used if the player wishes to open up their inventory to see which items they have collected throughout the game.
	 * 	The method uses a for loop to print out the various items in the backpack array.
	 */
	public void openInventory()
	{
		int i;
		
		System.out.println("\nInventory: ");
		for (i=0 ; i<10 ; i++)
		{
			if (backpack[i] == null) 
			{
				
			}
			else
			{
				System.out.println("  * " + backpack[i]);

			}
		}
		System.out.println();
	}
}
