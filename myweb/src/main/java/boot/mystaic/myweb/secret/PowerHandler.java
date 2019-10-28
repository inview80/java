package boot.mystaic.myweb.secret;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes({PowerEnum.class})
public class PowerHandler extends BaseTypeHandler<PowerEnum> {
    /**
     * 设置非空参数
     * @param preparedStatement
     * @param i
     * @param powerEnum
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, PowerEnum powerEnum, JdbcType jdbcType) throws SQLException {
        if(jdbcType==null) {
            preparedStatement.setInt(i, powerEnum.getId());
        }else {
            preparedStatement.setObject(i,powerEnum.getId(),jdbcType.TYPE_CODE);
        }
    }

    /**
     * 通过列名读取
     * @param resultSet
     * @param s
     * @return
     * @throws SQLException
     */
    @Override
    public PowerEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getPowerEnum(resultSet.getInt(s));
    }

    /**
     * 通过下标读取
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public PowerEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getPowerEnum(resultSet.getInt(i));
    }

    /**
     * 通过存储过程读取
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public PowerEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getPowerEnum(callableStatement.getInt(i));
    }

    /**
     * 通过Enum设置的数字读取
     * @param i
     * @return
     */
    private PowerEnum getPowerEnum(int i) {
        if (i > PowerEnum.values().length || i < 0) {
            return null;
        }
        return PowerEnum.getEnumById(i);
    }
}
