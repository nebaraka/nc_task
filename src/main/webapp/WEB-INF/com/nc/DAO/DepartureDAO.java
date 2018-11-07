package com.nc.DAO;

import com.nc.model.Departure;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartureDAO extends AbstractDAO<Departure, Integer> {
    public static final String SELECT_ALL_DEPARTURES = "SELECT * FROM airport.departures";

    @Override
    public List<Departure> getAll() {
        List<Departure> lst = new ArrayList<>();
        PreparedStatement ps = getPreparedStatement(SELECT_ALL_DEPARTURES);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Departure departure = new Departure();
                departure.setId(rs.getInt(1));
                departure.setNumber(rs.getString(2));
                departure.setDestName(rs.getString(3));
                departure.setDepTime(rs.getTime(4).toString());
                departure.setArrTime(rs.getTime(5).toString());
                departure.setGate(rs.getString(6));
                departure.setAirlaneName(rs.getString(7));
                departure.setPlaneMark(rs.getString(8));
                lst.add(departure);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }

        return lst;
    }

    @Override
    public Departure getEntityById(Integer id) {
        Departure departure = new Departure();
        PreparedStatement ps = getPreparedStatement("SELECT * FROM airport.departures t where t.id = " + id);
        try {
            ResultSet rs = ps.executeQuery();
            departure.setId(rs.getInt(1));
            departure.setNumber(rs.getDate(2).toString());
            departure.setDestName(rs.getDate(3).toString());
            departure.setDepTime(rs.getTime(4).toString());
            departure.setArrTime(rs.getTime(5).toString());
            departure.setGate(rs.getDate(6).toString());
            departure.setAirlaneName(rs.getDate(7).toString());
            departure.setPlaneMark(rs.getDate(8).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }

        return departure;
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = getPreparedStatement("DELETE FROM airport.departures WHERE id = " + id);
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }

    @Override
    public void insert(Departure departure) {
        PreparedStatement ps = getPreparedStatement("INSERT airport.departures VALUES (" +
                departure.getId() +
                ", \'" + departure.getNumber() + "\', \'" + departure.getDestName() +
                "\', \'" + departure.getDepTime() + "\', \'" +
                departure.getArrTime() + "\', \'" + departure.getGate() +
                "\', \'" + departure.getAirlaneName() + "\', \'" + departure.getPlaneMark() + "\')");
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }
}
