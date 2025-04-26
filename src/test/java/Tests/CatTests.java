package Tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {
    @Mock
    Feline feline;

    @Test
    public void getSoundTestReturnText(){
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        Assert.assertEquals("Кот не сделал мяу как положено котам", "Мяу", actual);
    }

    @Test
    public void getFoodIsInvoked() throws Exception{
        Cat cat = new Cat(feline);
        Mockito.when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
    }
}
