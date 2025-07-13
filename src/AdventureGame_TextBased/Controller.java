

package AdventureGame_TextBased;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	private View view;
	private UserStats userInfo;
	private EnemyStats enemyStats;
	private Scanner scanner;
	private Random random;
	private ArrayList<Avatar> avatars;
	private ArrayList<ForestEnemy> enemies;
	private ArrayList<ForestEnemy> hellEnemies;

	public Controller(ArrayList<Avatar> avatars, ArrayList<ForestEnemy> enemies, ArrayList<ForestEnemy> hellEnemies, UserStats userInfo, View view, EnemyStats enemyStats) {

		this.userInfo = userInfo;
		this.enemyStats = enemyStats;
		this.view = view;

		this.scanner = new Scanner(System.in);
		this.random = new Random();

		this.enemies = enemies;
		this.avatars = avatars;
		this.hellEnemies = hellEnemies;
	}

	public void setStart() {
		this.view.welcomeBanner(scanner);
		setUserName();
		chooseAvatar();
		startGame();
		this.view.exitSuccessfully();
		
	}

	public void setUserName() {
		System.out.print("Enter user name: ");
		String userName = scanner.nextLine();
		this.userInfo.setUserName(userName);
	}

	public void chooseAvatar() {
		System.out.println("\nChoose Your Character:\n");
		while (true) {
			this.view.printAvatarList(this.avatars);
			System.out.println("Choice [1-4]");
			int choice = scanner.nextInt();
			if (choice > 0 || choice <= this.avatars.size()) {
				this.userInfo.setUserAvatar(this.avatars.get(choice - 1));
				this.view.printCharacterDesription(userInfo, scanner);
				scanner.nextLine();
				System.out.println();
				this.view.printUserStats(this.userInfo);
				break;
			} else {
				System.out.println("Invalid Choice");
			}

		}

	}

	public void startGame() {
		
		while (this.userInfo.getHealth()>0) {
			System.out.println("\nWhere to go?\n");
			this.view.printChoices();
			System.out.println("\nChoice [1-5]: ");
			String choice = scanner.nextLine();
			
			
			if (choice.equals("1")) {
				goToDarkForest();
			} else if (choice.equals("2")) {
				inToTheDungeon();
				scanner.nextLine();
			} else if (choice.equals("3")) {
				goToShop();
			} else if (choice.equals("4")) {
				this.view.printCharacterDesription(this.userInfo, this.scanner);
				this.view.printUserStats(this.userInfo);
			} else if (choice.equals("5")) {
				return; // return from the setStart(); method
			}else {
				System.out.println("Invalid Command");
			}
		}
		// if the user health is < 0
		System.out.println("Game Over!"); 
	}

	public void goToDarkForest() {
		
		DarkForest:// Label
		while (true) {
			// generating random enemy from an object list
			int randomEnemy = random.nextInt(this.enemies.size());
			this.enemyStats.setEnemyStats(this.enemies.get(randomEnemy));

			System.out.println("\n" + this.enemyStats.getName() + " enemy has appeared\n");
			this.view.printEnemyDescription(this.enemyStats);
			this.view.enterToContinue();
			scanner.nextLine();
			System.out.println();	
			//encounter will continue until if the user nor enemy is not defeat, else the user will go home
			while (this.enemyStats.getHealth() > 0 && this.userInfo.getHealth()>0) {
				this.view.printUserBattleInfo(this.userInfo);
				this.view.printEnemyStats(this.enemyStats);
				this.view.attackOrRun();
				System.out.println("Choice[1-4]:");
				int choice = scanner.nextInt();
				
				switch (choice) {
				case 1:
					int enemyAttack = random.nextInt(this.enemyStats.getAttack());
					int playerAttack = random.nextInt(this.userInfo.getAttack());
					this.userInfo.healthDecrease(enemyAttack);
					this.enemyStats.enemyHealtDecrease(playerAttack);
					System.out.println("\nYou ("+this.userInfo.getAvatarType()+"), attack the "+this.enemyStats.getName()+" a "+playerAttack+" damage points\n");
					System.out.println("The ("+this.enemyStats.getName()+"), attack you with "+enemyAttack+" damage points\n");
					scanner.nextLine();
					System.out.print("Enter to continue[]:");
					scanner.nextLine();
					
					break;
				case 2:
					this.userInfo.usingHealthPotion();
					break;
				case 3:
					 this.userInfo.usingDefensePotion();
					break;
				case 4:
					scanner.nextLine();
					continue DarkForest; // back do the dark forest
				case 5:
					return; // go back startGame(); method
				default:
				}
				
				
				
			}
			// game over
			if (this.userInfo.isUserDefeat()) {
				return;
			}
			// enemy drop chance 
			if(random.nextInt(100) >= this.enemyStats.getDropPotionChance()) {
				System.out.println(this.enemyStats.getName()+" drop a potion\n");
				this.userInfo.additionalPotionAdd();
			}
			// you defeat the enemy
			if(this.enemyStats.isEnemyDefeat()) {
				this.view.printEnemyStats(this.enemyStats);
				
				System.out.println(this.enemyStats.getName()+" is defeat\n");
				// additional gold after the enemy is defeated
				this.userInfo.goldAdd(this.enemyStats.getMoneyOffer());
				// additional exp after the enemy is defeated
				this.userInfo.expAdd(this.enemyStats.getExpOffer());
				// we update the stats 
				System.out.println("\nUpdate Character Stats:\n");
				this.view.printUserStats(this.userInfo);
				
				System.out.println("\nWhat to do now?\n"+
						           "1. Continue to Fight\n"+
						           "2. Go Home"+
						           "\nChoice[1-2]:");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					scanner.nextLine();
					continue DarkForest; // continue to Dark Forest
				case 2:
					scanner.nextLine();
					return; // back to Home
				default:
					System.out.println("Default choice");
				}
			}

		}
	}
	public void goToShop() {
		
		Shop:
		while (true) { 
			this.view.printShopInfo(this.userInfo);
			System.out.println("Choice[1-4]:");
			String choice = scanner.nextLine();
			if(choice.equals("1")) {
				this.userInfo.potionAdd(); // add health potions
			} 
			else if (choice.equals("2")) {
				this.userInfo.defensePotionAdd();  // add defense potions
			}
			else if(choice.equals("3")) {
				if(this.userInfo.isChangeCharacterAvailable()) {
					this.view.shopAvatarList(this.avatars);
					System.out.println("Choice [1-5]");
					int change = scanner.nextInt();
					if (change == 5) {
						scanner.nextLine();
						continue Shop;
					}
					if (change > 0 || change <= this.avatars.size()) {
						this.userInfo.setUserAvatar(this.avatars.get(change - 1)); // succesfully change character
						scanner.nextLine();
						this.view.printCharacterDesription(this.userInfo, this.scanner);
						this.view.printUserStats(this.userInfo);
					} else {
						System.out.println("Invalid Choice");
					}
				}else {
					System.out.println("Insufficient Gold");
				}
				
				
			}
			else if(choice.equals("4")){
				break;
			}
			else {
				System.out.println("Invalid Choice");
			}
		}	
	}public void inToTheDungeon() {
		InheritUserStats challenger = new InheritUserStats(this.userInfo);
		 while (challenger.getHealth()>0) {
			 challenger = new InheritUserStats(this.userInfo); 
			 this.view.printHellDungeonChoices();
			 int choice = scanner.nextInt();
			 scanner.nextLine();
			 
			 switch (choice) {
				case 1:
					this.enemyStats.setEnemyStats(this.hellEnemies.get(choice - 1));
					this.view.printEnemyDescription(this.enemyStats);
					this.view.enterToContinue();
					scanner.nextLine();
					dungeonsBattle(challenger, this.enemyStats);
					break;
				case 2:
					this.enemyStats.setEnemyStats(this.hellEnemies.get(choice - 1));
					this.view.printEnemyDescription(this.enemyStats);
					this.view.enterToContinue();
					scanner.nextLine();
					dungeonsBattle(challenger, this.enemyStats);
					break;
				case 3:
					this.enemyStats.setEnemyStats(this.hellEnemies.get(choice - 1));
					this.view.printEnemyDescription(this.enemyStats);
					this.view.enterToContinue();
					scanner.nextLine();
					dungeonsBattle(challenger, this.enemyStats);
					break;
				case 4:
					return;
				default:
					System.out.println("\nDefault choice\n");
				}
		 }
		 System.out.println("You are defeated by "+this.enemyStats.getName());
	}
	public void dungeonsBattle(InheritUserStats challenger, EnemyStats enemy) {
		while (challenger.getHealth()>0 && enemy.getHealth()>0) {
			this.view.printUserBattleInfo(challenger, this.userInfo.getUserName());;
			this.view.printEnemyStats(enemy);
			this.view.attackOrRunHell();
			System.out.println("Choice[1-4]:");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				int enemyAttack = random.nextInt(enemy.getAttack());
				int playerAttack = random.nextInt(challenger.getAttack());
				challenger.healthDecrease(enemyAttack);
				enemy.enemyHealtDecrease(playerAttack);
				System.out.println("\nYou ("+challenger.getAvatarType()+"), attack the "+enemy.getName()+" a "+playerAttack+" damage points\n");
				System.out.println("The ("+enemy.getName()+"), attack you with "+enemyAttack+" damage points\n");
				break;
			case 2:
				challenger.usingHealthPotion(this.userInfo);
				break;
			case 3:
				challenger.usingDefensePotion(this.userInfo);
				break;
			case 4:
				System.out.println("The enemy " + enemy.getName() + " block you escape.");
				break;
			default:
				System.out.println("\nDefault choice\n");
			}

		}
		if (challenger.isUserDefeat()) {
			return;
		}
		if (enemy.isEnemyDefeat()) {
			System.out.println(enemy.getName() + " is defeat\n");
			System.out.println();
			// additional gold after the enemy is defeated
			this.userInfo.goldAdd(enemy.getMoneyOffer());
			// additional exp after the enemy is defeated
			this.userInfo.expAdd(enemy.getExpOffer());
		}

	}

}