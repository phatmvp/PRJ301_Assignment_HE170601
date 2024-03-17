/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;


import entity.Attendence;
import entity.Lecturer;
import entity.Lession;
import entity.Room;
import entity.Student;
import entity.StudentGroup;
import entity.Subject;
import entity.TimeSlot;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
public class LessionDBContext extends DBContext<Lession> {

    public ArrayList<Attendence> getAttendencesBy(int leid) {
        ArrayList<Attendence> atts = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "les.leid,s.sid,s.sname,\n"
                    + "a.aid,a.description,a.isPresent,a.capturedtime\n"
                    + "\n"
                    + "FROM \n"
                    + "	Student s INNER JOIN Enrollment e ON s.[sid] = e.[sid]\n"
                    + "	INNER JOIN StudentGroup g ON g.gid = e.gid \n"
                    + "	INNER JOIN Lession les ON les.gid = g.gid\n"
                    + "	LEFT JOIN Attendence a ON a.leid = les.leid AND s.sid = a.sid\n"
                    + "WHERE les.leid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, leid);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Attendence a = new Attendence();
                Lession lession = new Lession();
                lession.setId(rs.getInt("leid"));
                a.setLession(lession);
                
                Student s = new Student();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                a.setStudent(s);
                a.setId(rs.getInt("aid"));
                if(a.getId() != 0)
                {
                    a.setDescription(rs.getString("description"));
                    a.setPresent(rs.getBoolean("isPresent"));
                    a.setTime(rs.getTimestamp("capturedtime"));
                }
                atts.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

    public ArrayList<Lession> getBy(int lid, Date from, Date to) {
        ArrayList<Lession> lessions = new ArrayList<>();
        try {
            String sql = "SELECT  \n"
                    + "	les.leid,les.isAttended,les.date,\n"
                    + "	g.gid,g.gname,su.subid,su.suname,\n"
                    + "	t.tid,t.tname,\n"
                    + "	r.rid,r.rname,\n"
                    + "	l.lid,l.lname\n"
                    + "FROM Lession les INNER JOIN StudentGroup g ON g.gid = les.gid\n"
                    + "				 INNER JOIN [Subject] su ON su.subid = g.subid\n"
                    + "				 INNER JOIN TimeSlot t ON t.tid = les.tid\n"
                    + "				 INNER JOIN Room r ON r.rid = les.rid\n"
                    + "				 INNER JOIN Lecturer l ON l.lid = les.lid\n"
                    + "WHERE les.lid=? AND les.[date] >=? AND les.[date]<=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, lid);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lession les = new Lession();
                StudentGroup g = new StudentGroup();
                Subject su = new Subject();
                TimeSlot slot = new TimeSlot();
                Room room = new Room();
                Lecturer lec = new Lecturer();

                les.setId(rs.getInt("leid"));
                les.setAttended(rs.getBoolean("isAttended"));
                les.setDate(rs.getDate("date"));

                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                su.setId(rs.getInt("subid"));
                su.setName(rs.getString("suname"));
                g.setSubject(su);

                les.setGroup(g);

                slot.setId(rs.getInt("tid"));
                slot.setName(rs.getString("tname"));
                les.setSlot(slot);

                room.setId(rs.getInt("rid"));
                room.setName(rs.getString("rname"));
                les.setRoom(room);

                lec.setId(rs.getInt("lid"));
                lec.setName(rs.getString("lname"));
                les.setLecturer(lec);

                lessions.add(les);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessions;
    }

    @Override
    public ArrayList<Lession> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Lession entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Lession entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lession entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lession get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}