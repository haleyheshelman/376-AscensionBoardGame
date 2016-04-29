package devops.hw1.core;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;


@RunWith(Suite.class)
@Suite.SuiteClasses({ParameterizedTestBuyCard.class, ParamTestMonsterError.class, Tests.class, GuiTests.class})
public class AllTests {
	public static void main (String args[]) {
        org.junit.runner.JUnitCore.main("devops.hw1.core.AllTests");
    }
}
