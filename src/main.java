import Model.*;

public class main {
    public static void main(String[] args) {
        for (int i=0;i<100;i++){
//            var t=RandomUtil.newInstance().GetProvice_CityName();
            var t=RandomUtil.newInstance().GetBookName();
//            var t=RandomUtil.newInstance().GetBookType_Big();
//            var t=RandomUtil.newInstance().GetBookType_Small();
            System.out.println(t);
        }
    }
}
