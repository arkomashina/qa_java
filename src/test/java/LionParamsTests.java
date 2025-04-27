import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParamsTests {
    @Parameterized.Parameter(0)
    public String sex;
    @Parameterized.Parameter(1)
    public boolean hasManeExpected;

    @Parameterized.Parameters
    public static Object[][] data (){
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }



    @Mock
    Feline feline;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLionHasManeAccordingToSex() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(hasManeExpected, lion.doesHaveMane());
    }


}
