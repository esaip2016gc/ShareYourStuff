package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by guillaumebelouin on 28/06/2017.
 */
public class Ad {
    public final static String TABLE_NAME = "ad";
    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String ID_OBJECT = "id_object";
    public final static String ID_USER = "id_user";
    public final static String COMMENT = "comment";
    public final static String PRICE = "price";

    private int id;
    private String name;
    private int idObject;
    private int idUser;
    private String comment;
    private float price;

    public static void initStructure() {
        Statement stmt = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/sys");
            stmt = con.createStatement();

            String tableSql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                    + " ("+ID+" int PRIMARY KEY AUTO_INCREMENT, "+NAME+" varchar(30), "
                    +  ID_OBJECT+" int, "+ ID_USER+" int, "
                    +  COMMENT+" text, "+ PRICE+" real)";
            stmt.execute(tableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdObject() {
        return idObject;
    }

    public void setIdObject(int idObject) {
        this.idObject = idObject;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
