package passwordManage.MyInterface;

import lombok.NonNull;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 将数据压缩
 */
public interface IZipFileUtil {
    /**
     * 将数据压缩入文件
     * @param data
     * @param zipFileName 压缩文件名
     * @param filename 压缩入文件时的名称
     * @return
     */
    boolean zipToFile(@NonNull byte[] data,@NonNull String zipFileName,@NonNull String filename);

    /**
     * 从文件中解压缩
     * @param zipFileName 压缩文件名
     * @param filename 从压缩文件中提取的文件名
     * @return
     */
    byte[] zipFromFile(@NonNull String zipFileName,@NonNull String filename) throws IOException;
}
