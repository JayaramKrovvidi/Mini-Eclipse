package project.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import project.values.Queries;

@Repository
public class FileDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int storeInDb(final Blob file, final String name) {
		try {
			KeyHolder holder = new GeneratedKeyHolder();

			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(Queries.INSERT_FILE,
							Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, name);
					ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
					ps.setBlob(3, file);
					return ps;
				}
			}, holder);

			return holder.getKey().intValue();
		} catch (Exception e) {
			return -1;
		}
	}


	public Blob getFile(int id) {
		String query = Queries.SELECT_FILE + id;
		return jdbcTemplate.queryForObject(query, Blob.class);
	}

	public String getFileName(int id) {
		String query = Queries.SELECT_FILENAME + id;
		return jdbcTemplate.queryForObject(query, String.class);
	}
}
