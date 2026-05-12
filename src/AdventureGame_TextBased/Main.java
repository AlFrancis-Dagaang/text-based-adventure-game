
package AdventureGame_TextBased;

public class Main {

	public static void main(String[] args) {
		AvatarList avatarList = new AvatarList();
		EnemyStats enemyStats = new EnemyStats();
		UserStats userStats = new UserStats();
		View viewer = new View();
		Controller userInterface = new Controller(avatarList.availableAvatar(),avatarList.availableEnemy(),avatarList.hellEnemies(), userStats, viewer, enemyStats);
		userInterface.setStart();
	}
}
