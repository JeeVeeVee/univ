package DynamischProgrameren.SomVanGetallen;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class SimpleTest {

    private static Som som;

    @BeforeClass
    public static void init() {
        som = new SomDynamisch();
    }

    @Test
    public void test1() {
        Assert.assertEquals("Verkeerd aantal mogelijkheden", 8, som.mogelijkheden(5, Arrays.asList(1, 2)));
    }

    @Test
    public void test2() {
        Assert.assertEquals("Verkeerd aantal mogelijkheden", 27, som.mogelijkheden(12, Arrays.asList(2, 3, 5)));
    }

    @Test
    public void test3() {
        Assert.assertEquals("Verkeerd aantal mogelijkheden", 0, som.mogelijkheden(100, Arrays.asList(6, 15, 24)));
    }

}