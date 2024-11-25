package Enemy;


import java.util.Random;

public class AttackList {
    private Random random;

    public AttackList() {
        this.random = new Random();
    }

    // Normal attack: 1-3 damage
    public int normalAttack() {
        return random.nextInt(3) + 1; // Generates 1, 2, or 3
    }

    // Critical strike: 4-6 damage
    public int criticalStrike() {
        return random.nextInt(3) + 4; // Generates 4, 5, or 6
    }

    // Defense: absorbs 1-3 damage
    public int defense() {
        return random.nextInt(3) + 1; // Generates 1, 2, or 3
    }
}

