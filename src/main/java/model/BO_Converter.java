package model;

import model.Converter_DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BO_Converter {
	public boolean check(String name, String password) throws SQLException {
		Converter_DAO t = new Converter_DAO();
		return t.check(name, password);
	}

	public void insert(String email, String password, String username) {
		// TODO Auto-generated method stub
		Converter_DAO t = new Converter_DAO();
		t.insert(email, password, username);
	}

	public boolean checkemail(String email) {
		// TODO Auto-generated method stub
		Converter_DAO t = new Converter_DAO();
		return t.checkemail(email);
	}

	public List<User> list_all() {
		Converter_DAO t = new Converter_DAO();
		return t.list_all();
	}
}
