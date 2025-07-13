package AdventureGame_TextBased;

public class Avatar {
	private String avatarType;
	private int attack;
	private int maxhealth;
	private int health;
	private int maxDefense;
	private int defense;
	private int gold;
	private int exp;
	private int level;
	private int numberOfPotion;
	private int defensePotion;
	private int experiencePerLevel;
	private int potionEffectPerlevel;
	public Avatar(String avatarType, int health, int attack,int maxHealth, 
			      int maxDefense, int defense, int gold, int exp, int level,
			      int numberOfPotion, int defensePotion, int experiencePerLevel, int potionEffectPerlevel) {
		this.avatarType = avatarType;
		this.health = health;
		this.maxhealth = maxHealth;
		this.maxDefense = maxDefense;
		this.attack = attack;
		this.defense = defense;
		this.gold = gold;
		this.exp = exp;
		this.level = level;
		this.numberOfPotion =numberOfPotion;
		this.defensePotion = defensePotion;
		this.experiencePerLevel = experiencePerLevel;
		this.potionEffectPerlevel = potionEffectPerlevel;
	}
	public String getAvatarType() {
		return this.avatarType;
	}
	public int getHealth() {
		return this.health;
	}
	public int getAttack() {
		return this.attack;
	}
	public int getDefense() {
		return this.defense;
	}
	public int getGold() {
		return this.gold;
	}
	public int getExp() {
		return this.exp;
	}
	public int getLevel() {
		return this.level;
	}
	public int getNumberOPotion() {
		return this.numberOfPotion;
	}
	public int getMaxhealth() {
		return maxhealth;
	}
	public int getMaxDefense() {
		return maxDefense;
	} 
	public int getDefensePotions() {
		return this.defensePotion;
	}
	public int getExperiencePerLevel() {
		return experiencePerLevel;
	}
	public int getPotionEffectPerlevel() {
		return potionEffectPerlevel;
	}
	
	
	

}
