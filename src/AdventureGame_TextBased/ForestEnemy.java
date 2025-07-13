package AdventureGame_TextBased;

public class ForestEnemy {
	private String name;
	private int health;
	private int attack;
	private int defense;
	private int dropPotionChance;
	private int moneyOffer;
	private int expOffer;
	
	public ForestEnemy(String name, int health, int attack,
			           int defense, int dropPotionChance, int moneyOffer, int expOffer ) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.dropPotionChance = dropPotionChance;
		this.moneyOffer =moneyOffer;
		this.expOffer = expOffer;
	}
	public ForestEnemy(String name, int health, int attack, int defense, int dropPotionChance) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.dropPotionChance = dropPotionChance;
		this.moneyOffer = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	

}
