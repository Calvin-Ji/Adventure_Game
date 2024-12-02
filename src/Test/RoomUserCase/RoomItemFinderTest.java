package RoomUserCase;

import Entity.Exit;
import Entity.Item;
import Entity.Key;
import Entity.Room;
import User_case.RoomUserCase.RoomItemAdder;
import User_case.RoomUserCase.RoomItemFinder;
import org.junit.jupiter.api.Test;

class RoomItemFinderTest {

    @Test
    void findItem() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Item key = new Key("key", "this is key", "this is key on ground", 1, "regular");
        Room room = new Room("room");
        RoomItemAdder adder = new RoomItemAdder(room);
        adder.addItem(item);
        adder.addItem(key);
        RoomItemFinder finder = new RoomItemFinder(room);
        assert (item, finder.findItem("exit"));
    }
}