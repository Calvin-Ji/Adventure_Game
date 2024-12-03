package LevelUserCase;

import Entity.*;
import User_case.GameLevelsUserCase.LevelAdder;
import User_case.GameLevelsUserCase.LevelBattleLauncher;
import User_case.GameLevelsUserCase.LevelCompleteManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelCompleteManagerTest {

    @Test
    void nextLevel() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Enemy enemy = new Fire("enemy", "this is enemy");
        Room room = new Room("room");
        Room room2 = new Room("room2");
        GameLevelList levels = new GameLevelList();
        Player player = new Player(10, 10, 5, room);
        LevelAdder adder = new LevelAdder(levels);
        adder.addPlayer(player);
        adder.addLevel(room);
        adder.addLevel(room2);
        LevelCompleteManager complete = new LevelCompleteManager(levels);
        complete.nextLevel(player);
        assertEquals(room2, levels.getPlayer().getCurrRoom());
    }
}