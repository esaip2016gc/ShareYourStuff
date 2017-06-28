package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by guillaumebelouin on 28/06/2017.
 */
public class User {
    public final static String TABLE_NAME = "user";
    public final static String ID = "id";
    public final static String FIRSTNAME = "firstname";
    public final static String LASTNAME = "lastname";
    public final static String SURNAME = "surname";
    public final static String AGE = "age";
    public final static String TEL = "tel";
    public final static String MAIL = "mail";
    public final static String PASSWORD = "password";

    private int id;
    private String firstName;
    private String lastName;
    private String surname;
    private int age;
    private String tel;
    private String mail;
    private String password;

    public static void initStructure() {
        Statement stmt = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/sys");
            stmt = con.createStatement();

            String tableSql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                    + " ("+ID+" int PRIMARY KEY AUTO_INCREMENT, "+FIRSTNAME+" varchar(30), "
                    +  LASTNAME+" varchar(30), "+ SURNAME+" varchar(30), "
                    +  MAIL+" varchar(30), "+ PASSWORD+" varchar(30), "
                    +  AGE+" int, "+ TEL+" varchar(12))";
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
