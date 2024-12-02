package User_case.GameLevelsUserCase;

import Entity.GameLevelList;

public class LevelBattleLauncher {
    private GameLevelList gameLevel;

    public LevelBattleLauncher(GameLevelList gameLevelList) {
        gameLevel = gameLevelList;
    }

    public void launchBattle(Enemy enemy) {
        Battle battle = new Battle(this.gameLevel.getPlayer(), enemy);
        gameLevel.setBattle(battle);
    }
}
