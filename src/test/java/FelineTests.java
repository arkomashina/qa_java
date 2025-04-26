import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class FelineTests {
    @Spy
    Feline feline;


    @Test
    public void getFamilyTest(){
        feline = new Feline();
        String actual = feline.getFamily();
        Assert.assertEquals("Не принадлежит к семейству кошачих", "Кошачьи", actual);
    }

    @Test
    public void ifFelineEatMeatReturnsListOfAnimals() throws Exception {
        feline = new Feline();
        List<String> actual = feline.eatMeat();
        Assert.assertEquals("Этим хищники не питаются", List.of("Животные", "Птицы", "Рыба"), actual);
    }

    @Test
    public void eatMeatInvokesMethodGetFoodForPredator() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
    @Test
    public void getKittensTestWithoutParamsInvokesGetKittensWithDefault1(){
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }
    @Test
    public void getKittensWithParamsReturnKittensCount(){
        int actualKittens = feline.getKittens(10);
        Assert.assertEquals("Кол-во котов не совпадает", 10, actualKittens);
    }


}
