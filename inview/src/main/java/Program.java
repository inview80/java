import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Program {
//    private static Logger log = Logger.getLogger(Program.class);
    public static void main(String[] args) {
//        String file="f:\\数据库生成数据.xlsx";
        String file="f:\\测试数据.csv";
        log.info("jfjdjk");
        log.info("3fds{}","ldjfiw");
        log.info("dkfeijfoe{}dfgfd",file);
        log.error("dsf{}"+ file);
        log.warn("afds{}jjj",file);
//        new CsvUtils().ReadCsv(file);
//        new Program().ReadExcel(file);
//        new ExcelPoiUtil().ReadExcel(file);

    }
    public void ReadExcel(String filePath){
//        File file=new File(filePath);
//        if(!file.exists())return;
//        Workbook workbook = null;
//        try{
//            InputStream inputStream=new FileInputStream(file);
//            workbook= Workbook.getWorkbook(inputStream);
//            for (int i=0;i<workbook.getNumberOfSheets();i++){
//                Sheet sheet=workbook.getSheet(i);
//                if(sheet!=null && sheet.getName().equals("省市县")){
//                    for(int row=0;row<sheet.getRows();row++){
//                        System.out.println(sheet.getCell(0,row).getContents());
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        }finally {
//            if(workbook!=null)workbook.close();
//        }
    }


}
