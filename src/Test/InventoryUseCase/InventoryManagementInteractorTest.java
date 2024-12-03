package InventoryUseCase;

import Entity.Equipment;
import Entity.Inventory;
import Entity.Item;
import Entity.Key;
import User_case.InventoryUseCase.InventoryManagementInteractor;
import User_case.InventoryUseCase.InventoryOutputBoundary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryManagementInteractorTest {

    @Test
    void addItem() {
        Inventory bag = new Inventory(10);
        Item item = new Equipment("sword", "this is a sword", "sowrd on ground", 10, "fire");
        InventoryManagementInteractor interactor = new InventoryManagementInteractor(bag, new InventoryOutputBoundary());
        interactor.addItem(item);
        assertEquals(1, bag.getItemsInside().size());
        Item item2 = new Key("key", "this a key", "key floor", 0, "grass");
        interactor.addItem(item2);
        assertEquals(2, bag.getItemsInside().size());
    }

    @Test
    void removeItem() {
        Inventory bag = new Inventory(10);
        Item item = new Equipment("sword", "this is a sword", "sowrd on ground", 10, "fire");
        InventoryManagementInteractor interactor = new InventoryManagementInteractor(bag, new InventoryOutputBoundary());
        interactor.addItem(item);
        Item item2 = new Key("key", "this a key", "key floor", 0, "grass");
        interactor.addItem(item2);
        interactor.removeItem("sword");
        assertEquals(1, bag.getItemsInside().size());
        assertEquals( item2, interactor.removeItem("key"));

    }

}