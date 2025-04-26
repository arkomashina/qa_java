import com.example.Alex;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexTests {

    @Mock
    Feline feline;

    private Alex alex;

    @Before
    public void createAnObjectAlex() throws Exception{
        alex = new Alex(feline);
    }


    @Test
    public void alexGetFriendsTest() throws Exception {
        List<String> actual = alex.getFriends();
        Assert.assertEquals("Кого-то из друзей не хватает", List.of("Марти", "Глория", "Мелман"), actual);
    }

    @Test
    public void alexGetKittensTest() throws Exception {
        int actual = alex.getKittens();
        Assert.assertEquals("У Алекса не должно быть детей", 0, actual);
    }

    @Test
    public void alexGetPlaceOfLiving() throws Exception{
        String actual = alex.getPlaceOfLiving();
        Assert.assertEquals("Алекс живёт не там", "Нью-Йоркский зоопарк", actual);

    }

}
