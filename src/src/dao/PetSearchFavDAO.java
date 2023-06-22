package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pet;

public class PetSearchFavDAO {
    public List<Pet> select() {
        Connection conn = null;
        List<Pet> petList = new ArrayList<Pet>();

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

            String sql = "SELECT * FROM POSTS INNER JOIN FAVORITES ON POSTS.ID = FAVORITES.POSTS_ID ORDER BY FAVORITES.FAVORITE DESC";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                Pet pet = new Pet(
                        rs.getString("PICTURE_BOOKS_ID"),
                        rs.getString("TITLE"),
                        rs.getString("GENRE"),
                        rs.getString("FREE"),
                        rs.getString("PICTURE"),
                        rs.getInt("FAVORITE")
                );
                petList.add(pet);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            petList = null;
        } catch (SQLException e) {
            e.printStackTrace();
            petList = null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    petList = null;
                }
            }
        }
        return petList;
    }
}