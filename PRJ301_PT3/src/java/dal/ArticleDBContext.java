/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Article;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class ArticleDBContext extends DBContext<Article> {

    public ArrayList<Article> list() {
        ArrayList<Article> as = new ArrayList<>();

        try {
            String sql = "SELECT [aid]\n"
                    + "      ,[title]\n"
                    + "      ,[published_date]\n"
                    + "      ,[online]\n"
                    + "      ,[username]\n"
                    + "      ,[catid]\n"
                    + "  FROM [dbo].[Article]";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();;

            while (rs.next()) {
                Article a = new Article();
                a.setAid(rs.getInt("aid"));
                a.setTitle(rs.getString("title"));
                a.setOnline(rs.getBoolean("online"));
                a.setPublished_date(rs.getDate("published_date"));
                as.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return as;
    }

}
