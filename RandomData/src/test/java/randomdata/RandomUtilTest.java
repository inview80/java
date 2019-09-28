package randomdata;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class RandomUtilTest {

    @Test
    public void getProvice_City_TownName() {
    }

    @Test
    public void getProvice_City_Town_All() {
    }

    @Test
    public void getProvice_CityName() {
    }

    @Test
    public void getBookName() {
        RandomUtil ru = Mockito.mock(RandomUtil.class);
        Mockito.when(ru.getBookName()).thenReturn("jjj");
        assertEquals("jjj1", ru.getBookName());

    }

    @Test
    public void getBookType_Big() {
    }

    @Test
    public void getBookType_Small() {

    }
}