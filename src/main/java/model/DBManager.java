package model;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import domain.Question;
import model.User;

public class DBManager {
    private Connection con;

    public DBManager() {
        connect();
    }

    public void connect() {
        try {
            Class.forName(Driver.class.getName());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "333macarena!");
        } catch(Exception ex) {
            System.out.println("error when connecting:"+ex.getMessage());
            ex.printStackTrace();
        }
    }

    public String authenticate(String username, String password) {
        ResultSet rs;
        String result = "error";
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select * from users where user='"+username+"' and password='"+password+"'");
            if (rs.next()) {
                result = "success";
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Question> getQuestions(int noQuestions) {
        ArrayList<Question> questions = new ArrayList<>();
        ResultSet rs;
        try {
            PreparedStatement stmt = con.prepareStatement("select * from questions order by rand() limit ?");
            stmt.setInt(1,noQuestions);
            rs = stmt.executeQuery();
            while (rs.next()) {
                questions.add(new Question(
                        rs.getInt("id"),
                        rs.getString("body"),
                        rs.getString("answer"),
                        rs.getString("firstincorrectanswer"),
                        rs.getString("secondincorrectanswer")
                ));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public Question getQuestionById(int id) {
        Question question = new Question();
        ResultSet rs;
        try {
            PreparedStatement stmt = con.prepareStatement("select * from questions where id=?");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                question = new Question(
                        rs.getInt("id"),
                        rs.getString("body"),
                        rs.getString("answer"),
                        rs.getString("firstincorrectanswer"),
                        rs.getString("secondincorrectanswer"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public void setBestResult(String username, int newResult) {
        try {
            PreparedStatement stmt = con.prepareStatement("update users set bestresult=? where user=?");
            stmt.setInt(1,newResult);
            stmt.setString(2,username);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getBestResult(String username) {
        ResultSet rs;
        int result = 0;
        try {
            PreparedStatement stmt = con.prepareStatement("select bestresult from users where user=?");
            stmt.setString(1,username);
            rs = stmt.executeQuery();
            result = rs.getInt("bestresult");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}