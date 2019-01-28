package project.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class FileDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int storeInDb(Blob file,String name)
	{
		try 
		{
			KeyHolder holder = new GeneratedKeyHolder();
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement("insert into test_file(file_name,file_data) values(?,?)",
							Statement.RETURN_GENERATED_KEYS);
					ps.setString(1,name);
					ps.setBlob(2, file);
					return ps;
				}
			}, holder);

			return holder.getKey().intValue();
		} 
		catch (Exception e) 
		{
			System.out.println(e.toString());
			return -1;
		} 
	}
}