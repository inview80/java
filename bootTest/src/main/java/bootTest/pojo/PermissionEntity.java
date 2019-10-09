package bootTest.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "permission", schema = "book", catalog = "")
public class PermissionEntity {
    private byte permissionId;
    private String permissionDetail;

    @Id
    @Column(name = "PermissionID")
    public byte getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(byte permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "PermissionDetail")
    public String getPermissionDetail() {
        return permissionDetail;
    }

    public void setPermissionDetail(String permissionDetail) {
        this.permissionDetail = permissionDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionEntity that = (PermissionEntity) o;
        return permissionId == that.permissionId &&
                Objects.equals(permissionDetail, that.permissionDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionId, permissionDetail);
    }
}
