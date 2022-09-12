package com.barnies.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.barnies.cnp.model.Product;
import com.barnies.cnp.util.ConnectionUtil;

public class ProductDAO {

	public void save(Product product) {

		Connection connection = ConnectionUtil.getConnection();

		try {
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO product (name,description,price) VALUES(?,?,?)");
			stmt.setString(1, product.getName());
			stmt.setString(2, product.getDescription());
			stmt.setBigDecimal(3, product.getPrice());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
