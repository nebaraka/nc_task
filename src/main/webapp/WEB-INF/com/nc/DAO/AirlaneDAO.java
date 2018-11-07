package com.nc.DAO;

import com.nc.model.Airlane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirlaneDAO extends AbstractDAO <Airlane, Integer> {
    public static final String SELECT_ALL_AIRLANES = "SELECT * FROM airport.airlanes";

    public AirlaneDAO() {
        super();
    }


    @Override
    public List<Airlane> getAll() {
        List<Airlane> lst = new ArrayList<>();
        PreparedStatement ps = getPreparedStatement(SELECT_ALL_AIRLANES);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Airlane airlane = new Airlane();
                airlane.setId(rs.getInt(1));
                airlane.setName(rs.getString(2));
                airlane.setCountry(rs.getString(3));
                lst.add(airlane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }

        return lst;
    }

    @Override
    public Airlane getEntityById(Integer id) {
        Airlane airlane = new Airlane();
        PreparedStatement ps = getPreparedStatement("SELECT * FROM airport.airlanes t where t.id = " + id);
        try {
            ResultSet rs = ps.executeQuery();
            airlane.setId(rs.getInt(1));
            airlane.setName(rs.getString(2));
            airlane.setCountry(rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }

        return airlane;
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = getPreparedStatement("DELETE FROM airport.airlanes WHERE id = " + id);
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }

    @Override
    public void insert(Airlane airlane) {
        PreparedStatement ps = getPreparedStatement("INSERT airport.airlanes VALUES (" +
                airlane.getId() + ", \'" + airlane.getName() + "\', \'" + airlane.getCountry() + "\')");
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }
}
