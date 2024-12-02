package RoomUserCase;

import Entity.*;
import User_case.RoomUserCase.RoomBattleAdder;
import User_case.RoomUserCase.RoomBattleRemover;
import User_case.RoomUserCase.RoomItemAdder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomItemAdderTest {

    @Test
    void addItem() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Room room = new Room("room");
        RoomItemAdder adder = new RoomItemAdder(room);
        adder.addItem(item);
        assertEquals(1, room.getItems().size());
    }

    @Test
    void addMultipleItem() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Item key = new Key("key", "this is key", "this is key on ground", 1, "regular");
        Room room = new Room("room");
        RoomItemAdder adder = new RoomItemAdder(room);
        adder.addItem(item);
        adder.addItem(key);
        assertEquals(2, room.getItems().size());
    }
}