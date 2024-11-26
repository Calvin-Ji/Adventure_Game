package Enemy;

public class Grass extends Enemy {

    public Grass(String name, String description) {
        super(name, description, new AttackList(), "Grass"); // Set type to "Grass"
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " used its special ability, healing 3 health points.");
        health += 3;
        usedSpecialAbility = true; // Mark that special ability has been used
    }

    @Override
    protected boolean shouldUseSpecialAbility() {
        return health < 5 && !usedSpecialAbility;
    }

    // No need to override performAction() as special ability doesn't affect attack logic

}
}
