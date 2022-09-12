package com.barnies.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.barnies.cnp.model.Coupon;
import com.barnies.cnp.util.ConnectionUtil;

public class CouponDAO {

	public void save(Coupon coupon) {

		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO coupon (code,discount,exp_date) Values(?,?,?)");

			stmt.setString(1, coupon.getCode());
			stmt.setBigDecimal(2, coupon.getDiscount());
			stmt.setString(3, coupon.getExpDate());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Coupon findByCode(String code) {

		Coupon coupon = new Coupon();
		Connection connection = ConnectionUtil.getConnection();
		try {

			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM coupon WHERE code=?");
			stmt.setString(1, code);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				coupon.setId(result.getInt(1));
				coupon.setCode(result.getString(2));
				coupon.setDiscount(result.getBigDecimal(3));
				coupon.setExpDate(result.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return coupon;
	}

}
