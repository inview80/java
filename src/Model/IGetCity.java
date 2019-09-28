package Model;

import java.util.List;

/**
 * 获取省、市、县的接口
 */
public interface IGetCity {
    /**
     * 合成省、市、县名称
     * @return String
     */
    String getProvice_City_TownName();
    /**
     * 获取所有省、市、县名称数据到列表
     * @return
     */
    List<String> getProvice_City_Town_All();

    /**
     * 合成省、市名称
     * @return
     */
    String GetProvice_CityName();
}
