package com.nc.DAO;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO <E, K> {
    private Connection connection;

    public AbstractDAO() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/airport");
        HikariDataSource ds = new HikariDataSource(config);
        try {
            this.connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public abstract List<E> getAll();
    public abstract E getEntityById(K id);
    public abstract void delete(K id);
    public abstract void insert(E Entity);

    public PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    public void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
