package Enemy;

public class Fire extends Enemy {
    private boolean convertedToCritical = false; // Tracks if normal attacks are converted

    public Fire(String name, String description) {
        super(name, description, new AttackList(), "Fire"); // Set type to "Fire"
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " activated its special ability! All normal attacks are now critical strikes.");
        usedSpecialAbility = true;
        convertedToCritical = true;
    }

    @Override
    protected boolean shouldUseSpecialAbility() {
        return health < 5 && !usedSpecialAbility;
    }

    @Override
    public int performAction() {
        if (shouldUseSpecialAbility()) {
            useSpecialAbility();
            return this.damage;
        } else {
            String attackType = getRandomAttack();
            if (convertedToCritical && attackType.equals("normal")) {
                attackType = "critical"; // Convert normal to critical
            }
            switch (attackType) {
                case "normal":
                    this.damage = attackList.normalAttack();
                    System.out.println(name + " used a normal attack, dealing " + damage + " damage.");
                    return damage;
                case "critical":
                    this.damage = attackList.criticalStrike();
                    System.out.println(name + " used a critical strike, dealing " + damage + " damage.");
                    return damage;
                case "defense":
                    int absorbed = attackList.defense();
                    System.out.println(name + " used defense, absorbing " + absorbed + " damage.");
                    this.damage = 0;
                    return this.damage;
                default:
                    System.out.println(name + " used an unknown attack type.");
                    this.damage = 0;
                    return this.damage;
            }
        }
    }
}
