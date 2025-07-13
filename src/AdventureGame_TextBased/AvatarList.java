package AdventureGame_TextBased;

import java.util.ArrayList;

public class AvatarList {
	private ArrayList <Avatar> avatar;
	private ArrayList <ForestEnemy> enemy;
	private ArrayList <ForestEnemy> bossEnemy;
	

	public AvatarList() {
		this.avatar = new ArrayList<>();
		this.avatar.add(new Avatar("#Knight", 40, 15,40, 15, 15, 0, 0, 1, 5, 5, 20,5));
		this.avatar.add(new Avatar("#Wizard", 25, 28, 25, 10, 10, 0, 0, 1, 5, 5, 20,5));
		this.avatar.add(new Avatar("#MarksMan", 20, 35, 20, 15, 15, 0, 0, 1, 5, 5, 20,5));
		this.avatar.add(new Avatar("#Giant", 55, 15, 50, 5, 5, 0, 0, 1, 5, 5, 20,5));
		
		this.enemy = new ArrayList<>();
		this.enemy.add(new ForestEnemy("#Goblin", 20, 5, 10, 50, 20, 5));
		this.enemy.add(new ForestEnemy("#Ogre", 35, 15, 5, 50, 5, 15));
		this.enemy.add(new ForestEnemy("#Witch", 20, 30, 5, 50, 10, 20));
		this.enemy.add(new ForestEnemy("#Bandit", 15, 10, 15, 50, 10, 10));
		
		this.bossEnemy = new ArrayList<>();
		this.bossEnemy.add(new ForestEnemy("#GOLEM", 70, 50, 50, 50,50,50));
		this.bossEnemy.add(new ForestEnemy("#DRAGON", 100, 80, 50, 50,100,100));
		this.bossEnemy.add(new ForestEnemy("#DEMON", 200, 100, 100, 50,250,300));
	}
	public ArrayList <Avatar> availableAvatar(){
		return this.avatar;
	}
	public ArrayList<ForestEnemy> availableEnemy(){
		return this.enemy;
	}
	public ArrayList<ForestEnemy> hellEnemies(){
		return this.bossEnemy;
	}
	
	
	

}
