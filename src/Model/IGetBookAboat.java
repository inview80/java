package Model;

public interface IGetBookAboat {
    /**
     * 合成图书名称
     * @return String
     */
    String GetBookName();

    /**
     * 获取图书大分类的类型,数据较少
     * @return
     */
    String GetBookType_Big();

    /**
     * 获取图书小分类的类型，分类详细
     * @return
     */
    String GetBookType_Small();
}
