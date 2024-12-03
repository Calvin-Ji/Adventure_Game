package User_case.RoomUserCase;

import Entity.Room;
import Entity.Enemy;
import Entity.Item;


public class RoomInteraction{
    private Room room;
    private RoomItemAdder roomItemAdder;
    private RoomItemFinder roomItemFinder;
    private RoomBattleAdder roomBattleAdder;
    private RoomBattleRemover roomBattleRemover;
    private RoomPickUp roomPickUp;
    private RoomBattleChecker roomBattleChecker;
    private RoomViewer roomViewer;

    public RoomInteraction(Room room) {
        this.room = room;
        roomItemAdder = new RoomItemAdder(room);
        roomItemFinder = new RoomItemFinder(room);
        roomBattleAdder = new RoomBattleAdder(room);
        roomBattleRemover = new RoomBattleRemover(room);
        roomBattleChecker = new RoomBattleChecker(room);
        roomBattleRemover = new RoomBattleRemover(room);
        roomViewer = new RoomViewer(room);
        roomPickUp = new RoomPickUp(room);
    }

    public void addItem(Item item){
        roomItemAdder.addItem(item);
    }

    public void addBattle(Item item, Enemy enemy){roomBattleAdder.addBattle(item, enemy);}

    public Item findItem(String itemName){return roomItemFinder.findItem(itemName);}

    public Item pickUp(String itemName){return roomPickUp.pickUp(itemName);}

    public Enemy removeBattle(Item item){return roomBattleRemover.removeBattle(item);}

    public boolean checkBattle(Item item){return roomBattleChecker.checkBattle(item);}
    
    public void viewRoom(){roomViewer.viewRoom();}
    
    public void enterRoom(){roomViewer.enterRoom();}
    
}
