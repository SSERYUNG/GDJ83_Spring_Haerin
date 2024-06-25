package com.sun.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.app.util.DBConnection;

@Repository
public class LocationDAO {
	@Autowired
	private DBConnection dbConnection;

	public List<LocationDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		System.out.println(con);

		String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID ASC";

		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();

		while (rs.next()) {
			LocationDTO locationDTO = new LocationDTO();

			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));

			ar.add(locationDTO);

		}
		// 연결한 자원을 해체
		rs.close();
		st.close();
		con.close();
		return ar;

	}
}
