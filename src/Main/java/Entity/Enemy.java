package Entity;

import java.util.Random;

public abstract class Enemy {
    protected String name;
    protected String description;
    protected int health;
    protected AttackList attackList;
    protected Random random;
    protected final String type; // element

    protected int damage; // Damage dealt in the latest attack
    public boolean usedSpecialAbility = false;

    public Enemy(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.health = 15;
        this.attackList = new AttackList();
        this.random = new Random();
        this.type = type;
    }

    public abstract void useSpecialAbility();

    protected abstract boolean shouldUseSpecialAbility();

    protected String getRandomAttack() {
        int choice = random.nextInt(3); // 0: normal, 1: critical, 2: defense
        switch (choice) {
            case 0: return "normal";
            case 1: return "critical";
            case 2: return "defense";
            default: return "normal";
        }
    }

    // Getter method
    public String getName() { return name; }

    public int getHealth() { return health; }

    public void setHealth(int health) { this.health = health; }

    public String getType() { return type; }

    public String getRandomAttackPublic() {
        return getRandomAttack();
    }

    public boolean shouldUseSpecialAbilityPublic() {
        return shouldUseSpecialAbility();
    }

    public AttackList getAttackList() {
        return attackList;
    }

    public void setAttackList(AttackList attackList) {
        this.attackList = attackList;
    }


    public int getDamage() { return damage; }
}

