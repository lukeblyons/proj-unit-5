import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BalancedBracketsTest {
    private String input;
    private boolean expected;

    public BalancedBracketsTest(String input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"({})", true},
                {"[<>()]", true},
                {"({[}]])", false},
                {"({})]", false}
        });
    }

    @Test
    public void testHasBalancedBrackets() {
        assertEquals(expected, BalancedBrackets.hasBalancedBrackets(input));
    }
}
