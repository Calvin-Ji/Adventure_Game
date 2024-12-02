package RoomUserCase;

import Entity.*;
import User_case.PlayerUsercase.PlayerInputBoundary;
import User_case.PlayerUsercase.PlayerOutBoundary;
import User_case.PlayerUsercase.outputBoundaryInterface;
import User_case.RoomUserCase.RoomBattleAdder;
import User_case.RoomUserCase.RoomBattleChecker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomBattleCheckerTest {

    @Test
    void checkBattle() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Enemy enemy = new Fire("enemy", "this is enemy");
        Room room = new Room("room");
        RoomBattleAdder adder = new RoomBattleAdder(room);
        adder.addBattle(item, enemy);
        assertEquals(true, new RoomBattleChecker(room).checkBattle(item));

    }
}