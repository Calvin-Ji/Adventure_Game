package User_case.GameLevelsUserCase;

import Entity.GameLevelList;
import Entity.Battle;
import Entity.Enemy;

public class LevelBattleLauncher {
    private GameLevelList gameLevel;

    public LevelBattleLauncher(GameLevelList gameLevelList) {
        gameLevel = gameLevelList;
    }

    public void launchBattle(Enemy enemy) {
        Battle battle = new Battle(this.gameLevel.getPlayer(), enemy);
        gameLevel.setBattle(battle);
        Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
        guiUtility.displayOutput("The Battle has been launched.");
    }
}
