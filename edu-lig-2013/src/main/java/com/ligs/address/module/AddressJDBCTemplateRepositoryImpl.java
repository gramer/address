package com.ligs.address.module;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.ligs.domain.Address;

public class AddressJDBCTemplateRepositoryImpl implements AddressRepository {

	private JdbcTemplate template;

//	private RowMapper<Address> addressRowMapper = new RowMapper<Address>() {
//
//		@Override
//		public Address mapRow(ResultSet rs, int i) throws SQLException {
//			Address address = new Address();
//			address.setId(rs.getString("id"));
//			address.setName(rs.getString("name"));
//			address.setCellPhoneNumber(rs.getString("cellPhoneNumber"));
//			address.setEmail(rs.getString("email"));
//			address.setBirthday(rs.getDate("birthday"));
//
//			return address;
//		}
//
//	};
	
	private RowMapper<Address> addressRowMapper = new CommonRowMapper<Address>(Address.class);

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Address findById(String id) {
		return template.queryForObject("SELECT * FROM ADDRESS WHERE ID = ?", addressRowMapper, id);
	}

	@Override
	public List<Address> findByName(String name) {
		return template.query("SELECT * FROM ADDRESS WHERE NAME LIKE ?", addressRowMapper, "%" + name + "%");
	}

	@Override
	public List<Address> findAll() {
		return template.query("SELECT * FROM ADDRESS", addressRowMapper);
	}

	@Override
	public void removeAll() {
		template.execute("DELETE ADDRESS");
	}

	@Override
	public void update(final Address address) {
		final String SQL = "UPDATE ADDRESS SET name = ?, cellPhoneNumber = ?, email = ?, birthday = ? WHERE id = ?";
		template.update(SQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, address.getName());
				pstmt.setString(2, address.getCellPhoneNumber());
				pstmt.setString(3, address.getEmail());
				pstmt.setDate(4, new java.sql.Date(address.getBirthday().getTime()));
				pstmt.setString(5, address.getId());
			}

		});

	}

	@Override
	public void save(final Address address) {
		final String SQL = "INSERT INTO ADDRESS(ID, CellPhoneNumber, name, email, birthday) VALUES (ADDRESS_SEQ.NEXTVAL, ?, ?, ?, ?)";
		template.update(SQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, address.getCellPhoneNumber());
				pstmt.setString(2, address.getName());
				pstmt.setString(3, address.getEmail());
				pstmt.setDate(4, new java.sql.Date(address.getBirthday().getTime()));
			}
		});
	}

	@Override
	public void removeById(String id) {
		template.update("DELETE FROM ADDRESS WHERE ID = ?", id);
	}

}
