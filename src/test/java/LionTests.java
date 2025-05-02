import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {
    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);
        int actual = lion.getKittens();
        Assert.assertEquals("Метод не был вызван", 3, actual);
    }

    @Test
    public void getFoodTestIfPredator() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);
        List<String> actual = lion.getFood();
        Assert.assertEquals("Хищники едят не это", actual, List.of("Животные", "Птицы", "Рыба"));
    }

    @Test
    public void lionConstructorThrowsExceptionWhenSexIsInvalid() throws Exception{
        try {
            new Lion("Другое", feline);

        } catch (Exception e) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }


}
