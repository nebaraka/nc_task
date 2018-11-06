package com.nc.DAO;

import com.nc.model.Arrival;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArrivalDAO extends AbstractDAO<Arrival, Integer> {
    public static final String SELECT_ALL_ARRIVALS = "SELECT * FROM airport.arrivalss";

    @Override
    public List<Arrival> getAll() {
        List<Arrival> lst = new ArrayList<>();
        PreparedStatement ps = getPreparedStatement(SELECT_ALL_ARRIVALS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Arrival arrival = new Arrival();
                arrival.setId(rs.getInt(1));
                arrival.setNumber(rs.getDate(2).toString());
                arrival.setDestName(rs.getDate(3).toString());
                arrival.setArrTime(rs.getDate(4).toString());
                arrival.setDepTime(rs.getDate(5).toString());
                arrival.setGate(rs.getDate(6).toString());
                arrival.setAirlaneName(rs.getDate(7).toString());
                arrival.setPlaneMark(rs.getDate(8).toString());
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
            arrival.setNumber(rs.getDate(2).toString());
            arrival.setDestName(rs.getDate(3).toString());
            arrival.setArrTime(rs.getDate(4).toString());
            arrival.setDepTime(rs.getDate(5).toString());
            arrival.setGate(rs.getDate(6).toString());
            arrival.setAirlaneName(rs.getDate(7).toString());
            arrival.setPlaneMark(rs.getDate(8).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }

        return arrival;
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = getPreparedStatement("DELETE airport.arrivals t WHERE t.id = " + id);
        try {
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }

    @Override
    public void insert(Arrival departure) {
        PreparedStatement ps = getPreparedStatement("INSERT airport.arrivals t VALUES (" +
                departure.getId() + ", \'" + departure.getNumber() + "\', \'" + departure.getDestName() +
                "\', STR_TO_DATE(\'" + departure.getArrTime() + "\'), STR_TO_DATE(\'" +
                departure.getDepTime() + "\'), \'" + departure.getGate() +
                "\', \'" + departure.getAirlaneName() + "\', \'" + departure.getPlaneMark() + "\')");
        try {
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }
}
