import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * RandomUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 1, 2019</pre>
 */
public class RandomUtilTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: newInstance()
     */
    @Test
    public void testNewInstance() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getProvice_City_TownName()
     */
    @Test
    public void testGetProvice_City_TownName() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getProvice_City_Town_All()
     */
    @Test
    public void testGetProvice_City_Town_All() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: GetProvice_CityName()
     */
    @Test
    public void testGetProvice_CityName() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: GetBookName()
     */
    @Test
    public void testGetBookName() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: GetBookType_Big()
     */
    @Test
    public void testGetBookType_Big() throws Exception {
        var lst = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            var t = RandomUtil.newInstance().GetBookType_Small();
            lst.add(t);
            Assert.assertNotNull(t);
        }
        Assert.assertTrue(lst.size() > 9);
        lst = (ArrayList<String>) lst.stream().distinct().collect(Collectors.toList());
        Assert.assertTrue(lst.size() > 8);
    }

    /**
     * Method: GetBookType_Small()
     */
    @Test
    public void testGetBookType_Small() throws Exception {
            testGetbooktype(RandomUtil.newInstance()::GetBookType_Big);
    }

    private void testGetbooktype(Supplier<String> function) {
        var lst = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String t = function.get();
            lst.add(t);
            Assert.assertNotNull(t);
        }
        Assert.assertTrue(lst.size() > 9);
        lst = (ArrayList<String>) lst.stream().distinct().collect(Collectors.toList());
        Assert.assertTrue(lst.size() > 8);
    }

} 
