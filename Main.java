import DungenKeeper.DungenBuilder;
import DungenKeeper.Room;
import Item.Equipment;
import Item.Exit;
import Item.Key;
import Player.Player;

public class Main {

    // build your custom level here!
    public static void main(String[] args) {
        DungenBuilder dungen = new DungenBuilder();
        Key key = new Key("key", "this is a key", "a ket lies on the floor", 1, "regular");
        Exit gate = new Exit("gate", "", "there is a heavy gate infront of you");
        Equipment sword = new Equipment("sword", "this is a sword, it has the element of earth", "a sword is stuck on the wall", 3, "earth");
        Room room1 = new Room("this is the first room");
        room1.addItem(key);
        room1.addItem(gate);
        room1.addItem(sword);
        dungen.addLevel(room1);
        Key torch = new Key("torch", "this is a torch, it has the element of fire",
                "a torch hangs on the wall, it is still burning", 3, "fire");
        Exit spiderweb = new Exit("spiderweb", "",
                "the exit of the room is blocked by a lot of spiderweb, better get rid of it before passing");
        Room room2 = new Room("this is the second room");
        room2.addItem(torch);
        room2.addItem(spiderweb);
        dungen.addLevel(room2);
        dungen.addPlayer(10, 5, 1);
        room1.viewRoom();
        dungen.getPlayer().pickUp("key");
        dungen.getPlayer().walkTo("key");
        dungen.getPlayer().pickUp("kkkkkkkkkkkkkkkkkkkkk");
        dungen.getPlayer().pickUp("key");
        room1.viewRoom();
        dungen.getPlayer().walkTo("gate");
        dungen.getPlayer().pickUp("gate");
//        dungen.getplayer().putInBag(); //expect to put ey
//        dungen.getPlayer().pickUp("exit"); // expect to not able to pick up
//        dungen.getPlayer().inspectBag(); // expected to see key i.e name of item instead of item discription
//        dungen.getPlayer().getFromBag("key"); // expect to have key equipped and removed from bag
//        dungen.getPlayer().interact("key"); // expect to see key getting pocked into thin air
//        dungen.getPlayer().interact("exit"); // expect to see player trying to open exit but fails
//        dungen.getPlayer().walkTo("sword"); // expect to see player walk to sword
//        dungen.getPlayer().putInBag(); // expect to see player to key in bag
//        dungen.getPlayer().pickUp("sword"); // expect to see player pick up sword
//        dungen.getPlayer().walkTo("sword"); // expect to see cannot walk to sword
//        dungen.getPlayer().walkTo("gate");
//        dungen.getPlayer().interact("sword", "gate"); expect to see sword failed to pick the gate
//        dungen.getPlayer().putInBag(); expect to see player put sword in bag
//        dungen.getPlayer.inspectBag(); // expected to see sword and key in bag
//        dungen.getplayer().interact("ket", "exit"); // expect to see there isn't item key in players hand
//        dungen.getplayer().getFromBag("key"); //expect to have key equipped
//        dungen.getplayer().getFromBag("sword); //expect to not get sword due to already holding
//        dungen.getplayer().interact("exit"); //expect to see player leave from exit, have room set to room2

    }
}