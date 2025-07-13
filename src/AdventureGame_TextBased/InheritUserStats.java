package AdventureGame_TextBased;

public class InheritUserStats extends UserStats {
	
	public  InheritUserStats (UserStats userStats) {
		this.avatarType = userStats.getAvatarType();
		this.attack = userStats.getAttack();
		this.health = userStats.getHealth();
		this.maxHealth = userStats.getMaxHealth();
		this.maxDefense = userStats.getMaxDefense();
		this.defense = userStats.getDefense();
		this.gold = userStats.getGold();
		this.exp = userStats.getExp();
		this.level = userStats.getLevel();
		this.potion = userStats.getNumberOfPotion();
		this.defensePotion = userStats.getDefensePotion();
		this.expPerLevell = userStats.getExpPerLevell();
		this.potionEffectPerLevel = userStats.getPotionEffectPerLevel();
	}
	public void usingHealthPotion(UserStats character) {
		if (this.health < this.maxHealth && this.potion > 0) {
			this.health += this.potionEffectPerLevel;
			character.potion--;
			System.out.println("\nYou restore +"+this.potionEffectPerLevel+" health");
			if (this.health > this.maxHealth) {
				this.health = this.maxHealth;
			}
			System.out.println("\nSuccesfully Drink health-potion.");
			System.out.println("Health: "+this.health);
			System.out.println("Health potions left: "+character.potion);
		} else if (this.health == this.maxHealth) {
			System.out.println("Max Health");
		} else {
			System.out.println("Insufficient Health Potions");
		}
		
	}
	public void usingDefensePotion(UserStats character) {
		if (this.defense < maxDefense && this.defensePotion > 0) {
			this.defense += 10;
			character.defensePotion--;
			System.out.println("\nYou restore +"+this.defensePotion+" defense");
			if (this.defense > this.maxDefense) {
				this.defense = this.maxDefense;
			}
			System.out.println("\nSuccesfully Drinl defense-potion.");
			System.out.println("Defense: "+this.defense);
			System.out.println("Defense potions left: "+character.defensePotion);
		} else if (this.defense == this.maxDefense) {
			System.out.println("Max Defense");
		} else {
			System.out.println("Insufficient Defense Potion");
		}
	}


}
