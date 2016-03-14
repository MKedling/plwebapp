package app.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.dto.User;

public class UserRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User customer = new User();
		customer.setID(rs.getInt("ID"));
		customer.setUsername(rs.getString("username"));
		customer.setPassword(rs.getString("password"));
		customer.setEmail(rs.getString("email"));
		return customer;
	}
	
}