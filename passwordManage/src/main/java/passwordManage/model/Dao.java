package passwordManage.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import passwordManage.MyInterface.ISerializableForFile;
import passwordManage.secret.AesUtils;
import passwordManage.secret.Des3;

import java.io.*;

/**
 * @author inview
 * @date 2019/9/20
 */
@Slf4j
public class Dao implements ISerializableForFile {
    final private String zipFileName;

    /**
     * @param zipFileName 压缩文件名，不要后缀名
     */
    public Dao(@NonNull String zipFileName) {
        this.zipFileName = zipFileName + ".dat";
    }

    public byte[] serializableToBytes(@NonNull Database entity) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(bos)) {
                outputStream.writeObject(entity);
                return bos.toByteArray();
            } catch (IOException e) {
                log.error(e.getLocalizedMessage());
            }
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        return new byte[0];
    }

    public Database serializableToObject(@NonNull byte[] datas) throws IOException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(datas)) {
            try (ObjectInputStream inputStream = new ObjectInputStream(bis)) {
                return (Database) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                log.error(e.getLocalizedMessage());
            }
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
            throw e;
        }
        return new Database();
    }

    @Override
    public boolean secretToFile(@NonNull Database datas, @NonNull String userName, @NonNull String pwd) {
        try {
            byte[] tmpDatabase = serializableToBytes(datas);
            byte[] tmpDes = Des3.getInstance().encrypt(tmpDatabase, pwd);
            byte[] tmpAes = AesUtils.newInstance(userName.toLowerCase()).encrypt(tmpDes, pwd.getBytes("UTF-8"));
            ZipFileUtil zfu = new ZipFileUtil();
            return zfu.zipToFile(tmpAes, zipFileName, userName.toLowerCase());
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public Database secretFromFile( @NonNull String userName, @NonNull String pwd) throws Exception {
        if (!new File(zipFileName).exists()) {
            throw new NullPointerException("配置文件丢失：" + zipFileName + ",文件找不到！");
        }
            ZipFileUtil zfu = new ZipFileUtil();
            byte[] data = zfu.zipFromFile(zipFileName, userName.toLowerCase());
            byte[] tmpAes = AesUtils.newInstance(userName.toLowerCase()).decode(data, pwd.getBytes("UTF-8"));
            byte[] tmpDes = Des3.getInstance().decrypt(tmpAes, pwd);
            return serializableToObject(tmpDes);
    }
}
