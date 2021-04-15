/**
 * This class contains the code required for the player's inventory to store various strings (items) as well as display the inventory to the player when called.
 * 
 * @author Spencer Childers
 * @version 1.0
 * @since 4/15/2021
 */
public class Inventory
{
	String [] backpack = new String [10];
	public String answer;
	public int timer;

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
	
	
	public Inventory()
	{
		
	}
	
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
