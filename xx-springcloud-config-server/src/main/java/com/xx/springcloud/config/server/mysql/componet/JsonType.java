package com.xx.springcloud.config.server.mysql.componet;

import com.alibaba.fastjson.JSONObject;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2017/8/17
 */
public class JsonType implements UserType, Serializable {

    @Override
    public int[] sqlTypes() {
        return new int[] {Types.CLOB};
    }

    @Override
    public Class returnedClass() {
        return Map.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        return false;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return 0;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {
        if (strings == null) {
            return new HashMap<>();
        }
        String value = resultSet.getString(strings[0]);
        if (value != null) {
            return JSONObject.parseObject(value, Map.class);
        } else {
            return new HashMap<>();
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement statement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        if (o == null) {
            statement.setNull(i, Types.OTHER);
            return;
        }

        statement.setObject(i, o, Types.OTHER);
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return o;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return null;
    }

}
