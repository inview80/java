package randomdata.model;

import java.util.List;

/**
 * 获取省、市、县的接口
 */
public interface IGetCity {
    /**
     * 合成省、市、县名称
     * @return String
     */
    String getProviceCityTownName();
    /**
     * 获取所有省、市、县名称数据到列表
     * @return
     */
    List<String> getProviceCityTownAll();

    /**
     * 合成省、市名称
     * @return
     */
    String getProviceCityName();
}
