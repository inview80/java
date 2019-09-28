package passwordManage.model;

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
    private String dataFileName;

    public Dao(String dataFileName) {
        this.dataFileName = dataFileName + ".dat";
    }

    public byte[] serializableToBytes(Database entity) {
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

    public Database serializableToObject(byte[] datas) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(datas)) {
            try (ObjectInputStream inputStream = new ObjectInputStream(bis)) {
                return (Database) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                log.error(e.getLocalizedMessage());
            }
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        return new Database();
    }

    @Override
    public boolean secretToFile(Database datas, String userName, String pwd) {
        try {
            byte[] tmpDatabase = serializableToBytes(datas);
            byte[] tmpDes = Des3.getInstance().encrypt(tmpDatabase, pwd);
            byte[] tmpAes = AesUtils.newInstance(userName).encrypt(tmpDes, pwd.getBytes("UTF-8"));
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dataFileName))) {
                bos.write(tmpAes);
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return false;
        }
        return true;
    }

    @Override
    public Database secretFromFile(String userName, String pwd) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(dataFileName))) {
            byte[] tmpFile = bis.readAllBytes();
            byte[] tmpAes = AesUtils.newInstance(userName).decode(tmpFile, pwd.getBytes("UTF-8"));
            byte[] tmpDes = Des3.getInstance().decrypt(tmpAes, pwd);
            return serializableToObject(tmpDes);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
        return new Database();
    }
}
