package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Locomative;
import com.company.repositories.interfaces.ILocomativeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocomativeRepository implements ILocomativeRepository {
    private final IDB db;
    public LocomativeRepository(IDB db){
        this.db=db;
    }
    @Override
    public boolean createLocomative(Locomative locomative){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO locomatives(name,trainId) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, locomative.getName());
            st.setInt(2, locomative.getTrainId());


            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public Locomative getLocomative(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,trainid FROM trains WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Locomative locomative = new Locomative(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("capacity"));

                return locomative;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;

    }
    @Override
    public List<Locomative> getAllLocomatives(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,trainid FROM trains";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Locomative> locomatives = new ArrayList<>();
            while (rs.next()) {
                Locomative locomative = new Locomative(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("trainid"));

                locomatives.add(locomative);
            }

            return locomatives;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
