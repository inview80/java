package randomdata.model;

public interface IGetBookAboat {
    /**
     * 合成图书名称
     * @return String
     */
    String getBookName();

    /**
     * 获取图书大分类的类型,数据较少
     * @return
     */
    String getBookTypeSimple();

    /**
     * 获取图书小分类的类型，分类详细
     * @return
     */
    String getBookTypeDetails();
}
