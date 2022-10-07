package com.gcep.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<ProductModel> {
	/*
	 * TABLE FIELD    | CLASS FIELD
	 * ID             | id
	 * NAME           | name
	 * QUANTITY       | quantity
	 * IMAGE_NAME     | image_name
	 */

	@Override
	public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ProductModel(rs.getInt("ID"),
				rs.getString("NAME"),
				rs.getInt("QUANTITY"),
				rs.getString("IMAGE_NAME"));
	}

}
