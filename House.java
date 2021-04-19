/**
 * This class contains all of the code for the various locations found within the game. House also extends the Inventory class (which extends the gameFunctions class) 
 * so that the player may have an inventory that interacts with the game world.
 * 
 * @author Spencer Childers
 * @version 1.0
 * @since 18 April 2021
 */
public class House extends Inventory
{
	private boolean stationary; //boolean value that is inserted into while loops at the different locations in the game. When true, the various while loops break.
	
	//House Modifiers:
	private boolean powerOff; //boolean value for the power supplied to the electrical knob in the front bathroom. If true, the power supplied to the knob is off.
	private boolean dogBite; //boolean value for whether or not the play has been bit by the dog in the backyard. If true, the player has been bit.
	private boolean pictureFrameOff; //boolean value that changes the script of the game. True if the player has discovered the knob leading to the secret basement.
	private boolean approachHouse; //boolean value that changes the script of when the player first approaches the front door.
	private boolean findFuseBox; //boolean value that changes the dialogue after the player first discovers the electrical box on the western side of the house.
	private boolean firstRightSideWindow; //boolean value that changes the dialogue after the player first discovers the window leading to the child's room.
	private boolean firstBedroomEntrance; //boolean value that changes the dialogue after the player first enters the child's bedroom.
	private boolean firstBedroomBottomRight;  //boolean value that changes the dialogue after the player first discovers the smelly bedroom on the bottom right of the house.
	private boolean firstFrontBathroom;  //boolean value that changes the dialogue after the player first discovers the bathroom at the front of the house.
	private boolean firstKitchen;  //boolean value that changes the dialogue after the player first discovers the kitchen.
	private boolean firstLivingRoom;  //boolean value that changes the dialogue after the player first discovers the living room.
	private boolean firstMasterBedroom;  //boolean value that changes the dialogue after the player first discovers the master bedroom.
	private boolean firstMasterBathroom;  //boolean value that changes the dialogue after the player first discovers the master bathroom.
	private boolean firstGarage;  //boolean value that changes the dialogue after the player first discovers the garage.
	private boolean firstBackyard;  //boolean value that changes the dialogue after the player first discovers the backyard.
	private boolean firstDogHouse;  //boolean value that changes the dialogue after the player first encounters the dog house.
	private boolean secretPassageFound;  //boolean value that changes the dialogue after the player first opens the door to the secret passage.
	private boolean seenWalnutChest;  //boolean value that changes the dialogue after the player first tries to inspect the walnut chest in the master bedroom.
	private boolean safeOpen;  //boolean value that changes the dialogue of entering the garage after the safe has been opened.
		
	//Basement modifiers:
	private int x,y;  //integer values for the various positions of the basement. 
	private boolean spikeTrapOff;  //boolean value that changes the dialogue after the player has turned off the spike trap. This is used once the player returns to the trap.
	private boolean wallEastBroken;  //boolean value that is true if the eastern wall by the stairs in the basement is broken.
	private boolean wallSouthBroken;  //boolean value that is true if the southern wall by the stairs in the basement is broken.
	private boolean startOfSearch;  //boolean value that changes the dialogue after the player first leaves the stairwell in the basement.
	private boolean justMovingIn;  //boolean value that changes the dialogue after the player first arrives at one of the two possible movable locations from the basement stairwell.
	private boolean justReachBasement;  //boolean value that changes the dialogue after the player first enters the basement.
	private boolean feelingLost;  //boolean value that changes the dialogue after the player first reaches position (1,1) in the basement.
	private boolean enterBrokenWall;  //boolean value that changes the dialogue after the player first enters one of the passages hidden behind the broken walls by the stairs in the basement.
	private boolean Neg1Neg2Disc;  //boolean value that changes the dialogue after the player enters position (-1,-2) in the basement.
	private boolean Neg1Neg3Disc;  //boolean value that changes the dialogue after the player enters position (-1,-3) in the basement.
	private boolean justSeeingMap; //boolean value that changes the dialogue after the player first discovers the map in the basement indicating there are hidden passages.
	private boolean spikeTrapFirstTime; //boolean value that turns true once the player hears the sound of the spike trap activating.
	private boolean crossingSpikes; //boolean value that gives different dialogue options for if the player has seen that the lever has closed the spike trap.
	private boolean crossedTrapBefore; //boolean value that gives different dialogue options for if the player has crossed the spike trap before.
	private boolean firstSpikeTrap; //boolean value that is false if the player hasn't seen the spike trap before. Turns true after seeing trap.
	private boolean visitLever; //boolean value for having visited the lever in the basement before.
	private boolean finalWallBroken; //boolean value that changes the dialogue after the player first breaks the wall concealing the golden feather.
	
	
	
	/**
	 * Constructor that is used to initialize all of the boolean values to their desired values. Also starts the game by calling the backstory method.
	 */
	public House() 
	{
		//Method to start game.
		backstory();
		
		//House Mods
		powerOff = false;
		dogBite = false;
		pictureFrameOff = false;
		approachHouse = false;
		findFuseBox = false;
		firstRightSideWindow = false;
		firstBedroomEntrance = false;
		firstBedroomBottomRight = false;
		firstFrontBathroom = false;
		firstKitchen = false;
		firstLivingRoom = false;
		firstMasterBedroom = false;
		firstMasterBathroom = false;
		firstGarage = false;
		firstBackyard = false;
		firstDogHouse = false;
		secretPassageFound = false;
		seenWalnutChest = false;
		safeOpen = false;
		
		
		//Basement Mods
		spikeTrapOff = false;
		wallEastBroken = false;
		wallSouthBroken = false;
		startOfSearch = false;
		justReachBasement = false;
		justMovingIn = false;
		feelingLost = false;
		enterBrokenWall = false;
		Neg1Neg2Disc = false;
		Neg1Neg3Disc = false;
		justSeeingMap = false;
		spikeTrapFirstTime = false;
		crossingSpikes = false;
		finalWallBroken = false;
		firstSpikeTrap = false;
		visitLever = false; 
		crossedTrapBefore = false;
		
	}
	
	
	
	
	
	/**
	 * This method is used to display the information regarding the player's mission.
	 */
	public void backstory() {
		System.out.println("============================================================ \n\nMission: The Golden Feather \nObjective: To acquire the multimillion-dollar golden feather \nName: John Natasha \nTime of Day: 11:37 PM \nDate: August 18, 2009 \nChances of Success: Slim\n\n============================================================\n\n\n\n");
		frontHouse();
	}
	
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				Start of methods for House portion of game.
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/	
	
	
	/**
	 * This is the first position used in the game - the front door to the house. This method/position, along with the majority of the other methods, determines dialogue 
	 *  options and and movement locations by a variety of if statements and player inputs. 
	 *  Also, depending on the current value of boolean variables and the Strings stored in the backpack array, different statements/movement options will be available
	 *  throughout the game.
	 *  The player can move to the electrical panel or to the window to the right of the door from this position. A stone can be found here if the player searches their 
	 *  surroundings. The player can also choose to back away from the house, ending the game. Also, the player can choose to lockpick the door and end the game this way
	 *  too.
	 *  The boolean variable approachHouse affects dialogue here.
	 */
	public void frontHouse()
	{
		stationary = true;		
		
		if (approachHouse == false)
		{
			System.out.println("As I approach the house, I begin to have reservations about this job. \nI know I made sure to scan the house from the street to ensure that I'd be alone, but something doesn't sit right with me about this place. \nI soon dismiss any doubts and make my way to the door. \nHow could something of such value be contained in such a simple home?");
			approachHouse = true;
		}
		else
		{
			System.out.println("I return to the front door.");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Open door. \n(2) Leave house. \n(3) Search western side of the house. \n(4) Move east. \n(5) Search surroundings for anything useful.  \n(6) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Open door") || answer.equalsIgnoreCase("(1)") || answer.equalsIgnoreCase("1"))
			{
				System.out.println("I try to twist the knob, but have no luck with opening the door. \nShould I try picking the lock?");
				System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
					answer = scan.nextLine();
				
				if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("After only seconds, I am able to unlock the front door. \nImmediately, an alarm system is set off. \nWithin minutes, the police arrive and escort me away.");
					
					if (normalDifficulty == false)
					{
						System.out.println("\n\n\n\t====RESTARTING CHECKPOINT====\n\n\n");
						frontHouse();
					}
					else if (normalDifficulty == true)
					{
						System.out.println("\n\n\n\t====GAME OVER====");
						restartGame();
					}
				}
				else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
				{
					System.out.println("I back away from the door and decide my next move.");
				}				
			}
			
			else if (answer.equalsIgnoreCase("Leave house") || answer.equalsIgnoreCase("Leave") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("Maybe I should go with my gut. \nShould I leave?");
				System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
					answer = scan.nextLine();
			
				if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("I turn around and leave the scene, knowing that I made the right choice.");
					System.out.println("\n\n\n\t====GAME OVER====");
					
					restartGame();
				}
				else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
				{
					System.out.println("I better keep with the plan. \nI'd be a fool to pass up an opportunity like this.");
				}	
			}
			
			else if (answer.equalsIgnoreCase("Search western side of the house") || answer.equalsIgnoreCase("West") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				System.out.println("I begin to creep around the left side of the house, passing the garage along the way.");
				stationary = false;
				electricalBox();
			}
			
			else if (answer.equalsIgnoreCase("Move east") || answer.equalsIgnoreCase("east") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				System.out.println("I hurry east, trampling the house's flowerbeds in the process.");
				stationary = false;
				frontLeftWindow();
			}
			
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(5)") || answer.equalsIgnoreCase("5")) 
			{
				if (backpack [6] == "stone")
				{
					System.out.println("I don't see anything else worth noting here.");
				}
				else if (backpack [6] != "stone")
				{
					System.out.println("I search around the flowerbeds. \nMaybe I could find a use for one of these small stones. \nShould I snag one?");
					System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
						answer = scan.nextLine();
						
					if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
					{
						System.out.println("I add the stone to my backpack.");
						backpack[6] = "stone";
						frontHouse();
					}
					else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
					{
						System.out.println("Honestly, what good would a stone offer me anyway.");
						frontHouse();
					}	
				}
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(6)") || answer.equalsIgnoreCase("6"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method moves the player to the window that is to the right of the front door. There is nothing at this position, but the player can lose the game by busting through
	 *   the window if they have the stone. The player can move to the front door or to the other window on the front of the house.
	 */
	public void frontLeftWindow()
	{
		stationary = true;
		
		
		System.out.println("I arrive at the window closest to the front door. \nI attempt to open the window but it is locked. \nWhat will I do?");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Return to the front door. \n(2) Move east. \n(3) Attempt breaking the window. \n(4) Search surroundings for anything useful.  \n(5) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Return to the front door") || answer.equalsIgnoreCase("Return") || answer.equalsIgnoreCase("R") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I make my way back to the front door, making sure to stay in the shadows.");
				stationary = false;
				frontHouse();
			}
			
