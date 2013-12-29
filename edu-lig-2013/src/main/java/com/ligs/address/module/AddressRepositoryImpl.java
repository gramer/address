package com.ligs.address.module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ligs.domain.Address;

public class AddressRepositoryImpl implements AddressRepository {

	@Override
	public Address findById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Address result = null;

		final String SQL = "SELECT * FROM ADDRESS WHERE ID = ?";

		try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new Address();
				result.setName(rs.getString("name"));
				result.setEmail(rs.getString("email"));
				result.setCellPhoneNumber(rs.getString("cellPhoneNumber"));
				result.setId(rs.getString("id"));
				result.setBirthday(rs.getDate("birthday"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return result;
	}

	@Override
	public List<Address> findByName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Address> result = new ArrayList<Address>();

		final String SQL = "SELECT * FROM ADDRESS WHERE NAME LIKE ?";		

		try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  "%" + name + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Address address = new Address();
				address.setId(rs.getString("id"));
				address.setName(rs.getString("name"));
				address.setEmail(rs.getString("email"));
				address.setCellPhoneNumber(rs.getString("cellPhoneNumber"));
				address.setBirthday(rs.getDate("birthday"));

				result.add(address);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return result;
	}

	@Override
	public List<Address> findAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Address> result = new ArrayList<Address>();

		final String SQL = "SELECT * FROM ADDRESS";

		try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Address address = new Address();
				address.setId(rs.getString("id"));
				address.setName(rs.getString("name"));
				address.setEmail(rs.getString("email"));
				address.setCellPhoneNumber(rs.getString("cellPhoneNumber"));
				address.setBirthday(rs.getDate("birthday"));

				result.add(address);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return result;
	}

	@Override
	public void removeAll() {
		final String SQL = "DELETE FROM ADDRESS";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void update(Address address) {
		final String SQL = "UPDATE ADDRESS SET name = ?, cellPhoneNumber = ?, email = ?, birthday = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, address.getName());
			pstmt.setString(2, address.getCellPhoneNumber());
			pstmt.setString(3, address.getEmail());
			pstmt.setDate(4, new java.sql.Date(address.getBirthday().getTime()));
			pstmt.setString(5, address.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

	@Override
	public void save(Address address) {
		final String SQL = "INSERT INTO ADDRESS(CellPhoneNumber, name, email, birthday) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, address.getCellPhoneNumber());
			pstmt.setString(2, address.getName());
			pstmt.setString(3, address.getEmail());
			pstmt.setDate(4, new java.sql.Date(address.getBirthday().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

	@Override
	public void removeById(String id) {
		final String SQL = "DELETE FROM ADDRESS WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
