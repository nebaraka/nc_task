package com.nc.DAO;

import com.nc.model.Destination;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DestinationDAO extends AbstractDAO<Destination, Integer> {
    public static final String SELECT_ALL_DESTINATIONS = "SELECT * FROM airport.destinations";

    @Override
    public List<Destination> getAll() {
        List<Destination> lst = new ArrayList<>();
        PreparedStatement ps = getPreparedStatement(SELECT_ALL_DESTINATIONS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Destination destination = new Destination();
                destination.setId(rs.getInt(1));
                destination.setCity(rs.getString(2));
                destination.setCountry(rs.getString(3));
                destination.setDistance(rs.getInt(4));
                lst.add(destination);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }

        return lst;
    }

    @Override
    public Destination getEntityById(Integer id) {
        Destination destination = new Destination();
        PreparedStatement ps = getPreparedStatement("SELECT * FROM airport.destinations t where t.id = " + id);
        try {
            ResultSet rs = ps.executeQuery();
            destination.setId(rs.getInt(1));
            destination.setCity(rs.getString(2));
            destination.setCountry(rs.getString(3));
            destination.setDistance(rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }

        return destination;
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = getPreparedStatement("DELETE airport.destinations t WHERE t.id = " + id);
        try {
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }

    @Override
    public void insert(Destination destination) {
        PreparedStatement ps = getPreparedStatement("INSERT airport.destinations t VALUES (" +
                destination.getId() + ", \'" + destination.getCity() + "\', \'" + destination.getCountry() +
                "\', " + destination.getDistance() + ")");
        try {
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }
}
