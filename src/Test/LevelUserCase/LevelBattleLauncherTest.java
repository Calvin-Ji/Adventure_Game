package LevelUserCase;

import Entity.*;
import User_case.GameLevelsUserCase.LevelAdder;
import User_case.GameLevelsUserCase.LevelBattleLauncher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelBattleLauncherTest {

    @Test
    void launchBattle() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Enemy enemy = new Fire("enemy", "this is enemy");
        Room room = new Room("room");
        GameLevelList levels = new GameLevelList();
        Player player = new Player(10, 10, 5, room);
        LevelAdder adder = new LevelAdder(levels);
        adder.addPlayer(player);
        adder.addLevel(room);
        LevelBattleLauncher launcher = new LevelBattleLauncher(levels);
        launcher.launchBattle(enemy);
        assertEquals(player, levels.getfights().getPlayer());
        assertEquals(enemy, levels.getfights().getEnemy());
    }
}