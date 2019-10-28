package randomdata;

import randomdata.base.DatabaseHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

public class WriteDB {
    private int COUNT_NUMBER=100_0000;

    public void publishingHouse(){
        var tmp = getList(RandomUtil.getInstance()::getPublisher);
        for (int i = 0; i < tmp.size(); i++) {
            String sql="insert into publish values("+(i+1)+",'"+tmp.get(i)+"')";
            DatabaseHelper.executeNonQuery(sql);
        }
    }

    public void bookType(){
        var tmp = getList(RandomUtil.getInstance()::getBookTypeSimple);
        for (int i = 0; i < tmp.size(); i++) {
            String sql="insert into booktype values("+(i+1)+",'"+tmp.get(i)+"')";
            DatabaseHelper.executeNonQuery(sql);
        }
    }

    private List<String> getList(Supplier<java.lang.String> action) {
        var tmp = new HashSet<java.lang.String>(COUNT_NUMBER);
        for (int i = 0; i < COUNT_NUMBER; i++) {
            tmp.add(action.get());
        }
        return new ArrayList<>(tmp);
    }
}
