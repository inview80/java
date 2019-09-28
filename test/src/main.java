import Model.CombinedSIRfromEISBoral;
import Tools.MyExcelUitl;
import Tools.ReflectUtil;
import org.apache.log4j.Logger;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

public class main {
    private static Logger log = Logger.getLogger(main.class);
    private static String filepath = "F:\\11月数据-测试用\\Combined SIR from EIS Boral.xlsx";
    private static String filepath2="F:\\11月数据-测试用\\DDMI Sql Extract.xlsx";

    public static void main(String[] args) {
//        Model p=new Model();
//        p.setString("jjjj");
//        System.out.println(p.getString());
//        var excel=new MyExcelUitl();
//        excel.ReadExcel(filepath);
        long start=System.currentTimeMillis();
        new MyExcelUitl().ReadExcel(filepath);
        log.info("共用时："+(System.currentTimeMillis()-start));
    }

    private void getFieldsToMap(){
        log.info("开始程序");
        var t = new ReflectUtil().getPosForFieldToMap(CombinedSIRfromEISBoral.class);
        log.info("获得getPosForFieldToMap");
//        t.forEach((i, field) -> log.info("第" + i + "项：内容为：" + field));
        var t2=new ReflectUtil().getStringForFieldToMap(CombinedSIRfromEISBoral.class);
        t2.forEach((str,field)->log.info("项："+str+"     "+field));
    }
    private void gg() {
        //构建一个缓存管理器，创建一个默认的缓存 "preConfigured"
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, CombinedSIRfromEISBoral.class,
                                ResourcePoolsBuilder.heap(100_0000))
                                .build())
                .build(true);
        Cache<Integer, CombinedSIRfromEISBoral> cache = cacheManager.getCache("preConfigured", Integer.class, CombinedSIRfromEISBoral.class);


//        URL myUrl = this.getClass().getResource("/Ehcache.xml");
//        CacheManager myCacheManager = CacheManagerBuilder.newCacheManager(new XmlConfiguration(myUrl));
//        Cache cache = myCacheManager.getCache("myCache", Integer.class, CombinedSIRfromEISBoral.class);
        CombinedSIRfromEISBoral cs;
        for (int i = 0; i < 100_0000; i++) {
            cs = new CombinedSIRfromEISBoral();
            cs.setClient("aaa:"+(i+1111));
            cs.setAadCong("bbb:  "+i);
            cache.put(i, cs);
        }
        System.out.println(cache.get(333));
        System.out.println(cache.get(99_9999));

        cache.clear();
        cacheManager.close();
    }

}
