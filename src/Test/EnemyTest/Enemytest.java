package EnemyTest;

import Entity.AttackList;
import Entity.Enemy;
import User_case.EnemyUseCase.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnemyActionInteractorTest {

    static class TestEnemy extends Enemy {
        public TestEnemy(String name, String description, String type) {
            super(name, description, type);
        }

        @Override
        public void useSpecialAbility() {
            this.damage = 10;
            this.usedSpecialAbility = true;
        }

        @Override
        protected boolean shouldUseSpecialAbility() {
            return !usedSpecialAbility;
        }
    }

    @Test
    void testPerformAction_UseSpecialAbility() {
        // Arrange
        Enemy enemy = new TestEnemy("Dragon", "A fierce dragon", "Fire");
        EnemyActionInteractor interactor = new EnemyActionInteractor(enemy, null);

        // Act
        int damage = interactor.performAction();

        // Assert
        assertEquals(10, damage);
        assertEquals(true, enemy.usedSpecialAbility);
    }

    @Test
    void testPerformAction_NormalAttack() {
        // Arrange
        AttackList attackList = new AttackList();
        Enemy enemy = new TestEnemy("Goblin", "A sneaky goblin", "Earth");
        enemy.setAttackList(attackList);
        EnemyActionInteractor interactor = new EnemyActionInteractor(enemy, null);

        int expectedDamage = attackList.normalAttack();

        // Act
        int damage = interactor.performAction();

        // Assert
        assertEquals(expectedDamage, damage);
    }

    @Test
    void testPerformAction_CriticalStrike() {
        // Arrange
        AttackList attackList = new AttackList();
        Enemy enemy = new TestEnemy("Orc", "A strong orc", "Earth");
        enemy.setAttackList(attackList);
        EnemyActionInteractor interactor = new EnemyActionInteractor(enemy, null);

        int expectedDamage = attackList.criticalStrike();

        int damage = interactor.performAction();

        // Assert
        assertEquals(expectedDamage, damage);
    }

    @Test
    void testPerformAction_Defense() {
        // Arrange
        AttackList attackList = new AttackList();
        Enemy enemy = new TestEnemy("Knight", "A valiant knight", "Steel");
        enemy.setAttackList(attackList);
        EnemyActionInteractor interactor = new EnemyActionInteractor(enemy, null);

        int absorbedDamage = attackList.defense();

        // Act
        int damage = interactor.performAction();

        // Assert
        assertEquals(0, damage);
        assertEquals(absorbedDamage, attackList.defense());
    }
}
