package RoomUserCase;

import Entity.*;
import User_case.RoomUserCase.RoomBattleAdder;
import User_case.RoomUserCase.RoomBattleChecker;
import User_case.RoomUserCase.RoomBattleRemover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomBattleRemoverTest {

    @Test
    void removeBattle() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Enemy enemy = new Fire("enemy", "this is enemy");
        Room room = new Room("room");
        RoomBattleAdder adder = new RoomBattleAdder(room);
        adder.addBattle(item, enemy);
        assertEquals(enemy, new RoomBattleRemover(room).removeBattle(item));
    }

    @Test
    void removeInmultipleBattles() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Item key = new Key("key", "this is key", "this is key on ground", 1, "regular");
        Enemy enemy = new Fire("enemy", "this is enemy");
        Enemy enemy2 = new Grass("enemy2", "this is enemy2");
        Room room = new Room("room");
        RoomBattleAdder adder = new RoomBattleAdder(room);
        adder.addBattle(item, enemy);
        adder.addBattle(key, enemy2);
        assertEquals(enemy, new RoomBattleRemover(room).removeBattle(item));
        assertEquals(enemy2, new RoomBattleRemover(room).removeBattle(key));
    }
}