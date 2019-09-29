package passwordManage.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import passwordManage.MyInterface.IZipFileUtil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;


/**
 * @author inview
 * @date 2019/9/24
 */
@Slf4j
public class ZipFileUtil implements IZipFileUtil {

//    public boolean zipToFile(byte[] data, String zipFileName, String filename) {
//        try (ZipArchiveOutputStream zos =
//                     new ZipArchiveOutputStream(new BufferedOutputStream(new FileOutputStream("data.tmp")))) {
//            zos.setUseZip64(Zip64Mode.AsNeeded);
//            for (var entry : readZip(zipFileName).entrySet()) {
//                zos.putArchiveEntry(entry.getKey());
//                zos.write(entry.getValue());
//                zos.closeArchiveEntry();
//            }
//            ZipArchiveEntry entry = new ZipArchiveEntry(filename);
//            zos.putArchiveEntry(entry);
//            zos.write(data);
//            zos.closeArchiveEntry();
//        } catch (IOException e) {
//            log.error(e.getLocalizedMessage());
//            return false;
//        }
//        new File("data.tmp").renameTo(new File(zipFileName));
//        return true;
//    }

    private Map<String, byte[]> readZip(@NonNull String zipFileName, @NonNull String filename) {
        Map<String, byte[]> mapTmp = new HashMap<>();
        File file = new File(zipFileName);
        if (!file.exists()) {
            return mapTmp;
        }
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(zipFileName);
            var entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.getName().equals(filename) || entry.getSize() == -1) {
                    continue;
                }
                byte[] bytes = new byte[((int) entry.getSize())];
                if (zipFile.getInputStream(entry).read(bytes) == -1) {
                    continue;
                }
                mapTmp.put(entry.getName(), bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        log.info("删除临时文件：{}", file.delete());
        return mapTmp;
    }

    @Override
    public boolean zipToFile(@NonNull byte[] data, @NonNull String zipFileName, @NonNull String filename) {
        try (ZipOutputStream tmpStream =
                     new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("data.tmp")))) {
            for (var entry : readZip(zipFileName, filename).entrySet()) {
                tmpStream.putNextEntry(new ZipEntry(entry.getKey()));
                tmpStream.write(entry.getValue());
                tmpStream.closeEntry();
            }
            ZipEntry entry = new ZipEntry(filename);
            tmpStream.putNextEntry(entry);
            tmpStream.write(data);
            tmpStream.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new File("data.tmp").renameTo(new File(zipFileName));
        return true;
    }

    @Override
    public byte[] zipFromFile(String zipFileName, String filename) throws IOException {
        File file = new File(zipFileName);
        if (!file.exists()) {
            return new byte[0];
        }
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(zipFileName);
            var entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.getName().equals(filename) && entry.getSize() != -1) {
                    byte[] bytes = new byte[((int) entry.getSize())];
                    if (zipFile.getInputStream(entry).read(bytes) != -1) {
                        return bytes;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new byte[0];
    }
}
