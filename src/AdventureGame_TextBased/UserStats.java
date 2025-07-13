package AdventureGame_TextBased;

public class UserStats {
	protected String userName;
	protected String avatarType;
	protected int attack;
	protected int health;
	protected int maxHealth;
	protected int maxDefense;
	protected int defense;
	protected int gold;
	protected int exp;
	protected int level;
	protected int potion;
	protected int defensePotion;
	protected int expPerLevell;
	protected int potionEffectPerLevel;
	
	// additional mechanics for leveling app
	private int goldPerLevel = 5;
	private int attackPerLevel = 2;
	private int maxHealthPerLevel = 2;
	private int maxDefensePerLevel = 2;
	

	public void setUserAvatar(Avatar avatar) {
		this.avatarType = avatar.getAvatarType();
		this.attack = avatar.getAttack();
		this.health = avatar.getHealth();
		this.maxHealth = avatar.getMaxhealth();
		this.maxDefense = avatar.getMaxDefense();
		this.defense = avatar.getDefense();
		this.gold = avatar.getGold();
		this.exp = avatar.getExp();
		this.level = avatar.getLevel();
		this.potion = avatar.getNumberOPotion();
		this.defensePotion = avatar.getDefensePotions();
		this.expPerLevell = avatar.getExperiencePerLevel();
		this.potionEffectPerLevel = avatar.getPotionEffectPerlevel();
		
	}
	public int getExpPerLevell() {
		return expPerLevell;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public int getMaxHealthPerLevel() {
		return maxHealthPerLevel;
	}
	public int getMaxDefensePerLevel() {
		return maxDefensePerLevel;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAvatarType() {
		return avatarType;
	}

	public int getAttack() {
		return attack;
	}

	public int getHealth() {
		return health;
	}

	public int getDefense() {
		return defense;
	}

	public int getGold() {
		return gold;
	}

	public int getExp() {
		return exp;
	}

	public int getLevel() {
		return level;
	}
	public int getNumberOfPotion() {
		return this.potion;
	}public int getDefensePotion() {
		return this.defensePotion;
	}
	public int getMaxDefense() {
		return this.maxDefense;
	}
	
	//game mechanics
	
	public int getPotionEffectPerLevel() {
		return potionEffectPerLevel;
	}
	//enemy attack mechanics
	public void healthDecrease(int enemyDamage) {
		int saveDefense = this.defense;
		if(this.defense > 0) {
			this.defense -= enemyDamage;
		}
		if(this.defense < 0) {
			int directDamage = this.defense;
			this.health-= Math.abs(directDamage);
			this.defense = 0;
		} else if(this.defense ==0) {
			this.health-= enemyDamage-saveDefense;
		}
		
	}
	// health potion mechanics
	public void usingHealthPotion() {
		if (this.health < this.maxHealth && this.potion > 0) {
			this.health += this.potionEffectPerLevel;
			this.potion--;
			System.out.println("\nYou restore +"+this.potionEffectPerLevel+" health");
			if (this.health > this.maxHealth) {
				this.health = this.maxHealth;
			}
			System.out.println("\nSuccesfully Drink health-potion.");
			System.out.println("Health: "+this.health);
			System.out.println("Health potions left: "+this.potion);
		} else if (this.health == this.maxHealth) {
			System.out.println("Max Health");
		} else {
			System.out.println("Insufficient Health Potions");
		}
	}
	// defense potion mechanics
	public void usingDefensePotion() {
		if (this.defense < maxDefense && this.defensePotion > 0) {
			this.defense += 10;
			this.defensePotion--;
			System.out.println("\nYou restore +"+this.defensePotion+" defense");
			if (this.defense > this.maxDefense) {
				this.defense = this.maxDefense;
			}
			System.out.println("\nSuccesfully Drinl defense-potion.");
			System.out.println("Defense: "+this.defense);
			System.out.println("Defense potions left: "+this.defensePotion);
		} else if (this.defense == this.maxDefense) {
			System.out.println("Max Defense");
		} else {
			System.out.println("Insufficient Defense Potion");
			this.defensePotion =0;
		}
	}
	
	// Experience and level up mechanis // !!!!!
	public void expAdd() {
		expAdd(10);
	}
	public void expAdd(int expPerEnemyDefeat) {
		int remainingExp = expPerEnemyDefeat;
		// exceeding exp threshold mechanics
		while (remainingExp > 0) {
			if (this.exp < this.expPerLevell) {
				int expToAdd = Math.min(remainingExp, this.expPerLevell - this.exp);
				this.exp += expToAdd;
				remainingExp -= expToAdd;
				System.out.println("\nYou gain " + expToAdd + " experience\n");
			}
			
			if (this.exp >= this.expPerLevell) { // level up mechanics
				this.level++; // level up
				System.out.println("\nYou're now Level " + this.level + "\n");

				this.expPerLevell += 10;

				this.attack += attackPerLevel; // attack chance increase
				System.out.println("Attack increase +" + attackPerLevel);
				attackPerLevel += 2; // max attack per level increse

				this.maxDefense += maxDefensePerLevel;// max Defense increase
				System.out.println("Max defense increase +" + maxDefensePerLevel);
				maxDefensePerLevel += 2; // max defense per level increase

				this.maxHealth += maxHealthPerLevel; // max health increase
				System.out.println("Max Health increase +" + maxHealthPerLevel);
				maxHealthPerLevel += 2;// max health per level increase

				this.gold += goldPerLevel; // additional gold
				System.out.println("Gold increase +" + goldPerLevel + "\n");
				goldPerLevel += 5; // max additional gold increase
				
				this.potionEffectPerLevel++;//potion effect inrease by 1 per level;

				this.exp = 0; // Reset Experience
			}
		}
	}
	// user defeats enemy mechanics
	public void goldAdd() {
		goldAdd(10);
	}
	public void goldAdd(int gold) {
		this.gold+=gold;
		System.out.println("You gain additional $"+gold);
	}
	public boolean isUserDefeat() {
		if (this.health<=0) {
			return true;
		} else {
			return false;
		}
	}
	public void additionalPotionAdd() {
		this.potion++;
	}
	
	//SHOP MECHANICS
	public void potionAdd() {
		if (this.gold >=10) {
			this.potion++;
			this.gold-=10;
			System.out.println("\nHealth potion left: " + this.potion);
		}else {
			System.out.println("Insufficient Gold"+"\n");	
		}
	}
	public void defensePotionAdd() {
		if (this.gold >=10) {
			this.defensePotion++;
			this.gold-=10;
			System.out.println("\nDefense potion left: " + this.defensePotion);
		}else {
			System.out.println("Insufficient Gold"+"\n");
		}
	}
	public boolean isChangeCharacterAvailable() {
		if (this.gold > 0 && this.gold >=50) {
			return true;
		} else {
			if(this.gold<0) {
				this.gold=0;
			}
			return false;
		}
	}
	
	//BOSS ENEMY MECHANICS
	
	public boolean isHellDungeonAvailable() {
		if (this.level >=5) {
			return true;
		} else {
			System.out.println("Level 5 required. ");
			return false;
		}
	}
	
	
	
	
	

	
	

}
