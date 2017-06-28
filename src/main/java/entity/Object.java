package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by guillaumebelouin on 28/06/2017.
 */
public class Object {
    public final static String TABLE_NAME = "object";
    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String ID_TYPE = "id_type";

    private int id;
    private String name;
    private int idType;

    public static void initStructure() {
        Statement stmt = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/sys");
            stmt = con.createStatement();

            String tableSql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                    + " ("+ID+" int PRIMARY KEY AUTO_INCREMENT, "+NAME+" varchar(30), "
                    + ID_TYPE + " int)";
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

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }
}
