/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Lecturer;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LecturerDBContext extends DBContext<Lecturer> {

    public ArrayList<Lecturer> list() {
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        try {

            String sql = "SELECT [lid]\n"
                    + "      ,[lname]\n"
                    + "  FROM [dbo].[Lecturer]\n"
                    + "";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lecturer l = new Lecturer();
                l.setId(rs.getInt("lid"));
                l.setName(rs.getString("lname"));
                lecturers.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lecturers;
    }

    @Override
    public void insert(Lecturer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Lecturer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lecturer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lecturer get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
