package LevelUserCase;

import Entity.*;
import User_case.GameLevelsUserCase.LevelAdder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelAdderTest {

    @Test
    void addLevel() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Enemy enemy = new Fire("enemy", "this is enemy");
        Room room = new Room("room");
        GameLevelList levels = new GameLevelList();
        Player player = new Player(10, 10, 5, null);
        LevelAdder adder = new LevelAdder(levels);
        adder.addLevel(room);
        assertEquals(1, levels.getLevels().size());
    }

    @Test
    void addPlayer() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Enemy enemy = new Fire("enemy", "this is enemy");
        Room room = new Room("room");
        GameLevelList levels = new GameLevelList();
        Player player = new Player(10, 10, 5, room);
        LevelAdder adder = new LevelAdder(levels);
        assertEquals(player, levels.getPlayer());
        adder.addPlayer(player);
        assertEquals(room, levels.getPlayer().getCurrRoom());
    }
}