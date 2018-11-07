package com.nc.DAO;

import com.nc.model.Plane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAO extends AbstractDAO<Plane, Integer> {
    public static final String SELECT_ALL_PLANES = "SELECT * FROM airport.planes";

    @Override
    public List<Plane> getAll() {
        List<Plane> lst = new ArrayList<>();
        PreparedStatement ps = getPreparedStatement(SELECT_ALL_PLANES);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Plane plane = new Plane();
                plane.setId(rs.getInt(1));
                plane.setModelName(rs.getString(2));
                plane.setSeatsAmount(rs.getInt(3));
                plane.setMark(rs.getString(4));
                plane.setAirlane(rs.getString(5));
                plane.setRadius(rs.getInt(6));
                lst.add(plane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }

        return lst;
    }

    @Override
    public Plane getEntityById(Integer id) {
        Plane plane = new Plane();
        PreparedStatement ps = getPreparedStatement("SELECT * FROM airport.planes t where t.id = " + id);
        try {
            ResultSet rs = ps.executeQuery();
            plane.setId(rs.getInt(1));
            plane.setModelName(rs.getString(2));
            plane.setSeatsAmount(rs.getInt(3));
            plane.setMark(rs.getString(4));
            plane.setAirlane(rs.getString(5));
            plane.setRadius(rs.getInt(6));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }

        return plane;
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = getPreparedStatement("DELETE FROM airport.planes WHERE id = " + id);
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }

    @Override
    public void insert(Plane plane) {
        PreparedStatement ps = getPreparedStatement("INSERT airport.planes VALUES (" +
                plane.getId() + ", \'" + plane.getModelName() + "\', \'" + plane.getSeatsAmount() +
                "\', \'" + plane.getMark() + "\', \'" + plane.getAirlane() +
                "\', " + plane.getRadius() + ")");
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }
}
