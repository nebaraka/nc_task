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
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306?useUnicode=true&useJDBCCompliantTimezoneShift=" +
                "true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("password");
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
        if (connection == null) System.out.println("Connection is null");
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
