package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.util.*;

public class Converter_DAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/ltm?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public List<User> list_all() {
		List<User> user = new ArrayList<User>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("Select * from taikhoan ")) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				String username = rs.getString("username");
				User user1 = new User(email, password, username);
				user.add(user1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean check(String name, String password) throws SQLException {
		boolean check = true;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("Select * from taikhoan where email=? and password=?")) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			check = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	public void insert(String email, String password, String username) {
		// TODO Auto-generated method stub
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into taikhoan values(?,?,?)")) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, username);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			;
		}
	}

	public boolean checkemail(String email) {
		boolean check = true;
		// TODO Auto-generated method stub
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from taikhoan where email=?")) {
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			check = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
}
