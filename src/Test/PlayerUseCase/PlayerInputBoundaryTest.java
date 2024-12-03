package PlayerUseCase;

import Entity.*;
import User_case.GameLevelsUserCase.LevelAdder;
import User_case.PlayerUsercase.PlayerInputBoundary;
import User_case.PlayerUsercase.PlayerOutBoundary;
import User_case.RoomUserCase.RoomItemAdder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerInputBoundaryTest {

    @Test
    void walkTo() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Enemy enemy = new Fire("enemy", "this is enemy");
        Room room = new Room("room");
        GameLevelList levels = new GameLevelList();
        RoomItemAdder adder = new RoomItemAdder(room);
        adder.addItem(item);
        Player player = new Player(10, 10, 5, room);
        LevelAdder levelAdder = new LevelAdder(levels);
        levelAdder.addLevel(room);
        levelAdder.addPlayer(player);
        PlayerInputBoundary playerActions = new PlayerInputBoundary(player, new PlayerOutBoundary());
        playerActions.walkTo("exit");
        assertEquals(item, levels.getPlayer().getLocation());
    }

    @Test
    void pickUp() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Item item1 = new Key("key", "this key", "ground key", 1, "regular");
        Enemy enemy = new Fire("enemy", "this is enemy");
        Room room = new Room("room");
        GameLevelList levels = new GameLevelList();
        RoomItemAdder adder = new RoomItemAdder(room);
        adder.addItem(item);
        adder.addItem(item1);
        Player player = new Player(10, 10, 5, room);
        LevelAdder levelAdder = new LevelAdder(levels);
        levelAdder.addLevel(room);
        levelAdder.addPlayer(player);
        PlayerInputBoundary playerActions = new PlayerInputBoundary(player, new PlayerOutBoundary());
        playerActions.walkTo("key");
        assertEquals(item1, levels.getPlayer().getLocation());
        playerActions.pickUp("key");
        assertEquals(null, levels.getPlayer().getLocation());
        assertEquals(item1, levels.getPlayer().getHolding());
    }

    @Test
    void testInteract() {
    }
}