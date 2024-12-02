package RoomUserCase;

import Entity.*;


import User_case.RoomUserCase.RoomBattleAdder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomBattleAdderTest {

    @Test
    void addBattle() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Enemy enemy = new Fire("enemy", "this is enemy");
        Room room = new Room("room");
        RoomBattleAdder adder = new RoomBattleAdder(room);
        adder.addBattle(item, enemy);
        assertEquals(1, room.getBattleTriggers().size());
        assertEquals(1, room.getBattleEnemys().size());
    }




}