package randomdata;

import org.junit.Test;

import static org.junit.Assert.*;

public class WriteDBTest {
    @Test
    public void publish() {
        var db = new WriteDB();
        db.publishingHouse();
    }

    @Test
    public void booktype() {
        new WriteDB().bookType();
    }

    @Test
    public void jj() {
        int Max = 199999;
        int n = 3;
        int min = Max / 10 + 1;
        for (int i = Max; i > min; i--) {
            char[] nums = String.valueOf(i).toCharArray();
            char[] t1 = String.valueOf(i * n).toCharArray();
            if (t1.length <= 6) break;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != t1[j]) break;
            }
            if (t1[6] == '8') System.out.println(i);
        }
    }
}
