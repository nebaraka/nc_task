package com.nc.DAO;

import com.nc.model.Arrival;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArrivalDAO extends AbstractDAO<Arrival, Integer> {
    public static final String SELECT_ALL_ARRIVALS = "SELECT * FROM airport.arrivals";

    @Override
    public List<Arrival> getAll() {
        List<Arrival> lst = new ArrayList<>();
        PreparedStatement ps = getPreparedStatement(SELECT_ALL_ARRIVALS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Arrival arrival = new Arrival();
                arrival.setId(rs.getInt(1));
                arrival.setNumber(rs.getString(2));
                arrival.setDestName(rs.getString(3));
                arrival.setArrTime(rs.getTime(4).toString());
                arrival.setDepTime(rs.getTime(5).toString());
                arrival.setGate(rs.getString(6));
                arrival.setAirlaneName(rs.getString(7));
                arrival.setPlaneMark(rs.getString(8));
                lst.add(arrival);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }

        return lst;
    }

    @Override
    public Arrival getEntityById(Integer id) {
        Arrival arrival = new Arrival();
        PreparedStatement ps = getPreparedStatement("SELECT * FROM airport.departures t where t.id = " + id);
        try {
            ResultSet rs = ps.executeQuery();
            arrival.setId(rs.getInt(1));
            arrival.setNumber(rs.getString(2));
            arrival.setDestName(rs.getString(3));
            arrival.setArrTime(rs.getTime(4).toString());
            arrival.setDepTime(rs.getTime(5).toString());
            arrival.setGate(rs.getString(6));
            arrival.setAirlaneName(rs.getString(7));
            arrival.setPlaneMark(rs.getString(8));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }

        return arrival;
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = getPreparedStatement("DELETE FROM airport.arrivals WHERE id = " + id);
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }

    @Override
    public void insert(Arrival arrival) {
        PreparedStatement ps = getPreparedStatement("INSERT airport.arrivals VALUES (" +
                arrival.getId() +
                ", \'" + arrival.getNumber() + "\', \'" + arrival.getDestName() +
                "\', \'" + arrival.getArrTime() + "\', \'" +
                arrival.getDepTime() + "\', \'" + arrival.getGate() +
                "\', \'" + arrival.getAirlaneName() + "\', \'" + arrival.getPlaneMark() + "\')");
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }
}
