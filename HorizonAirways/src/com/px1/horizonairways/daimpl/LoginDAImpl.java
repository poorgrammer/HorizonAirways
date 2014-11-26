package com.px1.horizonairways.daimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.px1.db.DatabaseConnector;
import com.px1.horizonairways.da.LoginDA;
import com.px1.horizonairways.entity.Login;
import com.px1.horizonairways.entity.User;

public class LoginDAImpl implements LoginDA {

	private final String VERIFY_USER = "SELECT * FROM users WHERE username = ? AND password = ?";

	public LoginDAImpl() {

	}

	@Override
	public User verifyLogin(Login login) {

		PreparedStatement ps = null;
		User user = null;
		try {
			ps = DatabaseConnector.getConnection()
					.prepareStatement(VERIFY_USER);
			ps.setString(1, login.getUserName());
			ps.setString(2, login.getPassword());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String userName = rs.getString(1).trim();
				String password = rs.getString(2).trim();
				String role = rs.getString(3).trim();
				user = new User(userName, password, role.equals("admin"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}

		return user;

	}
}
