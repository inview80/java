import Model.MyExcelUitl;

public class main {
    public static void main(String[] args) {
//        Model p=new Model();
//        p.setString("jjjj");
//        System.out.println(p.getString());
        String filepath="F:\\11月数据-测试用\\Combined SIR from EIS Boral.xlsx";
        var excel=new MyExcelUitl();
        excel.ReadExcel(filepath);
    }

}
