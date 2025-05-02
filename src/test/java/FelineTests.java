import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.List;

public class FelineTests {
    @Spy
    Feline feline;
    @Before
    public void createAnObjectFeline(){
        feline = new Feline();
    }


    @Test
    public void getFamilyTest(){
        String actual = feline.getFamily();
        Assert.assertEquals("Не принадлежит к семейству кошачих", "Кошачьи", actual);
    }

    @Test
    public void ifFelineEatMeatReturnsListOfAnimals() throws Exception {
        List<String> actual = feline.eatMeat();
        Assert.assertEquals("Этим хищники не питаются", List.of("Животные", "Птицы", "Рыба"), actual);
    }
    @Test
    public void getKittensWithParamsReturnKittensCount(){
        int actual = feline.getKittens(10);
        Assert.assertEquals("Кол-во котов не совпадает", 10, actual);
    }

    @Test
    public void getKittensWithoutParamsReturnsDefaultQuantityOfKittens() {
        int actual = feline.getKittens();
        Assert.assertEquals("Должен возвращать одного котёнка по умолчанию", 1, actual);
    }

    @Test
    public void getKittensWithoutParamsReturnedSpyVersion() {
        feline = Mockito.spy(new Feline());
        Mockito.when(feline.getKittens(1)).thenReturn(5);
        int actual = feline.getKittens();
        Assert.assertEquals("Метод spy не изменил кол-во котиков", 5, actual);
    }


}
