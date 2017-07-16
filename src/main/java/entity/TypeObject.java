package entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guillaumebelouin on 28/06/2017.
 */
public class TypeObject {
    public final static String TABLE_NAME = "type_object";
    public final static String ID = "id";
    public final static String NAME = "name";

    private int id;
    private String name;

    public static void initStructure() {
        Statement stmt;
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/sys");
            stmt = con.createStatement();

            String tableSql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                    + " ("+ID+" int PRIMARY KEY AUTO_INCREMENT, "+NAME+" varchar(30))";
            stmt.execute(tableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<TypeObject> getAll() {
        Statement stmt;
        List<TypeObject> typeObjectList = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/sys");
            stmt = con.createStatement();

            String selectSql = "SELECT * FROM " + TABLE_NAME;
            ResultSet resultSet = stmt.executeQuery(selectSql);

            while (resultSet.next()) {
                TypeObject typeObject = new TypeObject();
                typeObject.setId(resultSet.getInt(ID));
                typeObject.setName(resultSet.getString(NAME));

                typeObjectList.add(typeObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typeObjectList;
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
}
