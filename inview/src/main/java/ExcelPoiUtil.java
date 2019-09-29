public class ExcelPoiUtil {
//    public void writeExcel(String filepath, List<? extends baserowmo> dataLst){
//// 文件输出位置
//        OutputStream out = FileUtil.getOutputStream(filepath);
//
//        ExcelWriter writer =EasyExcelFactory.getWriter(out);
//
//        // 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
//        Sheet sheet1 = new Sheet(1, 0, WriteModel.class);
//
//        // 第一个 sheet 名称
//        sheet1.setSheetName("第一个sheet");
//
//        // 写数据到 Writer 上下文中
//        // 入参1: 创建要写入的模型数据
//        // 入参2: 要写入的目标 sheet
//        writer.write(createModelList(), sheet1);
//
//        // 将上下文中的最终 outputStream 写入到指定文件中
//        writer.finish();
//
//        // 关闭流
//        out.close();
//    }
}
