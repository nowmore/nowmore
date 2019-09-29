package behavioral.strategy;

import behavioral.strategy.behavior.FlyRocketPowered;
import org.junit.Test;

public class strategyTest {

    @Test
    public void testStrategy() {

        Duck mallard = new MallardDuck();

        mallard.performFly();
        mallard.performQuack();

        mallard = new ModelDuck();
        mallard.performFly();
        mallard.setFlyBehavior(new FlyRocketPowered());
        mallard.performFly();
    }
}
