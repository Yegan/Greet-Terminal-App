package net.greet;

import java.sql.*;

public class GreetCounterUsingJdbc implements GreetCounter {
    final String insert_person_sql = "insert into countperson(name, counter) values(?, ?)";
    final String find_person_sql = "select * from countperson where name = ?";
    final String update_person_sql = "update countperson set counter = ? where name = ?";
    final String find_all_persons_sql = "select * from countperson";
    final String count_persons_sql = "select counter as user_count from countperson";
    final String delete_person_sql = "delete from countperson where name = ?";
    final String delete_all_person_sql = "delete from countperson";

    Connection conn;
    PreparedStatement createPersonCounter;
    PreparedStatement findPersonCounter;
    PreparedStatement updatePersonCounter;
    PreparedStatement findAllPersons;
    PreparedStatement countAllPersons;
    PreparedStatement deletePerson;
    PreparedStatement deleteAllPersons;

    public GreetCounterUsingJdbc() {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.
                    getConnection("jdbc:h2:./target/testDataBase", "yegan", "");
            createPersonCounter = conn.prepareStatement(insert_person_sql);
            findPersonCounter = conn.prepareStatement(find_person_sql);
            updatePersonCounter = conn.prepareStatement(update_person_sql);
            findAllPersons = conn.prepareStatement(find_all_persons_sql);
            countAllPersons = conn.prepareStatement(count_persons_sql);
            deletePerson = conn.prepareStatement(delete_person_sql);
            deleteAllPersons = conn.prepareStatement(delete_all_person_sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int findUserCounter(String name) {
        try {
            findPersonCounter.setString(1, name);
            ResultSet rs = findPersonCounter.executeQuery();
            if (rs.next()) {
                return rs.getInt("counter");
            }
        } catch (SQLException e) {
            System.out.println("Failed to find user: " + name);
        }
        return 0;
    }

    @Override
    public void countGreet(String name) {
        try {
            if (name == null) {
                return;
            }
            int userCount = findUserCounter(name);
            if (userCount == 0) {
                createPersonCounter.setString(1, name);
                createPersonCounter.setInt(2, 1);
                createPersonCounter.execute();
            } else {
                updatePersonCounter.setString(2, name);
                updatePersonCounter.setInt(1, userCount + 1);
                updatePersonCounter.execute();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int greetCount() {
        try {
            ResultSet rs = countAllPersons.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int greetCount(String name) {
        return findUserCounter(name);
    }

    @Override
    public String greeted() {
        String result = "";
        try {
            result = "> These people were greeted: \n";
            ResultSet rs = findAllPersons.executeQuery();
            while (rs.next()) {
                result += "\t" + rs.getString("name") + " : " + rs.getInt("counter") + "\n";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void clear() {
        try {
            deleteAllPersons.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearUser(String name) {
        try {
            deletePerson.setString(1, name);
            deletePerson.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