			else if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I swifly skulk my way over to the next window.");
				stationary = false;
				frontRightWindow();
			}
				
			else if (answer.equalsIgnoreCase("Attempt breaking the window") || answer.equalsIgnoreCase("attempt") || answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				System.out.println("Surely if I am successful in shattering this window, someone will hear me doing so. \nIs it worth the risk?");
				System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
					answer = scan.nextLine();
			
				if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					if (backpack [6] == "stone")
					{
						System.out.println("I remove the stone from my backpack and easily shatter the window. \nUnfortunately, I can guarantee the sound was heard by someone. \nI hurry inside.");
						System.out.println("...\n...\n...\nShortly after entering, the police arrive and I am escorted away in cuffs.");
						
						if (normalDifficulty == false)
						{
							System.out.println("\n\n\n\t====RESTARTING CHECKPOINT====\n\n\n");
							frontLeftWindow();
						}
						else if (normalDifficulty == true)
						{
							System.out.println("\n\n\n\t====GAME OVER====");
							restartGame();
						}
						
					}
					else if (backpack [6] != "stone")
					{
						System.out.println("I try to bash through the window with my fist, but ultimately fail at doing so. \nMaybe I can find an item to help.");
					}
				}
				else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
				{
					System.out.println("I really should avoid making any noise. \nBreaking a window would be foolish.");
				}	
			}
			
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				System.out.println("Around me I see nothing but flowers and fresh manure. \nI should hurry along.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(5)") || answer.equalsIgnoreCase("5"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method moves the player to the right window on the front of the house. There is nothing here for the player. From here, the player can move to the window on the 
	 *   eastern side of the house or to the window to the right of the front door.
	 */
	public void frontRightWindow()
	{
		stationary = true;
		
		
		System.out.println("Unlike before, this window is far too high to easily reach. \nI really should venture forward.");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move to the window by the front door. \n(2) Head around to the eastern side of the house. \n(3) Search surroundings for anything useful.  \n(4) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move to the window by the front door") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I silently tread back to the other window.");
				stationary = false;
				frontLeftWindow();
			}
			
			else if (answer.equalsIgnoreCase("Head around to the eastern side of the house") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I turn the corner of the house and proceed along its side.");
				stationary = false;
				rightSideWindow();
			}
		
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				System.out.println("Ouch! A thorn bush rubs up against my shirt. \nI need to get out of here.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method moves the player to the electrical panel. This panel is used to power off the electricity that is running to the door knob covering the secret staircase to the
	 *   basement. The player can move to the western window or to the front door from this position.
	 *   The boolean variables findFuseBox and powerOff affect the dialogue here.
	 */
	public void electricalBox()
	{
		stationary = true;
		if (findFuseBox == false)
		{
			System.out.println("While searching around the western side of the house, I come across an electrical panel. \nLet me see what I can do.");
			findFuseBox = true;
		}
		else if (findFuseBox == true)
		{
			System.out.println("I arrive back at the electrical panel. \nWhat to do now?");
		}
			
			
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move north. \n(2) Return to the front door. \n(3) Inspect electrical panel. \n(4) Open Inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I continue making my way up along the side of the house.");
				stationary = false;
				leftSideWindow();
			}
			
			else if (answer.equalsIgnoreCase("Return to the front door") || answer.equalsIgnoreCase("Return to the front door") || answer.equalsIgnoreCase("r") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
			{
				System.out.println("I sneak back to the front of the house.");
				stationary = false;
				frontHouse();
			}
			
			else if (answer.equalsIgnoreCase("Inspect electrical panel") || answer.equalsIgnoreCase("Inspect") || answer.equalsIgnoreCase("i") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
			{
				if (powerOff == true)
				{
					System.out.println("Should I power the switch once again?");
					System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
						answer = scan.nextLine();
					
					if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
					{
						System.out.println("I flip on the switch and I begin to hear the low hum of electricity.");
						powerOff = false;
					}
					else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
					{
						System.out.println("Maybe its best to keep this fuse powered off.");
					}	
				}
				
				else if (powerOff == false)
				{
					System.out.println("Strange. There only appears to be a single switch within the box. \nIs it worth the risk to turn it off?");
					System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
						answer = scan.nextLine();
					
					if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
					{
						System.out.println("I flip off the switch and am relieved to have not been electrocuted.");
						powerOff = true;
						
					}
					else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
					{
						System.out.println("I probably shouldn't mess with these electrical components. Let me back up.");
					}	
				}
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method moves the player to the window on the far left side of the house. There is nothing at this position, but the player can lose the game by busting through
	 *   the window if they have the stone. The player can move to the electrical panel from here.
	 */
	public void leftSideWindow()
	{
		stationary = true;
		
		System.out.println("I reach the window on the western edge of the house. \nI attempt to open the window but it is locked. \nWhat will I do?");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Return to the fuse box. \n(2) Attempt breaking the window. \n(3) Search surroundings for anything useful.  \n(4) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Return to the fuse box") || answer.equalsIgnoreCase("Return") || answer.equalsIgnoreCase("R") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("Crouching, I wander back to the electrical box.");
				stationary = false;
				electricalBox();
			}
			
			else if (answer.equalsIgnoreCase("Attempt breaking the window") || answer.equalsIgnoreCase("attempt") || answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("Surely if I am successful in shattering this window, someone will hear me doing so. \nIs it worth the risk?");
				System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
					answer = scan.nextLine();
			
				if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					if (backpack [6] == "stone")
					{
						System.out.println("I remove the stone from my backpack and easily shatter the window. \nUnfortunately, I can guarantee the sound was heard by someone. \nI hurry inside.");
						System.out.println("...\n...\n...\nShortly after entering, the police arrive and I am escorted away in cuffs.");
						
						if (normalDifficulty == false)
						{
							System.out.println("\n\n\n\t====RESTARTING CHECKPOINT====\n\n\n");
							leftSideWindow();
						}
						else if (normalDifficulty == true)
						{
							System.out.println("\n\n\n\t====GAME OVER====");
							restartGame();
						}
						
					}
					else if (backpack [6] != "stone")
					{
						System.out.println("I try to bash through the window with my fist, but ultimately fail at doing so. \nMaybe I can find an item to help.");
					}
				}
				else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
				{
					System.out.println("I really should avoid making any noise. \nBreaking a window would be foolish.");
				}	
			}
			
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				System.out.println("I don't believe there is anything important here.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method moves the player to the outside of the window on the eastern side of the house. From this position, the player can move into the child's bedroom.
	 *   There is nothing important in this location. 
	 *   The boolean variable firstRightSideWindow affects dialogue here.
	 */
	public void rightSideWindow()
	{
		stationary = true;
		
		if (firstRightSideWindow == false)
		{
			System.out.println("I reach the eastern window. \nI lift it up and it immediately gives! \nHow should I proceed?");
			firstRightSideWindow = true;
		}
		else if (firstRightSideWindow == true)
		{
			System.out.println("I stand just outside of the unlocked window, waiting to make my next move.");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move to the front of the house. \n(2) Enter inside. \n(3) Search surroundings for anything useful.  \n(4) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move to the front of the house") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I move back to the front of the house.");
				stationary = false;
				frontRightWindow();
			}
			
			else if (answer.equalsIgnoreCase("Enter Inside") || answer.equalsIgnoreCase("Enter") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I carefully hoist myself over the window frame and into the house.");
				stationary = false;
				bedroomEntrance();
			}
			
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				System.out.println("I can't find anything around me. \nI should move inside.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method moves the player to the children's room. This is the first method used to move the player in to the house. From this position, the player can move back outside
	 *   or to the eastern hallway. There is nothing of value here.
	 *   The boolean variable firstBedroomEntrance affects dialogue.
	 */
	public void bedroomEntrance()
	{
		stationary = true;
		if (firstBedroomEntrance == false)
		{
			System.out.println("Sweet! I am finally inside. \nI have just entered into what appears to be a child's bedroom. \nOther than the massive amount of toys scattered across the floor, there doesn't appear to be anything too valuable in here. \nIt's time to start searching.");
			firstBedroomEntrance = true;
		}
		
		else if (firstBedroomEntrance == true)
		{
			System.out.println("I stand in the middle of the children's room, making sure to avoid rolling my ankles on these toys. \nWhere should I go?");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move to the hallway. \n(2) Go back outside. \n(3) Search surroundings for anything useful.  \n(4) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move to the hallway") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I quietly make my way out of the room and into the hall.");
				stationary = false;
				rightHallway();
			}
			
			else if (answer.equalsIgnoreCase("Go back outside") || answer.equalsIgnoreCase("outside") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I carefully hoist myself over the window frame and out of the house");
				stationary = false;
				rightSideWindow();
			}
			
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				System.out.println("I rummage through the piles of toys. \nI can't imagine anyone hiding valuables amongst these plastic novelties. \nI soon after give up and return to the center of the room.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the foul-smelling bedroom at the front right of the house. The player can move to the eastern hallway from this position.
	 *   There is nothing of value in this room.
	 *   The boolean variable firstBedroomBottomRight affects dialogue in this area.
	 */
	public void bedroomBottomRight()
	{
		stationary = true;
		
		if (firstBedroomBottomRight == false)
		{
			System.out.println("I enter into the bedroom. \nA wall of B.O. nearly knocks me off my feet. \nAfter getting my bearings, I survey the room from its center. \nWhat should I do?");
			firstBedroomBottomRight = true;
		}
		
		else if (firstBedroomBottomRight == true)
		{
			System.out.println("I am reminded of the deadly stench this room has to offer as I return to it. \nMaybe I will find something here.");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move to the hallway. \n(2) Search surroundings for anything useful.  \n(3) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move to the hallway") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I happily exit the room.");
				stationary = false;
				rightHallway();
			}
			
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("Holding my breath, I quickly survey the room. \nI find nothing.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is used to move the player to the eastern hallway. From the hallway, the player can move to the kitchen, the front bathroom, the children's bedroom,
	 *   and the foul smelling bedroom. There is not anything of value found at this position.
	 */
	public void rightHallway()
	{
		stationary = true;
		
		System.out.println("Now in the eastern hallway, I have easy access to the two bedrooms, the bathroom, and the kitchen. \nWhere should I head to first?");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move to the kitchen. \n(2) Go to the children's room. \n(3) Search the foul-smelling bedroom. \n(4) Visit the bathroom. \n(5) Search surroundings for anything useful.  \n(6) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move to the kitchen") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I make my way towards the kitchen.");
				stationary = false;
				kitchen();
			}
			
			else if (answer.equalsIgnoreCase("Go to the children's room") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				stationary = false;
				bedroomEntrance();
			}
			
			else if (answer.equalsIgnoreCase("Search the foul-smelling bedroom") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				stationary = false;
				bedroomBottomRight();
			}
			
			else if (answer.equalsIgnoreCase("Visit the bathroom") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				stationary = false;
				frontBathroom();
			}
			
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(5)") || answer.equalsIgnoreCase("5"))
			{
				System.out.println("Other than the occasional family photo, there really isn't anything of importance in this hallway.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(6)") || answer.equalsIgnoreCase("6"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is used to move the player to the bathroom at the front of the house. From the bathroom, the player can find the secret passage leading to the basement.
	 *   This passage is blocked by an electrical door knob that must be powered off at the electrical panel outside of the house on its western side. From the bathroom,
	 *   the player can move downstairs and to the eastern hallway.
	 *   The boolean variables secretPassageFound, pictureFrameOff, firstFrontBathroom, and powerOff affect dialogue.
	 */
	public void frontBathroom()
	{
		stationary = true;
		
		if (secretPassageFound == false)
		{
			if (pictureFrameOff == false)
			{
				if (powerOff == false)
				{
					if (firstFrontBathroom == false)
					{
						//Dialogue option if portrait is still up, power is on, and it's the first time entering bathroom.
						System.out.println("I enter the small restroom. \nImmediately, I hear a subtle electrical humming resonating from the northern wall. \nPerhaps there is something behind here.");
						firstFrontBathroom = true;
					}
					
					else if (firstFrontBathroom == true)
					{
						//Dialogue option if portrait is up, power is on, and player is returning to bathroom.
						System.out.println("I return to the bathroom, and I can still make out the low electrical frequency. \nWhat will I do?");
					}	
				}
				
				else if (powerOff == true)
				{
					if (firstFrontBathroom == false)
					{
						//Dialogue option if portrait is up, power is off, and its the first time in the bathroom.
						System.out.println("I enter the small restroom. \nThe scent of sweet-smelling toiletries is a nice contrast to the room opposite here. \nWhat should I do first?");
						firstFrontBathroom = true;
					}
					
					else if (firstFrontBathroom == true)
					{
						//Dialogue option if portriat is up, power is off, and player is returning to bathroom.
						System.out.println("I return to the pleasant-smelling bathroom. \nWhere to next?");
					}
				}
				//While options for if picture frame hasnt been removed yet
				while (stationary == true)
				{
					System.out.println("\nPossible Moves:\n(1) Move to the hallway. \n(2) Search surroundings for anything useful.  \n(3) Open inventory.");
						answer = scan.nextLine();
					
					if (answer.equalsIgnoreCase("Move to the hallway") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
					{
						System.out.println("I return to the eastern hallway.");
						stationary = false;
						rightHallway();
					}
					
					else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
					{
						if (powerOff == false)
						{
							System.out.println("I rummage through the various drawers beneath the sink finding nothing. \nNext, I begin searching for the sound of the humming. \nI remove a large painting from the northern wall where I find the source of the sound, a small knob. \nI am not sure if its worth opening this passage yet. \nShould I try anyway?");
							System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
								answer = scan.nextLine();
							
							if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
							{
								System.out.println("I move my hand towards the handle, but I am immediately thrown against the sink by a massive electrical shock. \nI sit uncomfortably beneath the sink as I feel my heartbeat come to a stop. \nI close my eyes and take my final breath.");
								
								if (normalDifficulty == false)
								{
									System.out.println("\n\n\n\t====RESTARTING CHECKPOINT====\n\n\n");
									frontBathroom();
								}
								else if (normalDifficulty == true)
								{
									System.out.println("\n\n\n\t====GAME OVER====");
									restartGame();
								}
							}
							else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
							{
								System.out.println("Maybe I can turn this electricity off somewhere.");
							}
						}
						else if (powerOff == true)
						{
							System.out.println("I rummage through the various drawers beneath the sink finding nothing. \nI turn around and begin speculating that the large painting on the wall may be concealing something. \nI remove the portrait and discover a small knob to be hidden behind. \nShould I turn it?");
							System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
								answer = scan.nextLine();
							
							if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
							{
								System.out.println("I open the secret passage. \nExcitement fills my body as I discover a spiral staircase behind the faux wall. \nI bet my golden feather is somewhere down there.");
								pictureFrameOff = true;
								secretPassageFound = true;
								System.out.println("Should I go downstairs?");
								System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
									answer = scan.nextLine();
								if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
								{
									System.out.println("I begin making my way down the stairs.");
									stationary = false;
									baseOrigin();
								}
								else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
								{
									System.out.println("I should look around the house a bit more.");
								}
							}
							else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
							{
								System.out.println("I return the painting to its original position and resume my search of the bathroom. \nI should continue looking through the house first.");
								pictureFrameOff = true;
							}
						}
					}
					
					else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
					{
						openInventory();
					}
				}
			}
			
			else if (pictureFrameOff == true)
			{
				if (powerOff == false)
				{
					//Dialogue option if player is returning to bathroom, the portrait has been removed before, and the power is on.
					System.out.println("I return to the bathroom where the secret door is, but I still hear the electricity running through the handle. \nI should continue searching elsewhere.");
					
				}
				else if (powerOff == true)
				{
					//Dialogue option if player is returning to bathroom, the portrait has been removed before and the power is off.
					System.out.println("I return to the bathroom with the secret door. \nWhere to?");
				}
			
				while (stationary == true)
				{
					System.out.println("\nPossible Moves:\n(1) Move to the hallway. \n(2) Search the bathroom.  \n(3) Open inventory.");
						answer = scan.nextLine();
					
					if (answer.equalsIgnoreCase("Move to the hallway") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
					{
						System.out.println("I return to the eastern hallway.");
						stationary = false;
						rightHallway();
					}
					
					else if (answer.equalsIgnoreCase("Search the bathroom.") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
					{
						if (powerOff == false)
						{
							System.out.println("I filter through the bathroom's belongings once more and then return to the secret door. \nI am not sure if its worth opening this passage yet. \nShould I try anyway?");
							System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
								answer = scan.nextLine();
							
							if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
							{
								System.out.println("I move my hand towards the handle, but I am immediately thrown against the sink by a massive electrical shock. \nI sit uncomfortably beneath the sink as I feel my heartbeat come to a stop. \nI close my eyes and take my final breath.");
								
								if (normalDifficulty == false)
								{
									System.out.println("\n\n\n\t====RESTARTING CHECKPOINT====\n\n\n");
									frontBathroom();
								}
								else if (normalDifficulty == true)
								{
									System.out.println("\n\n\n\t====GAME OVER====");
									restartGame();
								}
							}
							else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
							{
								System.out.println("Maybe I can turn this electricity off somewhere.");
							}
						}
						else if (powerOff == true)
						{
							System.out.println("I filter through the bathroom's belongings once more and then return to the secret door. \nI am not sure if its worth opening this passage yet. \nShould I try anyway?");
							System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
								answer = scan.nextLine();
							
							if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
							{
								System.out.println("I open the secret passage. \nExcitement fills my body as I discover a spiral staircase behind the faux wall. \nI bet my golden feather is somewhere down there.");
								pictureFrameOff = true;
								secretPassageFound = true;
								System.out.println("Should I go downstairs?");
								System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
									answer = scan.nextLine();
								if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
								{
									System.out.println("I begin making my way down the stairs.");
									stationary = false;
									baseOrigin();
								}
								else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
								{
									System.out.println("I should look around the house a bit more.");
								}
							}
							else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
							{
								System.out.println("I return the painting to its original position and resume my search of the bathroom. \nI should continue looking through the house first.");
							}
						}
					}
					
					else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
					{
						openInventory();
					}
				}
				
			}
		}
		
		else if (secretPassageFound == true)
		{
			System.out.println("I now stand in the middle of the bathroom where the secret passage was found. \nWhere should I go?");
			
			while (stationary == true)
			{
				System.out.println("\nPossible Moves:\n(1) Return to the hallway. \n(2) Go downstairs. \n(3) Open inventory.");
					answer = scan.nextLine();
				
				if (answer.equalsIgnoreCase("Return to the hallway") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("I walk back out into the hall.");
					stationary = false;
					rightHallway();
				}
				
				else if (answer.equalsIgnoreCase("Go downstairs") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
				{
					stationary = false;
					System.out.println("I begin making my way back downstairs.");
					baseOrigin();
				}
				
				else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
				{
					openInventory();
				}
			}
		}
	}
	
	
	
	
	/**
	 * This method moves the player to the kitchen. In the kitchen, the player can find the pork knuckle that is used to get the hexagonal disk without getting bit by the dog.
	 *   From this position, the player can move to the western and eastern hallways, the living room, the master bedroom, the backyard, and the master bathroom.
	 *   The boolean variable firstKitchen and the array element "pork knuckle" affect the dialogue options.
	 */
	public void kitchen()
	{
		stationary = true;
		
		if (firstKitchen == false)
		{
			System.out.println("Before entering the kitchen, I scan the room to ensure there aren't any surveillance systems. \nI dismiss the likelyhood of any devices being present and resume my search for the feather. \nI now stand in front of the dining room table. \nWhere could that feather be?");
			firstKitchen = true;
		}
		
		else if (firstKitchen == true)
		{
			System.out.println("I stand in the middle of the kitchen. \nMy stomach growls as I fantasize about all the fine dining I will be doing after I retrieve this feather. \nWhere should I go next?");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Look in the living room. \n(2) Go to the backyard. \n(3) Enter the master bedroom. \n(4) Look in the master bathroom. \n(5) Go to eastern hallway. \n(6) Go to western hallway. \n(7) Search surroundings for anything useful.  \n(8) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Look in the living room") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I head east into the quaint living room.");
				stationary = false;
				livingRoom();
			}
			
			else if (answer.equalsIgnoreCase("Go to the backyard") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I head out the back doors.");
				stationary = false;
				backyard();
			}
			
			else if (answer.equalsIgnoreCase("Enter the master bedroom") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				stationary = false;
				masterBedroom();
			}
			
			else if (answer.equalsIgnoreCase("look in the master bathroom") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				stationary = false;
				masterBathroom();
			}
			
			else if (answer.equalsIgnoreCase("go to eastern hallway") || answer.equalsIgnoreCase("(5)") || answer.equalsIgnoreCase("5"))
			{
				stationary = false;
				rightHallway();
			}
			
			else if (answer.equalsIgnoreCase("go to western hallway") || answer.equalsIgnoreCase("(6)") || answer.equalsIgnoreCase("6"))
			{
				stationary = false;
				leftHallway();
			}
			
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(7)") || answer.equalsIgnoreCase("7"))
			{
				System.out.println("I start by checking the cabinets below the sink and stove. \nUltimately, I discover nothing within these compartments. \nHowever, on the counter near the fridge I inspect a behemoth butcher knife that's been heavily dulled from overuse. \nThis blade would have severe trouble with cleaving anything tougher than chicken bones. \nI return the blade and begin searching the fridge.");
				
				if (backpack [4] == "pork knuckle")
				{
					System.out.println("The heavily blood-stained fridge is completely barren. \nI should get moving.");
				}
				else if (backpack [4] != "pork knuckle")
				{
					System.out.println("Within the bloodied fridge lay a single piece of fleshy knuckle in a shallow pool of fluid. \nIt smells heavily rotted, but perhaps it will serve some function later on. \nShould I take the knuckle?");
					System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
					answer = scan.nextLine();
					
					if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
					{
						System.out.println("I wrap the knuckle in paper towels and add it to my backpack.");
						backpack[4] = "pork knuckle";
						kitchen();
					}
					else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
					{
						System.out.println("I stray away from the repulsive item.");
						kitchen();
					}	
				}
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(8)") || answer.equalsIgnoreCase("8"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is used to move the player to the living room. There is nothing important here in this area. 
	 * From this position, the player can move to the kitchen.
	 * The boolean variable firstLivingRoom affects dialogue.
	 */
	public void livingRoom()
	{
		stationary = true;
		
		if (firstLivingRoom == false)
		{
			System.out.println("Standing in the middle of this old fashioned living room, I begin to ponder the daily lives of those living here. \nEverything in this room looks like it hasn't been touched since the '70s. \nEven the television has a thick layer of dust accumulating on its surface. \nShould I continue searching in here?");
			firstLivingRoom = true;
		}
		
		else if (firstLivingRoom == true)
		{
			System.out.println("I hold back a sneeze as I enter the dusty living room. \nWhere should I go?");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Head back to the kitchen. \n(2) Search surroundings for anything useful.  \n(3) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Head back to the kitchen") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				stationary = false;
				kitchen();
			}
			
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I take a quick circle around the room, but find nothing in the end.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is used to move the player to the master bedroom. In this room, the player can find the chest containing the crystal key. To get the key, the player must
	 *   have the hexagonal disk found in the backyard. From the bedroom, the player can move to the master bathroom or the kitchen.
	 *   The boolean variables seenWalnutChest and firstMasterBedroom affect the dialogue here. Dialogue is also altered if the player has the hexagonal disk and/or the 
	 *   crystal key.
	 */
	public void masterBedroom()
	{
	stationary = true;
		
		if (firstMasterBedroom == false)
		{
			System.out.println("I enter into the master bedroom. \nThe room has been very well kept. \nA single lamp in the corner of the room is the only source of light. \nMuch like the rest of the house, there is very little furniture here, but I should still search around.");
			firstMasterBedroom = true;
		}
		
		else if (firstMasterBedroom == true)
		{
			System.out.println("I position myself in front of the luxurious bed within the master bedroom. \nWhere should I look next?");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Go to the kitchen. \n(2) Go to the master bathroom. \n(3) Search surroundings for anything useful.  \n(4) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Go to the kitchen") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I leave the bedroom");
				stationary = false;
				kitchen();
			}
			
			else if (answer.equalsIgnoreCase("Go to the master bathroom") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I shuffle over to the bathroom.");
				stationary = false;
				masterBathroom();
			}
			
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				if (backpack [1] != "crystal key")
				{
					if (backpack [5] != "hexagonal disk")
					{
						System.out.println("Immediately, a petite wooden chest to the side of the bed catches my eye. \nI approach the box and try opening it. \nI have no success, but I notice a large hexagonal hole in the center of its cover. \nI should search around some more.");
						seenWalnutChest = true;
					}
					
					else if (backpack [5] == "hexagonal disk")
					{
						if (seenWalnutChest == false)
						{
							System.out.println("Immediately, a petite walnut chest to the side of the bed catches my eye. \nI approach the box and try opening it. \nI have no success, but notice a large hexagonal hole in the center of its cover. \nMaybe that disk I found earlier will open the box? \nShould I give it a try?");
							seenWalnutChest = true;
							System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
							answer = scan.nextLine();
							
							if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
							{
								System.out.println("I pull the disk out of my bag and insert it into the top of the chest. \nIt's a perfect fit. \nI hear an internal mechanism click, popping the chest open. \nInside I find a crystal clear key. \nI will definitely bring this with me.");
								System.out.println("The crystal key is added to my backpack.");
								backpack[1] = "crystal key";
								masterBedroom();
							}
							else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
							{
								System.out.println("I decide to hold off on opening the box. \nWho knows, there may have been a trap within it.");
								masterBedroom();
							}	
						}
						else if (seenWalnutChest == true)
						{
							System.out.println("I approach the box and with the hexagonal hole. \nI bet that disk I found will open this chest. \nShould I give it a try?");
							System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
							answer = scan.nextLine();
							
							if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
							{
								System.out.println("I pull the disk out of my bag and insert it into the top of the chest. \nIt's a perfect fit. \nI hear an internal mechanism click, popping the chest open. \nInside I find a crystal clear key. \nI will definitely bring this with me.");
								System.out.println("The crystal key is added to my backpack.");
								backpack[1] = "crystal key";
								masterBedroom();
							}
							else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
							{
								System.out.println("I decide to hold off on opening the box. \nWho knows, there may have been a trap within it.");
								masterBedroom();
							}	
						}
					}
				}
				
				else if (backpack [1] == "crystal key")
				{
					System.out.println("There doesn't appear to be anything else here.");
				}
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the master bathroom. There is nothing of value here at this position. From the master bathroom, the player can move to the
	 * 	 kitchen or the garage.
	 *   The boolean variable firstMasterBathroom is used to change dialogue.
	 */
	public void masterBathroom()
	{
		stationary = true;
		
		if (firstMasterBathroom == false)
		{
			System.out.println("The master bathroom is clearly undergoing renovations. \nOnly the toilet, sink, and shower are currently installed. \nI should continue on with the rest of the house.");
			firstMasterBathroom = true;
		}
		
		else if (firstMasterBathroom == true)
		{
			System.out.println("I should leave this bathroom.");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Head back to the kitchen. \n(2) Go to master bedroom.  \n(3) Move to the western hallway. \n(4) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Head back to the kitchen") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I exit the bathroom.");
				stationary = false;
				kitchen();
			}
			
			else if (answer.equalsIgnoreCase("Go to master bedroom") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I exit the bathroom.");
				stationary = false;
				masterBedroom();
			}
			
			else if (answer.equalsIgnoreCase("Move to the western hallway") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				System.out.println("I leave the bathroom and enter the hall.");
				stationary = false;
				leftHallway();
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				openInventory();
			}
		}	
	}
	
	
	
	
	/**
	 * This method is called to move the player to the backyard. From this position, there isn't anything that changes the game. 
	 *   From this position, the player can move to the kitchen or to the dog house.
	 *   The boolean variable firstBackyard is used to change dialogue.
	 */
	public void backyard()
	{
		stationary = true;
		
		if (firstBackyard == false)
		{
			System.out.println("I step out back and see that the moon is at its peak. \nMy time here must soon come to an end if I wish to safely escape. \nAcross the lawn a snarling rottweiler, pinned to his house, looks through me. \nBehind the beast, a beam of moonlight is being reflected off of a small object. \nWhere should I move next?");
			firstBackyard = true;
		}
		
		else if (firstBackyard == true)
		{
			System.out.println("I return to the backyard. \nMan, that moon is huge tonight.");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Head back to the kitchen. \n(2) Approach the rottweiler.  \n(3) Search surroundings for anything useful. \n(4) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Head back to the kitchen") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I make my way back inside.");
				stationary = false;
				kitchen();
			}
			
			else if (answer.equalsIgnoreCase("approach the rottweiler") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				stationary = false;
				dogHouse();
			}
			
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				System.out.println("I search the surrounding area, but find nothing but dog feces. \nI should move on.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				openInventory();
			}
		}	
	}
	
	
	
	
	/**
	 * This method is used to move the player to the dog house in the backyard. At this position, the player can find the hexagonal disk used to get the crystal key.
	 *   When trying to grab the hexagonal disk, the player will be bit by the dog, getting the dogBite status effect unless the player has the pork knuckle.
	 *   From this position, the player can move to the backyard.
	 *   If the player also has the good boy toy, a secret dialogue commences. 
	 *   The boolean variable firstDogHouse is used here. 
	 */
	public void dogHouse()
	{
		stationary = true;
		
		if (backpack [8] == "good boy toy")
		{
			System.out.println("I bet the bone I found earlier in the basement belongs to this dog. \nShould I give it to him?");
			System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
			answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I toss the intimidating pooch the toy. \nHe stops growling and fetches the bone. \nHe returns the bone to me, wagging his tail as if he wishes me to toss it again. \nI return the toy into my bag, causing the dog to growl once more, and head out");
			}
			else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
			{
				
			}
		}
		if (backpack [5] != "hexagonal disk")
		{
			if (firstDogHouse == false)
			{
				System.out.println("Now only feet away from the muscular rottweiler, I feel my heart pounding in my ears. \nHopefully he doesn't break off of his chain. \nBehind him, I can now identify the object creating the reflection to be a jade disk. \nWhat should I do?");
				firstDogHouse = true;
			}
			
			else if (firstDogHouse == true)
			{
				System.out.println("I return to the dog and the shiny disk behind him is still there. \nHow will I go about this?");
			}
			
			while (stationary == true)
			{
				System.out.println("\nPossible Moves:\n(1) Return to the back door. \n(2) Attempt to grab the disk behind the dog.  \n(3) Search surroundings for anything useful. \n(4) Open inventory.");
					answer = scan.nextLine();
				
				if (answer.equalsIgnoreCase("Return to the back door") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("I head over to the back door.");
					stationary = false;
					backyard();
					}
					
				else if (answer.equalsIgnoreCase("Attempt to grab the disk behind the dog") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
				{
					System.out.println("The dog's growling intensifies. \nIf I try to grab this disk, I better proceed with caution. \nI wouldn't put it past this animal to attack me. \nShould I go through with it?");
					System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
						answer = scan.nextLine();
					
					if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
					{
						if (backpack [4] == "pork knuckle")
						{
							System.out.println("I slowly make my way around the dog.\nSurprisingly, he stops growling, and instead, begins nuzzling my bag. \nI bet he's trying to get at that pork knuckle! \nI bend over and retrieve the small disk before making my escape.");
							backpack [5] = "hexagonal disk";
							dogHouse();
						}
						else if (backpack [4] != "pork knuckle")
						{
							System.out.println("I slowly try to make my way around the dog. \nJust as I grab the disk, the dog pounces on me and begins to shred my leg. \nI manage to release its jaws and limp away from the monster. \nI retreat to the house where I try to stop the bleeding before continuing my search.");
							dogBite = true;
							backpack [5] = "hexagonal disk";
							dogHouse();
						}
					}
					else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
					{
						System.out.println("I bet that disk is just one of his toys. \nI should go back to the house.");
						backyard();
					}
				}
				
				else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
				{
					System.out.println("I rotate around the dog house, but find nothing worth noting.");
				}
				
				else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
				{
					openInventory();
				}
			}
		}
		
		
		else if (backpack [5] == "hexagonal disk")
		{
			//change options. this means player is returning to dog after having disk
			System.out.println("The animal still growls at me, but I believe he is beginning to calm as he gets used to my presence. \nHe watches me cautiously. \nWhat should I do now?");
			while (stationary == true)
			{
				System.out.println("\nPossible Moves:\n(1) Return to the back door. \n(2) Search surroundings for anything useful. \n(3) Open inventory.");
					answer = scan.nextLine();
				
				if (answer.equalsIgnoreCase("Return to the back door") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("I head over to the back door.");
					stationary = false;
					backyard();
					}
				else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
				{
					System.out.println("I rotate around the dog house, but find nothing worth noting.");
				}
				
				else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
				{
					openInventory();
				}	
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the western hallway in the house. From this position, the player can move to the garage, the master bathroom or the kitchen. 
	 *   There are not any game changing actions found at this position.
	 */
	public void leftHallway()
	{
		stationary = true;
		
		System.out.println("Here from the western hallway, I can reach the garage, the kitchen, or the master bathroom. \nWhat should I do?");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Head back to the kitchen. \n(2) Enter the master bathroom. \n(3) Go to the garage. \n(4) Search surroundings for anything useful. \n(5) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Head back to the kitchen") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				stationary = false;
				kitchen();
			}
			
			else if (answer.equalsIgnoreCase("Enter the master bathroom") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I move to the bathroom.");
				stationary = false;
				masterBathroom();
			}
			
			else if (answer.equalsIgnoreCase("go to the garage") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				stationary = false;
				garage();
			}
			
			else if (answer.equalsIgnoreCase("Search surroundings for anything useful") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				System.out.println("A small table sits along the wall. \nI look inside and find hundreds of unopened envelopes from unpaid bills. \nWhere should I move next?");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(5)") || answer.equalsIgnoreCase("5"))
			{
				openInventory();
			}
		}	
	}
	
	
	
	
	/**
	 * This method is called to move the player to the garage. From the garage, the player must find the silver key inside of the garageSafe. 
	 *  This method uses the boolean variables firstGarage and safeOpen to change dialogue.
	 */
	public void garage()
	{
		stationary = true;
		
		if (firstGarage == false)
		{
			System.out.println("I enter the garage and am shocked to find a red station wagon is parked inside. \nI look around the room and spot a large digital safe in the corner. \nI should probably search the house for a combination.");
			firstGarage = true;
		}
		else if (firstGarage == true)
		{
			if (safeOpen == false)
			{
				System.out.println("I return to the middle of the garage. \nMaybe I can figure out the combination.");
			}
			else if (safeOpen == true)
			{
				System.out.println("I stand in the middle of the garage. \nI doubt I will find anything else of importance here.");
			}
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Return to the western hallway. \n(2) Look at digital safe. \n(3) Search the room for clues. \n(4) Open inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Return to the western hallway") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I exit the garage.");
				stationary = false;
				leftHallway();
			}
			
			else if (answer.equalsIgnoreCase("look at digital safe") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				if (safeOpen == false)
				{
					System.out.println("I stand in front of the safe, ready to start guessing codes. \nI hope incorrectly entering numbers won't set off an alarm. \nShould I still guess?");
					System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
						answer = scan.nextLine();
				
					if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
					{
						garageSafe();
					}
					
					else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
					{
						System.out.println("I should come back when I know the code.");
						garage();
					}
				}
				
				else if (safeOpen == true)
				{
					System.out.println("The safe remains wide open and there is nothing left inside. \nI should get back to looking for the feather.");
					garage();
				}
			}
			
			else if (answer.equalsIgnoreCase("Search the room for clues") || answer.equalsIgnoreCase("search") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				System.out.println("I poke around the garage but fail to find much of value. \nThe only items that turn up are a bunch of old receipts and some information about the red car. \nWhat should I do?");
				
				while (stationary == true)
				{
					System.out.println("\nPossible Moves:\n(1) Continue searching the garage. \n(2) Inspect receipts. \n(3) Inspect car information.");
						answer = scan.nextLine();
					
					if (answer.equalsIgnoreCase("continue searching the garage") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
					{
						stationary = false;
						garage();
					}
					
					else if (answer.equalsIgnoreCase("Inspect receipts") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
					{
						System.out.println("The purchases shown by the receipts are: \n* $128.36 \n* $7.60 \n* $214.06 \n* $12.84");
					}
					
					else if (answer.equalsIgnoreCase("Inspect car information") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
					{
						System.out.println("The only information I find on the station wagon is that it was purchased in 2001 and that its license plate is 6T8-3U4.");
					}
				}					
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				openInventory();
			}
		}	
	}
	
	
	
	
	/**
	 * This method is called when the player attempts to unlock the digital safe found in the garage. The safe scans the users input and compares it to the actual 
	 *  string containing the correct passcode. If the user gives the correct password, the safe is opened. If not, the safe gives the option to try again. 
	 */
	
	public void garageSafe()
	{
		String code;
		System.out.println("|Please Enter the 4 Digit Code|");
			code = scan.nextLine();
	
		if (code.equalsIgnoreCase("6834"))
		{
			System.out.println("The safe's interface beeps and the door opens. \nInside is a single silver key. \nI will likely need this.");
			System.out.println("I add the silver key to my backpack.");
			backpack [2] = "silver key";
			safeOpen = true;
			garage();
		}
		else
		{
			System.out.println("A red light beeps, indicating that that the safe remains locked. \nShould I try again? ");
			System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				garageSafe();
			}
			
			else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
			{
				System.out.println("I should come back when I know the code.");
				garage();
			}
		}
	}
	
	
	
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				Start of methods for Basement portion of game.
	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	
	/**
	 * This is the method is called to move the player down to the basement - position x = 0 , y = 0. From this location, the player will find themselves looking in two different directions.
	 *   There are two hidden passages as well here. The player will require the sledgehammer in their inventory to go to the hidden passages. 
	 *   The boolean variable justReachBasement, justStartSearch, wallEastBroken, wallWestBroken are all used to change the text printed.
	 *   (0,0)
	 */
	public void baseOrigin() 
	{		
		x = 0;
		y = 0;
		stationary = true;
		
		if (justReachBasement == false)
		{
			System.out.println("To my surprise, these steps go down far more than expected. \nI feel the temperature of the air drop significantly as I scale further down into the earth. \nA strange pungent odor fills the air, giving me an uneasy feeling. \nThis golden feather better be down here somewhere.");
			System.out.println("Minutes pass and I finally arrive at the bottom. \nDim lights glow along the walls of what appear to be endless hallways. \nStationed in front of the stairs is a small map displaying the labyrinth before me. \nI take note of the passages and move on. \nWhere should I head to first?");
			justReachBasement = true;
		}
		else 
		{
			System.out.println("\nI return to the staircase. \nWhere should I head next?");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Go Upstairs \n(2) Move North \n(3) Move West \n(4) Look East \n(5) Look South \n(6) Open Inventory");
	
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Go Upstairs") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)") || answer.equalsIgnoreCase("Upstairs"))
			{
				System.out.println("I begin hauling myself up the lengthy staircase.");
				stationary = false;
				frontBathroom();
				
			}
			else if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				if (startOfSearch == false)
				{
					System.out.println("I begin to move north, leaving the false security that the staircase provided me. \nI pray that I will be able to find my way back after I find what I am searching for.");
					startOfSearch = true;
					stationary = false;
					base01();
				}
				else
				{
					System.out.println("I move North.");
					stationary = false;
					base01();
				}
			}
			
			else if (answer.equalsIgnoreCase("Move West") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
			{
				if (startOfSearch == false)
				{
					System.out.println("I begin to move west, leaving the false security that the staircase provided me. \nI pray that I will be able to find my way back after I find what I am searching for.");
					startOfSearch = true;
					stationary = false;
					baseNeg10();
				}
				else
				{
					System.out.println("I move west.");
					stationary = false;
					baseNeg10();
				}
			}
			else if (answer.equalsIgnoreCase("Look East") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)"))
			{
				if (wallEastBroken == false)
				{
					System.out.println("There appears to be light piercing through the cracks in this wall. \nIs there something behind here?");
				}
				else 
				{
					System.out.println("I move east into the uncharted tunnels.");
					stationary = false;
					base10();
				}
				
				if (backpack[9] != "sledgehammer")
				{
					System.out.println("Maybe I can continue searching around to find something to help break through.");
				}
	
				
				if (wallEastBroken == false)
				{
					if (backpack[9] == "sledgehammer")
					{
						if (wallSouthBroken == false)
						{
							System.out.println("Maybe I can break through this wall using the hammer.\nWith ease, I tumble both of the ancient walls, exposing a new pathway. \nWith this new discovery, I can feel the adrenaline pumping through my veins. \nI hurry east along this new passage.");
							wallEastBroken = true;
							wallSouthBroken = true;
							stationary = false;
							base10();
						}
					}
					else
					{
						System.out.println("For now, I should return to the staircase.");
						baseOrigin();
					}
				}
			}
			else if (answer.equalsIgnoreCase("Look South") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)"))
			{
				if (wallSouthBroken == false)
				{
					System.out.println("There appears to be light piercing through the cracks in this wall. \nIs there something behind here?");
				}
				else
				{
					System.out.println("I wander south into the unknown portion of the tunnels.");
					stationary = false;
					base0Neg1();
				}
				if (backpack[9] != "sledgehammer")
				{
					System.out.println("Maybe I can continue searching around to find something to help break through.");
				}
		
				if (wallSouthBroken == false)
				{
					if (backpack[9] == "sledgehammer")
					{
						if (wallEastBroken == false)
						{
							System.out.println("Maybe I can break through this wall using the hammer.\nWith ease, I tumble both of the ancient walls, exposing a new pathway. \nWith this new discovery, I can feel the adrenaline pumping through my veins. \nI hurry south along this new passage.");
							wallSouthBroken = true;
							wallEastBroken = true;
							stationary = false;
							base0Neg1();
						}
					}
					else
					{
						System.out.println("For now, I should return to the staircase.");
						baseOrigin();
					}
				}
			}	
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("6") || answer.equalsIgnoreCase("(6)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = 0 , y = 1. At this location, nothing game changing is found.
	 *   The boolean variable justMovingIn is used to alter dialogue. 
	 *   (0,1)
	 */
	public void base01()
	{
		x = 0;
		y = 1;
		stationary = true;
		
		
		if (justMovingIn == false)
		{
			System.out.println("As I look around me, there appears to be nothing but smooth stone walls. \nHow will I find my way around this labyrinth?");
			justMovingIn = true;
		}
		else if (justMovingIn == true)
		{
			System.out.println("Around me, nothing has changed. \nThere appears to be nothing but the same cold stone walls. \nI can see the staircase nearby.");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move West \n(2) Move East \n(3) Move South \n(4) Look Up \n(5) Feel Walls \n(6) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I head east.");
				stationary = false;
				base11();
			}
			
			else if (answer.equalsIgnoreCase("Move West") || answer.equalsIgnoreCase("West") || answer.equalsIgnoreCase("W") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I proceed west.");
				stationary = false;
				baseNeg11();
			}
			
			else if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
			{
				System.out.println("I move south.");
				stationary = false;
				baseOrigin();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("On the ceiling, there appears to be a symbol of a raven.");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)")) 
			{
				System.out.println("Nothing seems to be special about these walls.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("6") || answer.equalsIgnoreCase("(6)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = 1 , y = 1. At this location, nothing game changing is found.
	 *   The boolean variable feelingLost is used to alter dialogue. 
	 *   (1,1)
	 */
	public void base11()
	{
		x = 1;
		y = 1;
		stationary = true;
		
		if (feelingLost == false)
		{
			System.out.println("Wow! I am already beginning to feel completely lost... \nAround me, I see nothing but ragged stone walls.");
			feelingLost = true;
		}
		else if (feelingLost == true)
		{
			System.out.println("Nothing appears to have changed since I was last here; there are plain stone walls everywhere.");
		}
			
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move North \n(2) Move West \n(3) Look Up \n(4) Feel Walls \n(5) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I head north.");
				stationary = false;
				base12();
			}
				
			else if (answer.equalsIgnoreCase("Move West") || answer.equalsIgnoreCase("West") || answer.equalsIgnoreCase("W") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I go west.");
				stationary = false;
				base01();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
			{
				System.out.println("On the ceiling, there appears to be a symbol of a sun.");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("Nothing seems to be special about these walls.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = 1 , y = 2. At this location, the sledgehammer is found.
	 *   (1,2)
	 */
	public void base12()
	{
		//Has sledgehammer
		x = 1;
		y = 2;
		stationary = true;
		boolean aboles = false;
		
		while (backpack[9] != "sledgehammer")
		{
			System.out.println("I reach a dead end with nothing but a sledgehammer in the middle of the floor. \nShould I take a better look?");
			System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
				answer = scan.nextLine();
				
				if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					aboles = false;
				}
				else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
				{
					System.out.println("Where should I carry on to next?");
					
					while (stationary == true)
					{
						System.out.println("\nPossible Moves:\n(1) Move South \n(2) Look Up \n(3) Feel Walls \n(4) Open Inventory");
							answer = scan.nextLine();
						
						if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
						{
							System.out.println("I return south.");
							stationary = false;
							base11();
						}
						
						else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2")) 
						{
							System.out.println("On the ceiling, there appears to be a symbol of a hammer.");
						}
						
						else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
						{
							System.out.println("Nothing seems to be special about these walls.");
						}
						
						else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)"))
						{
							openInventory();
						}
					}
				}
			
			
			while (aboles == false)
			{
				System.out.println("The hammer looks old, but it appears to be capable of inflicting damage. \nShould I bring it with me?");
				System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
					answer = scan.nextLine();
				
				if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("The sledgehammer is added to my backpack.");
					backpack[9] = "sledgehammer";
					aboles = true;
				}
				else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
				{
					System.out.println("I return back to the center of the hallway.");
					aboles = true;
				}
			}
		}
		
			System.out.println("I hope the sledgehammer I found here proves to be useful... \nWhere should I carry on to next?");
			
			while (stationary == true)
			{
				System.out.println("\nPossible Moves:\n(1) Move South \n(2) Look Up \n(3) Feel Walls \n(4) Open Inventory");
					answer = scan.nextLine();
				
				if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("I return south.");
					stationary = false;
					base11();
				}
				
				else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2")) 
				{
					System.out.println("On the ceiling, there appears to be a symbol of a hammer.");
				}
				
				else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
				{
					System.out.println("Nothing seems to be special about these walls.");
				}
				
				else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)"))
				{
					openInventory();
				}
			}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = -1 , y = 1. At this location, nothing game changing is found.
	 *   (-1,1)
	 */
	public void  baseNeg11()
	{
		x = -1;
		y = 1;
		stationary = true;
	
		System.out.println("There appears to be nothing out of the ordinary here. \nFrom my position, I can move in three directions. \nWhere should I go next?");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move North \n(2) Move East \n(3) Move West \n(4) Look Up \n(5) Feel Walls \n(6) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I proceed north.");
				stationary = false;
				baseNeg12();
			}
			
			else if (answer.equalsIgnoreCase("Move West") || answer.equalsIgnoreCase("West") || answer.equalsIgnoreCase("W") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
			{
				System.out.println("I continue west, making sure to avoid the scattered shards of glass. \nThis place is a total mess...");
				stationary = false;
				baseNeg21();
			}
			
			else if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I move east. \nThis way has to be getting close to the stairwell again.");
				stationary = false;
				base01();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("What the... \nA Jesus fish!? \nThis doesn't seem very fitting. \nWhere to now?");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)")) 
			{
				System.out.println("I swiftly pass my hands along the rough walls. \nI can't detect any hidden secrets. \nHow should I carry on?");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("6") || answer.equalsIgnoreCase("(6)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = -1 , y = 2. At this location, nothing game changing is found.
	 *   (-1,2)
	 */
	public void baseNeg12()
	{
		x = -1;
		y = 2;
		stationary = true;

		System.out.println("Really, another dead end... \nThis place is going to be the death of me. \nWhat will I do?");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move South \n(2) Look Up \n(3) Feel Walls \n(4) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I return from where I came.");
				stationary = false;
				baseNeg11();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2")) 
			{
				System.out.println("Above me, a large bull is painted on the ceiling. \nWhat is next? ");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
			{
				System.out.println("The walls hide nothing behind them. \nI should move on.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = -2 , y = 1. At this location, nothing game changing is found.
	 *   (-2,1)
	 */
	public void baseNeg21()
	{
		x = -2;
		y = 1;
		stationary = true;

		System.out.println("I find two divergent paths before me. \nWhich way should I go?");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move North \n(2) Move East \n(3) Move South \n(4) Look Up \n(5) Feel Walls \n(6) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("With little method to my madness, I choose to progress north.");
				stationary = false;
				baseNeg22();
			}
			
			else if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
			{
				System.out.println("Not sure where I'm heading, but south is just as good a guess as any.");
				stationary = false;
				baseNeg20();
			}
			
			else if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I think that moving this direction will lead me back to the stairs.");
				stationary = false;
				baseNeg11();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("A large black snake is shown on the ceiling. \nHopefully this isn't a sign of what's to come... \nWhere to next?");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)")) 
			{
				System.out.println("A small hole is dug into one of the walls. \nI know I must investigate the cavity, but my heart races as I fear the worst--a serpent laying within. \nI quickly plunge my hand within, feeling nothing inside. \nLooks like I got riled up for nothing. \nTime to move on.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("6") || answer.equalsIgnoreCase("(6)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = -2 , y = 2. At this location, nothing game changing is found.
	 *   (-2,2)
	 */
	public void baseNeg22()
	{
		x = -2;
		y = 2;
		stationary = true;

		System.out.println("Man, these passages in this area are getting pretty tight. \nI find myself on the verge of getting stuck during this portion of the tunnel. \nMaybe I should get back to an open hallway.");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move North \n(2) Move South \n(3) Move West \n(4) Look Up \n(5) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I continue to squeeze through the narrow hall, slowly making my way north.");
				stationary = false;
				baseNeg23();
			}
			
			else if (answer.equalsIgnoreCase("Move West") || answer.equalsIgnoreCase("West") || answer.equalsIgnoreCase("W") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
			{
				System.out.println("I wedge my way further west.");
				stationary = false;
				baseNeg32();
			}
			
			else if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I happily move south. \nI can't wait to get out of this claustrophic area.");
				stationary = false;
				baseNeg21();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("As I look up, there appears to be a moon.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)"))
			{
				System.out.println("I don't have enough space to open my backpack here. \nI will have to wait until I can move freely again.");
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = -3 , y = 2. The dog toy can be discovered at this location. Different dialogue options are 
	 * 	 displayed if the player has the dog toy vs not.
	 *   (-3,2)
	 */
	public void baseNeg32()
	{
		//Has goodBoyToy
		x = -3;
		y = 2;
		stationary = true;
		boolean aboles = false;
		
		while (backpack[8] != "good boy toy")
		{
			System.out.println("To travel further into this section, I will have to continue crawling on my hands and knees. \nTo make matters worse, there doesn't appear to be any lights ahead. \nIs it worth venturing onward?");
			System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
				answer = scan.nextLine();
		
				if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					aboles = false;
				}
				else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
				{
					System.out.println("Where should I carry on to next?");
					
					while (stationary == true)
					{
						System.out.println("\nPossible Moves:\n(1) Move East \n(2) Look Up \n(3) Feel Walls \n(4) Open Inventory");
							answer = scan.nextLine();
						
						if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
						{
							System.out.println("I return east, where I can at least stand up.");
							stationary = false;
							baseNeg22();
						}
						
						else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2")) 
						{
							System.out.println("I attempt to look up, but I lack the space to do so. \nWhat will I do next?");
						}
						
						else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
						{
							System.out.println("I rub my hands along the walls, anticipating an alternate path. \nI find nothing. \nI should continue searching.");
						}
						
						else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)"))
						{
							System.out.println("There is no way I can rummage through my backpack now. \nI will definitely need to wait until I have more space. \nWhere to?");
						}
					}
				}
			
			
			while (aboles == false)
			{
				System.out.println("I conquer my fear of the unknown, and I begin crawling into the dark hole. \nI feel my knees being torn apart by the coarse floor. \nSuddenly, a shrill squeek breaks the sound of my panting. \nWhat could this be? \nI feel for the object and discover the sound to have belonged to a large rubber dog toy. \nFor some reason, I feel as if I should bring it with me. \nShould I?");
				System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
				answer = scan.nextLine();
			
				if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("The rubber dog toy is placed in my backpack");
					backpack[8] = "good boy toy";
					aboles = true;
				}
				else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
				{
					System.out.println("I begin to shimmy my way backwards to where I once was.\nI really think I ought to head back for that toy.");
					aboles = true;
				}
			}
		}
		
			System.out.println("I think it's time to head out of this crawl space. \nI really should get back to where I can stand.");
			
			while (stationary == true)
			{
				System.out.println("\nPossible Moves:\n(1) Move East \n(2) Look Up \n(3) Feel Walls \n(4) Open Inventory");
				answer = scan.nextLine();
			
				if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("I return east, where I can at least stand up.");
					stationary = false;
					baseNeg22();
				}
			
				else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2")) 
				{
					System.out.println("I attempt to look up, but I lack the space to do so. \nWhat will I do next?");
				}
			
				else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
				{
					System.out.println("I rub my hands along the walls, anticipating an alternate path. \nI find nothing. \nI should continue searching.");
				}
				
				else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)"))
				{
					System.out.println("There is no way I can rummage through my backpack now. \nI will definitely need to wait until I have more space. \nWhere to?");
				}
			}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = -2 , y = 3. At this location, nothing game changing is found.
	 *   (-2,3)
	 */
	public void baseNeg23()
	{
		x = -2;
		y = 3;
		stationary = true;
		
		System.out.println("No way I really jammed myself in this crack to end up at a dead end... \nI can't envision there being anything back here. \nWhat should I do?");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move South \n(2) Look Up \n(3) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I exhale deeply as I try to make space for my body to fit through the narrow passage. \nI begin inching south.");
				stationary = false;
				baseNeg22();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2")) 
			{
				System.out.println("I try to look up, but there's barely enough room to move my head. \nI think there may be a butterfly on the ceiling.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
			{
				System.out.println("It's nearly impossible to move my arms. \nThere's no way I will be able to inspect my inventory.");
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = -2 , y = 0. At this location, nothing game changing is found
	 *   (-2,0)
	 */
	public void baseNeg20()
	{
		x = -2;
		y = 0;
		stationary = true;
		
		System.out.println("I stop at a corner within the tunnels. \nIn one direction, I believe I can make out the stairwell in the distance. \nHow should I carry on?");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move North \n(2) Move East \n(3) Look Up \n(4) Feel Walls \n(5) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I begin making my way north. \nFar ahead I see large cracks in the wall.");
				stationary = false;
				baseNeg21();
			}
				
			else if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("e") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I begin the long walk east. \nI'm confident the spiral stairs are just further ahead.");
				stationary = false;
				baseNeg10();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
			{
				System.out.println("Above me, a black lizard has been painted. \nI'll take note of that.");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("Nothing more than the plain stone walls seen everywhere else. \nI should move.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = -1 , y = -0. At this location, nothing game changing is found.
	 *   The boolean variable justMovingIn is used to alter dialogue. 
	 *   (-1,0)
	 */
	public void baseNeg10()
	{
		x = -1;
		y = 0;
		stationary = true;
		
		if (justMovingIn == false)
		{
			System.out.println("As I look around me, there appears to be nothing but smooth stone walls. \nHow will I find my way around this labyrinth?");
			justMovingIn = true;
		}
		else
		{
			System.out.println("Around me, nothing has changed. \nI can see that I am near the stairs in case I require I speedy escape.");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move West \n(2) Move East \n(3) Move South \n(4) Look Up \n(5) Feel Walls \n(6) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I quickly shuffle back to the stairs.");
				stationary = false;
				baseOrigin();
			}
			
			else if (answer.equalsIgnoreCase("Move West") || answer.equalsIgnoreCase("West") || answer.equalsIgnoreCase("W") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I traverse deeper west.");
				stationary = false;
				baseNeg20();
			}
			
			else if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
			{
				System.out.println("I make my way south.");
				stationary = false;
				baseNeg1Neg1();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("In this area, there is a multitude of pottery designs painted on the ceiling.");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)")) 
			{
				System.out.println("The walls in this area are surpisingly smooth. \nI continue to look around, but ultimately find nothing. \nI should continue.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("6") || answer.equalsIgnoreCase("(6)"))
			{
				System.out.println("Soon I'll be able to add that feather to my collection.");
				openInventory();
			}
		}
		
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = -1 , y = -1. At this position, the player will discover the tattered may that hints at hidden 
	 *   passages by the stair case in the basement.
	 *   Uses the boolean variable justSeeingMap to alter dialogue.
	 *  (-1,-1)
	 */
	public void baseNeg1Neg1()
	{
		
		x = -1;
		y = -1;
		stationary = true;
		
		if (justSeeingMap == false)
		{
			System.out.println("I enter into a dead end. \nEvery surface of this passage is completely soaked with what I presume to be water. \nAgainst the far wall is another piece of paper like the one seen at the stairwell. \nI hurry over and discover the paper to be a map which has been heavily damaged by the water surrounding it. \nThe map suggests that there may be alternate passageways hidden by the stairwell. \nI really ought to investigate.");
			justSeeingMap = true;
		}
		else
		{
			System.out.println("This is the same area where the damaged map was found. \nI should look into the secret tunnels.");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move North \n(2) Look Up \n(3) Feel Walls \n(4) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I hurry north to move out of the damp area.");
				stationary = false;
				baseNeg10();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2")) 
			{
				System.out.println("A faded star is depicted on the ceiling.");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
			{
				System.out.println("Man, these walls are absolutely drenched.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position at x = 0  , y = -1. There are no game changing interactions at this position.
	 *   The boolean variable enterBrokenWall is used here to change dialogue.
	 *   (0,-1)
	 */
	public void base0Neg1()
	{
		x = 0;
		y = -1;
		stationary = true;
		
		if (enterBrokenWall == false)
		{
			System.out.println("As I enter into this new portion of the tunnel system, the foul odor I had detected earlier intensifies. \nAt once, I notice there to be hundreds of shelves lined up along the walls with each holding a wrapped corpse. \nI know I'm no saint, but what kind of monster has this many victims in their basement. \nI really must hurry up with this job...");
			enterBrokenWall = true;
		}
		else
		{
			System.out.println("I am positioned at a 'T' in the unmapped portion of the tunnel system. \nWhere should I proceed?");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move North \n(2) Move East \n(3) Move South \n(4) Look Up \n(5) Feel Walls \n(6) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I begin walking back north to the staircase.");
				stationary = false;
				baseOrigin();
			}
			
			else if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I delve deeper in the cave.");
				stationary = false;
				base1Neg1();
			}
			
			else if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
			{
				System.out.println("I continue down south.");
				stationary = false;
				base0Neg2();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("On the ceiling, there appears to be a strange rune shaped like the letter F.");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)")) 
			{
				System.out.println("These corpses are disgusting. \nI will refrain from feeling them.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("6") || answer.equalsIgnoreCase("(6)"))
			{
				openInventory();
			}
		}
	}

	
	
	
	
	/**
	 * This method is called to move the player to the basement position at x = 0 , y = -2. There are no game changing interactions at this position.
	 *   (0,-2)
	 */
	public void base0Neg2()
	{
		x = 0;
		y = -2;
		stationary = true;
		
		System.out.println("Around me are more and more corpses. \nLooks like I only have two ways to go.");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move North \n(2) Move West \n(3) Look Up \n(4) Feel Walls \n(5) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I move north.");
				stationary = false;
				base0Neg1();
			}
			
			else if (answer.equalsIgnoreCase("Move West") || answer.equalsIgnoreCase("West") || answer.equalsIgnoreCase("W") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I continue west, making sure to avoid the large pool of viscous fluid on the ground.");
				stationary = false;
				baseNeg1Neg2();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
			{
				System.out.println("Once again, a n shaped rune is shown above me.");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("Sweet! One of the corpses appears to be wearing a gold ring. \nI think it's best to keep away from it though...\nI return to the center of the hallway. \nWhat should I do now?");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position at x = -1 , y = -2. There are no game changing interactions at this position.
	 *   The boolean variable Neg1Neg2Disc is used here to give different dialogues.
	 *   (-1,-2)
	 */
	public void baseNeg1Neg2()
	{
		x = -1;
		y = -2;
		stationary = true;
		
		System.out.println("Once again, I am positioned at a 'T' in the passageway. ");
		
		if (Neg1Neg2Disc == false)
		{
			System.out.print("The same vile fluid seen previously is unavoidable now. \nI am forced to walk through it. \nI hold my breath as I take my first steps.");
			Neg1Neg2Disc = true;
		}
		else
		{
			System.out.print("This black sludge is gonna make me hurl.");
		}
		
		while (stationary == true)
		{
			System.out.println("\n\nPossible Moves:\n(1) Move West \n(2) Move South \n(3) Move East \n(4) Look Up \n(5) Feel Walls \n(6) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I trudge south through the unpleasant liquid.");
				stationary = false;
				baseNeg1Neg3();
			}
			
			else if (answer.equalsIgnoreCase("Move West") || answer.equalsIgnoreCase("West") || answer.equalsIgnoreCase("W") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I carry on west, making sure not to slip.");
				stationary = false;
				baseNeg2Neg2();
			}
			
			else if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
			{
				System.out.println("I make my way back east. \nI can't wait to get out of this mess.");
				stationary = false;
				base0Neg2();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("Another rune, this one shaped like an apple. \nWhat do these mean?");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)")) 
			{
				System.out.println("Disgusting! Positioned on one of the shelves is a corpse whose skin boils from maggots tunneling through their flesh. \nI should get back to searching for the feather.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("6") || answer.equalsIgnoreCase("(6)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position x = -1 , y = -3. At this location, the golden key can be found. 
	 *  The boolean variable Neg1Neg3Disc is used to alter text.
	 *  (-1,-3)
	 */
	public void baseNeg1Neg3()
	{
		//Has goldKey
		x = -1;
		y = -3;
		stationary = true;
		boolean aboles = false;
		
		while (backpack[3] != "gold key")
		{
			if (Neg1Neg3Disc == false)
			{
			System.out.println("I reach a dead end which has corpses piled along every wall. \nThe same substance I've been trudging through oozes from their pores. \nDespite how much I want to turn around, there has to be something of value over there. \nShould I take a better look?");
				Neg1Neg3Disc = true;
			}
			else if (Neg1Neg3Disc == true)
			{
				System.out.println("I am now positioned in the hallway with the oozing corpses. \nShould I search around for something?");
			}
			System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
				answer = scan.nextLine();
			
				if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					aboles = false;
				}
				else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
				{
					System.out.println("Where should I carry on to next?");
					
					while (stationary == true)
					{
						System.out.println("\nPossible Moves:\n(1) Move North \n(2) Look Up \n(3) Feel Walls \n(4) Open Inventory");
							answer = scan.nextLine();
						
						if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
						{
							System.out.println("I start making my way back north.");
							stationary = false;
							baseNeg1Neg2();
						}
						
						else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2")) 
						{
							System.out.println("As expected, there is a symbol on the ceiling. \nThis one resembling a claw.");
						}
						
						else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
						{
							System.out.println("I wouldn't dare run my hands along these corpses for they'd likely burst.");
						}
						
						else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)"))
						{
							openInventory();
						}
					}
				}
			
			
			while (aboles == false)
			{
				System.out.println("I begin scanning the ground, hoping that I find something of use. \nBefore long, I am surprised to see the subtle glint of gold piercing through the liquid. \nUpon closer investigation, I determine the object to be a key. \nShould I collect the key?");
				System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
					answer = scan.nextLine();
			
				if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("The gold key is added to my backpack.");
					backpack[3] = "gold key";
					aboles = true;
				}
				else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
				{
					System.out.println("I stop my search efforts, and make my way back to the center of the space.");
					aboles = true;
				}
			}
		}
		
			System.out.println("This gold key has to be used somewhere in this house. \nI must hurry on. \nWhat should I do now?");
			
			while (stationary == true)
			{
				System.out.println("\nPossible Moves:\n(1) Move North \n(2) Look Up \n(3) Feel Walls \n(4) Open Inventory");
					answer = scan.nextLine();
				
				if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("I start making my way back north.");
					stationary = false;
					baseNeg1Neg2();
				}
				
				else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2")) 
				{
					System.out.println("As expected, there is a symbol on the ceiling. \nThis one resembling a claw.");
				}
				
				else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
				{
					System.out.println("I wouldn't dare run my hands along these corpses for they'd likely burst.");
				}
				
				else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)"))
				{
					openInventory();
				}
			}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position at x = -2 , y = -2. There are no game changing interactions at this position.
	 *   (-2,-2)
	 */
	public void baseNeg2Neg2()
	{
		x = -2;
		y = -2;
		stationary = true;
		
		System.out.println("I approach another dead end. \nI'm surprised to see that there aren't any human remains scattered in this area. \nThere appears to be nothing special with this section. \nWhat should I do next?");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move East \n(2) Look Up \n(3) Feel Walls \n(4) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I return east, regretting that I will have to pass the bloating corpses again..");
				stationary = false;
				baseNeg1Neg2();
			}
						
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2")) 
			{
				System.out.println("Nothing special is above me. Just another symbol.");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
			{
				System.out.println("I feel the walls for any hidden passages. \nWithout success, I return to the center of the room.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position at x = 1 , y = -1. There are no game changing interactions at this position.
	 *   (1,-1)
	 */
	public void base1Neg1()
	{
		x = 1;
		y = -1;
		stationary = true;

		System.out.println("There appears to be nothing out of the ordinary here. \nFrom my position, I can move in three directions. \nWhere should I go next?");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move North \n(2) Move East \n(3) Move West \n(4) Look Up \n(5) Feel Walls \n(6) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I march north.");
				stationary = false;
				base10();
			}
			
			else if (answer.equalsIgnoreCase("Move West") || answer.equalsIgnoreCase("West") || answer.equalsIgnoreCase("W") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
			{
				System.out.println("I push westward.");
				stationary = false;
				base0Neg1();
			}
			
			else if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I move east, although there appears to be a dead end soon.");
				stationary = false;
				base2Neg1();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("Nothing but a strange rune which is too faded to identify. \nWhat's next?");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)")) 
			{
				System.out.println("I inspect the numerous shelves, ultimately finding nothing of value. \nWhat should I do now?");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("6") || answer.equalsIgnoreCase("(6)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position at x = 2 , y = 1. There are no game changing interactions at this position.
	 *   (2,1)
	 */
	public void base2Neg1()
	{
		x = 2;
		y = -1;
		stationary = true;
		
		System.out.println("Dang, another dead end. \nThe walls look like they will cave in soon. \nI really ought to head out. \nWhere should I go next?");
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move West \n(2) Look Up \n(3) Feel Walls \n(4) Open Inventory");
				answer = scan.nextLine();
		
			if (answer.equalsIgnoreCase("Move West") || answer.equalsIgnoreCase("West") || answer.equalsIgnoreCase("W") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I quickly escape the area. \nI'd hate to make it this far just to get crushed by falling stones.");
				stationary = false;
				base1Neg1();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2")) 
			{
				System.out.println("The stones above me begin to crumble. \nI should hurry.");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
			{
				System.out.println("I nearly jump out of my skin as a boulder crashes down next to me. \nThis place is a deathtrap. \nWhat are my next actions? ");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position at x = 1 , y = 0. There are no game changing interactions at this position.
	 * 	 The boolean value enterBrokenWall is used in this method.
	 *   (1,0)
	 */
	public void base10()
	{
		x = 1;
		y = 0;
		stationary = true;
		
		if (enterBrokenWall == false)
		{
			System.out.println("As I enter into this new portion of tunnel system, the foul odor I had detected earlier intensifies. \nAt once, I notice there to be hundreds of shelves lined up along the walls with each holding a wrapped corpse. \nI know I'm no saint, but what kind of monster has this many victims in their basement. \nI really must hurry up with this job...");
			enterBrokenWall = true;
		}
		else
		{
			System.out.println("I am positioned at a 'T' in the hidden portion of the tunnel system. \nWhere should I proceed?");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move West \n(2) Move East \n(3) Move South \n(4) Look Up \n(5) Feel Walls \n(6) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move East") || answer.equalsIgnoreCase("East") || answer.equalsIgnoreCase("E") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I carry on east.");
				stationary = false;
				base20();
			}
			
			else if (answer.equalsIgnoreCase("Move West") || answer.equalsIgnoreCase("West") || answer.equalsIgnoreCase("W") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I move west to the entrance.");
				stationary = false;
				baseOrigin();
			}
			
			else if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
			{
				System.out.println("I go deeper south.");
				stationary = false;
				base1Neg1();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("On the ceiling, there is a flag-like shape.");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)")) 
			{
				System.out.println("I don't think think I should tamper with these corpses. \nI'd probably get cursed or something.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("6") || answer.equalsIgnoreCase("(6)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the basement position at x = 2 , y = 0. There are no game changing interactions at this position.
	 *   (2,0)
	 */
	public void base20()
	{
		x = 2;
		y = 0;
		stationary = true;
		
		if (spikeTrapFirstTime == false)
		{
			System.out.println("I stop in yet another corner to try to decide where I should head next. \nSuddenly, a violent metallic clang disrupts the silence within the cave. \nI better go investigate the sound.");
			spikeTrapFirstTime = true;
		}
		else
		{
			System.out.println("I stop at the corner where I had previously heard the loud metal clash. \nFar west, I believe I can make out the silhouette of the staircase. \nI should carry on.");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Move West \n(2) Move North \n(3) Look Up \n(4) Feel Walls \n(5) Open Inventory");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I travel north to where I heard the frightening sound.");
				stationary = false;
				base21();
			}
			
			else if (answer.equalsIgnoreCase("Move West") || answer.equalsIgnoreCase("West") || answer.equalsIgnoreCase("W") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I begin to rush west, nearly tripping over my own feet.");
				stationary = false;
				base10();
			}
			
			else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)")) 
			{
				System.out.println("An image of a turtle is spread across the ceiling.");
			}
			
			else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
			{
				System.out.println("I think I am getting paranoid. \nI swear these corpses are beginning to watch me. \nI better move.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the coordinate position x = 2 , y = 1 in the basement. At this position, the player can
	 * 	will find themselves standing in front of the spike trap. Within this method, Math.random() is used to generate a random value to give the player
	 * 	the opportunity to safely jump across the spike trap if they are lucky. In addition, the variable dogBite is incorporated into the jump success chance.
	 * 	If the player was bit by the dog, they only have a 20% chance of success versus 50% if they hadn't been bit.
	 *  (2,1)
	 */
	public void base21()
	{
		x = 2;
		y = 1;
		double random; //random is a double value which helps determine if the player falls in the spike trap when trying to jump across it.
		random = Math.random();
		stationary = true;
		
		if (spikeTrapOff == false)
		{
			if (firstSpikeTrap == false)
			{
				//Dialogue option for player who has just seen spike trap, and the spike trap is still open.
				System.out.println("Woah. I better watch my step. \nTo my right there is a large pitfall trap. \nI can almost guarantee that those violent sounds I just heard came from some form of trap door covering this. \nI really don't think I could jump across this. \nTime to look around.");
				firstSpikeTrap = true;
			}
			else if (firstSpikeTrap == true)
			{
				if (spikeTrapOff == false) 
				{
					//Dialogue option for player who has returned to the spike trap and has not turned the spike trap off.
					System.out.println("I now stand on the western side of the open spike trap. \nWhere should I go next?");
				}
				else if (spikeTrapOff == true) 
				{
					//Dialogue option for player who has returned to the spike trap and has turned the trap off.
					System.out.println("I now stand on the western side of the closed spike trap. \nWhere should I go next?");
				}
			}
			while (stationary == true)
			{
				System.out.println("\nPossible Moves:\n(1) Move North \n(2) Move South \n(3) Attempt Jump \n(4) Look Up \n(5) Feel Walls \n(6) Open Inventory");
					answer = scan.nextLine();
				
				if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("I move north");
					stationary = false;
					base22();
				}
				
				else if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
				{
					System.out.println("I head back south.");
					stationary = false;
					base20();
				}
				
				else if (answer.equalsIgnoreCase("Attempt Jump") || answer.equalsIgnoreCase("Attempt") || answer.equalsIgnoreCase("Jump") || answer.equalsIgnoreCase("J") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
				{
					System.out.println("On second thought, I think I probably could jump across this gap. \nAm I sure about this?");
					System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
						answer = scan.nextLine();
				
					if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
					{
						if (dogBite == true)
						{
							System.out.println("I take a step back before running as fast as I can towards the gap. \nJust before reaching the edge, my injured leg seizes causing my jump to lack full power.");
							
							if (random < 0.80)
							{
								System.out.println("I leap through the air, but fall short several feet causing me to plummit into the spikes below... \nAt least it was a quick death.");
								
								if (normalDifficulty == false)
								{
									System.out.println("\n\n\n\t====RESTARTING CHECKPOINT====\n\n\n");
									base21();
								}
								else if (normalDifficulty == true)
								{
									System.out.println("\n\n\n\t====GAME OVER====");
									restartGame();
								}
							}
							else if (random >= 0.80)
							{
								System.out.println("I leap through the air, but I fall short of the edge. \nFortunately, I manage to grab on and pull myself up on the other side.");
								stationary = false;
								base31();
							}
						}
						
						else if (dogBite == false)
						{
							System.out.println("I take a step back before running as fast as I can towards the gap.");
							
							if (random < 0.50)
							{
								System.out.println("I leap through the air, but fall short several feet causing me to plummit into the spikes below... \nAt least it was a quick death.");
								
								if (normalDifficulty == false)
								{
									System.out.println("\n\n\n\t====RESTARTING CHECKPOINT====\n\n\n");
									base21();
								}
								else if (normalDifficulty == true)
								{
									System.out.println("\n\n\n\t====GAME OVER====");
									restartGame();
								}
							}
							else if (random >= 0.50)
							{
								System.out.println("I leap through the air, but I fall short of the edge. \nFortunately, I manage to grab on and pull myself up on the other side.");
								stationary = false;
								base31();
							}	
						}
					}
				}
				
				else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
				{
					System.out.println("Just another rune. \nI should hurry along.");
				}
				
				else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)")) 
				{
					System.out.println("I perform a brief search of the area and end up empty handed. \nThe elaborate mechanisms used in the pitfall trap are visible, but tampering with them couldn't result well. \nI step back and continue my search.");
				}
				
				else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("6") || answer.equalsIgnoreCase("(6)"))
				{
					openInventory();
				}
			}
		}
		
		else if (spikeTrapOff == true)
		{
			if (crossingSpikes == false)
			{
				System.out.println("It looks like that lever did the trick. \nI should be able to safely cross the trap now.");
				crossingSpikes = true;
			}
			else if (crossingSpikes == true)
			{
				if (spikeTrapOff == false) 
				{
					System.out.println("I now stand on the western side of the open spike trap. \nWhere should I go next?");
				}
				else if (spikeTrapOff == true) 
				{
					System.out.println("I now stand on the western side of the closed spike trap. \nWhere should I go next?");
				}			}
			while (stationary == true)
			{
				System.out.println("\nPossible Moves:\n(1) Move North \n(2) Move South \n(3) Cross trap \n(4) Look Up \n(5) Feel Walls \n(6) Open Inventory");
					answer = scan.nextLine();
				
				if (answer.equalsIgnoreCase("Move North") || answer.equalsIgnoreCase("North") || answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					System.out.println("I proceed north in search of a lever.");
					stationary = false;
					base22();
				}
				
				else if (answer.equalsIgnoreCase("Move South") || answer.equalsIgnoreCase("South") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
				{
					System.out.println("I don't remember any hidden switches south, but I will go double check.");
					stationary = false;
					base20();
				}
				
				else if (answer.equalsIgnoreCase("cross trap") || answer.equalsIgnoreCase("cross") || answer.equalsIgnoreCase("trap") || answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("(3)"))
				{
					System.out.println("I carefully make my way across the trap floor.");
					stationary = false;
					base31();
				}
				
				else if (answer.equalsIgnoreCase("Look Up") || answer.equalsIgnoreCase("Up") || answer.equalsIgnoreCase("U") || answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("(4)")) 
				{
					System.out.println("Just another strange rune. \nI should hurry along.");
				}
				
				else if (answer.equalsIgnoreCase("Feel Walls") || answer.equalsIgnoreCase("Feel") || answer.equalsIgnoreCase("Walls") || answer.equalsIgnoreCase("F") || answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("(5)")) 
				{
					System.out.println("I perform a brief search of the area and end up empty handed. \nThe elaborate mechanisms used in the pitfall trap are visible, but tampering with them couldn't result well. \nI step back and continue my search.");
				}
				
				else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("I") || answer.equalsIgnoreCase("6") || answer.equalsIgnoreCase("(6)"))
				{
					openInventory();
				}
			}
		}
	}
	
	
	
	
	/**
	 * This method is called to move the player to the coordinate position x = 2 , y = 2 in the basement. At this position, the player can
	 * 	find the lever for turning off the spike trap at position x = 2 , y = 1.
	 * (2,2)
	 */
	public void base22()
	{
		x = 2;
		y = 2;
		stationary = true;
		
		
		if (visitLever == false)
		{
			//Dialogue option for player who has just arrived at position (2,2)
			System.out.println("After a couple minutes of walking north, I stumble upon another dead end. \nHowever, there is a single lever on the wall with a skull and crossbones beneath it. \nI begin to worry that pulling it would trigger a trap leading to my imminent death. \nWhat should I do?");
			visitLever = true;
		}
		
		else if (visitLever == true)
		{
			//Dialogue option for player who has returned to the position (2,2)
			System.out.println("I return to the location of the lever with the skull and crossbones beneath it. \nWhat should I do?");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Flip the lever. \n(2) Return South. \n(3) Feel Walls. \n(4) Open Inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Flip the lever") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				System.out.println("I am directly in front of the lever now, but the apprehension that I am experiencing is eating at me. \nI have a very strong feeling that this could end badly if I flip the lever. \nAm I sure I want to do this?");
				System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
					answer = scan.nextLine();
		
				if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
				{
					//Different statements if the player wishes to pull the lever. The lever cannot be turned back off once activated.
					if (spikeTrapOff == false) 
					{
						System.out.println("I pull down the lever, and to my surprise, nothing around me changes. \nI should search around to see if the lever did anything. \nWhere should I go next?");
						spikeTrapOff = true;
					}
					else if (spikeTrapOff == true)
					{
						System.out.println("I tug up on the lever, but it doesn't move an inch. \nI should get out of here.");
						
					}
				}
				
				else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("(2)"))
				{

					System.out.println("I should turn around and look around this kingdom of corpses some more.");
				}
			}
			
			else if (answer.equalsIgnoreCase("return south") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
				System.out.println("I begin walking back south towards the trap.");
				stationary = false;
				base21();
			}
			
			else if (answer.equalsIgnoreCase("feel walls") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				System.out.println("Besides the lever, the only detail worth noting is that the corpses in this area appear to have been better preserved than those in the other portions of the cave. \nI should carry on.");
			}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(4)") || answer.equalsIgnoreCase("4"))
			{
				openInventory();
			}
		}
	}
	
	
	
	
	
	
	/**
	 * This method is called to move the player to the coordinate position x = 3 , y = 1 in the basement. At this position, the player can find the golden feather.
	 * 	To acquire the golden feather, the player must possess all three keys found throughout the game. If not, the player is turned around and forced to search more.
	 * 	At this position, the player will find themselves standing at the eastern side of the spike trap. Within this method, Math.random() is used to generate a 
	 * 	random value to give the player the opportunity to safely jump across the spike trap if they are lucky. In addition, the variable dogBite is incorporated 
	 * 	into the jump success chance. If the player was bit by the dog, they only have a 20% chance of success versus 50% if they hadn't been bit.
	 *	(3,1)
	 */
	public void base31()
	{
		//Has golden feather	
		x = 3;
		y = 1;
		stationary = true;
		double random; //random is a double value which helps determine if the player falls in the spike trap when trying to jump across it.
		random = Math.random();
		
		if (finalWallBroken == false)
		{
			if (crossedTrapBefore == false)
			{
				System.out.println("I take a brief moment after having crossed the spike trap so my heart could settle. \nOnce calmed down a bit, I continue moving east to search for the feather. \nShortly after, I arrive at a dead end. \nI have a hard time believing that there is nothing more back here. \nI should look around.");
				crossedTrapBefore = true;
			}
			else if (crossedTrapBefore == true && finalWallBroken == false)
			{
				System.out.println("I once again stand at the dead end on the eastern side of the spike trap. \nThis doesn't make any sense. \nThere has to be something here.");
			}
		}
		else if (finalWallBroken == true)
		{
			System.out.println("This is the location where I found the golden feather. \nI should escape this house ASAP.");
		}
		
		while (stationary == true)
		{
			System.out.println("\nPossible Moves:\n(1) Go back across the spike trap. \n(2) Investigate room. \n(3) Open Inventory.");
				answer = scan.nextLine();
			
			if (answer.equalsIgnoreCase("Go back across the spike trap") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
			{
				//Add statement for whether spikes are closed or not.
				if (spikeTrapOff == false)
				{
					System.out.println("Do I really wanna go back across the trap yet?");
					System.out.println("\nPossible Moves:\n(1) Yes. \n(2) No.");
						answer = scan.nextLine();
				
					if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("(1)"))
					{
						if (dogBite == true)
						{
							System.out.println("Like before, I take a step back before running as fast as I can towards the gap. \nJust before reaching the edge, my injured leg seizes again resulting in a weak jump.");
							
							if (random < 0.80)
							{
								System.out.println("I leap through the air, but fall short several feet causing me to plummit into the spikes below... \nAt least it was a quick death.");
								
								if (normalDifficulty == false)
								{
									System.out.println("\n\n\n\t====RESTARTING CHECKPOINT====\n\n\n");
									base31();
								}
								else if (normalDifficulty == true)
								{
									System.out.println("\n\n\n\t====GAME OVER====");
									restartGame();
								}
							}
							else if (random >= 0.80)
							{
								System.out.println("I leap through the air, and this time I make it clear across to the other side.");
								stationary = false;
								base21();
							}
						}
						
						else if (dogBite == false)
						{
							System.out.println("Like before, I take a step back before running as fast as I can towards the gap.");
							
							if (random < 0.50)
							{
								System.out.println("I leap through the air, but fall short several feet causing me to plummit into the spikes below... \nAt least it was a quick death.");
								
								if (normalDifficulty == false)
								{
									System.out.println("\n\n\n\t====RESTARTING CHECKPOINT====\n\n\n");
									base31();
								}
								else if (normalDifficulty == true)
								{
									System.out.println("\n\n\n\t====GAME OVER====");
									restartGame();
								}
							}
							else if (random >= 0.50)
							{
								System.out.println("I leap through the air, making it easily on the other side.");
								stationary = false;
								base21();
							}	
						}
					}
				}
				
				else if (spikeTrapOff == true)
				{
					System.out.println("I carefully cross the rickety bridge.");
					base21();
				}
			}
			
			else if (answer.equalsIgnoreCase("Investigate room") || answer.equalsIgnoreCase("(2)") || answer.equalsIgnoreCase("2"))
			{
					if (finalWallBroken == false)
					{
						System.out.println("There is literally nothing in this area upon first glance. \nI feel the walls, when suddenly, I discover a weak spot within the stone. \nMaybe I can break this down. \nI pull out the sledgehammer and crash down the stones. \nOnce the dust had time to settle, I saw it at last--the golden feather! \nI move close to the feather, but it is encased in a glass box which requires three keys. \nI frantically shuffle through my bag for any items that could help me.");
						finalWallBroken = true;
					}
					else if (finalWallBroken == true)
					{
						System.out.println("I walk back up to the glass case housing the gold feather. \nLet me see if I have the required keys to open it.");
					}
					
					//if statements to test if player has all keys. Depending on the number of keys they have, different dialogue options ensue.
					if (backpack [1] == "crystal key" && backpack [2] != "silver key" && backpack [3] != "gold key")
					{
						System.out.println("Sadly, I only have the crystal key. \nI need two more keys. \nI will have to turn back and look some more.");
					}
					else if (backpack [1] == "crystal key" && backpack [2] == "silver key" && backpack [3] != "gold key")
					{
						System.out.println("Sadly, I only have the crystal key and the silver key. \nI need one more key. \nI will have to turn back and look some more.");
					}
					else if (backpack [1] == "crystal key" && backpack [2] == "silver key" && backpack [3] == "gold key")
					{
						//chest opens
						System.out.println("With shaking hands, I pull out a silver, a gold, and a crystal key. \nI socket them into their respective locks and the chest opens! \nI grab the delicate gold feather and secure it in a special container before finishing my mission.");
						System.out.println("\n\n\n\t====CONGRATULATIONS====\n\t    ====YOU WIN====");
						//finish game.
						restartGame();
					}
					else if (backpack [1] != "crystal key" && backpack [2] == "silver key" && backpack [3] != "gold key")
					{
						System.out.println("Sadly, I only have the silver key. \nI need two more keys. \nI will have to turn back and look some more.");

					}
					else if (backpack [1] != "crystal key" && backpack [2] == "silver key" && backpack [3] == "gold key")
					{
						System.out.println("Sadly, I only have the gold key and the silver key. \nI need one more key. \nI will have to turn back and look some more.");

					}
					else if (backpack [1] == "crystal key" && backpack [2] != "silver key" && backpack [3] == "gold key")
					{
						System.out.println("Sadly, I only have the crystal key and the gold key. \nI need one more key. \nI will have to turn back and look some more.");

					}
					else if (backpack [1] != "crystal key" && backpack [2] != "silver key" && backpack [3] == "gold key")
					{
						System.out.println("Sadly, I only have the gold key. \nI need two more keys. \nI will have to turn back and look some more.");

					}
					else if (backpack [1] != "crystal key" && backpack [2] != "silver key" && backpack [3] != "gold key")
					{
						System.out.println("Wow! I can't believe I haven't found a single key yet. \nI will need to turn around and look some more.");
					}
				}
			
			else if (answer.equalsIgnoreCase("Open Inventory") || answer.equalsIgnoreCase("Inventory") || answer.equalsIgnoreCase("(3)") || answer.equalsIgnoreCase("3"))
			{
				openInventory();
			}
		}

	}

}































