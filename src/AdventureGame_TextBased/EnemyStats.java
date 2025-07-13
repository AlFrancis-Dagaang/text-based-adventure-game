package AdventureGame_TextBased;

public class EnemyStats {
	private String name;
	private int health;
	private int attack;
	private int defense;
	private int dropPotionChance;
	private int moneyOffer;
	private int expOffer;
	
	public void setEnemyStats(ForestEnemy enemy) {
		this.name = enemy.getName();
		this.health = enemy.getHealth();
		this.attack = enemy.getAttack();
		this.defense = enemy.getDefense();
		this.dropPotionChance = enemy.getDropPotionChance();
		this.moneyOffer = enemy.getMoneyOffer();
		this.expOffer = enemy.getExpOffer();
		
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getDropPotionChance() {
		return dropPotionChance;
	}
	public int getMoneyOffer() {
		return this.moneyOffer;
	}
	public int getExpOffer() {
		return expOffer;
	}

	// enemy game mechanics
	public void enemyHealtDecrease(int enemyDamage) {
		int saveDefense = this.defense;
		if(this.defense > 0) {
			this.defense -= enemyDamage;
		}
		if(this.defense < 0) {
			int directDamage = this.defense;
			this.health-= Math.abs(directDamage);
			defense = 0;
		}else if(this.defense ==0) {
			this.health-= enemyDamage-saveDefense;
		}
	}
	public boolean isEnemyDefeat() {
		if (this.health <= 0) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
