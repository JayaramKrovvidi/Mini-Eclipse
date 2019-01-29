package project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import project.model.FileResultRow;

@Repository
public class ResultDisplayDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;


	public List<FileResultRow> getAllRecords() {
		
		return jdbcTemplate.query("select * from execution_results",(rs,i)->{
			return new FileResultRow(
					rs.getInt("file_id"),
					rs.getInt("line_num"),
					rs.getTimestamp("start_time"),
					rs.getTimestamp("stop_time"),
					rs.getInt("expected_response_code"),
					
					rs.getString("expected_response_type"),
					rs.getInt("obtained_response_code"),
					rs.getString("obtained_response_type"),
					rs.getBoolean("result")
					);
		});
	}
	
//	public List<FileResultRow> getAllRecords() {
//	return jdbcTemplate.query("select * from execution_results",new RowMapper<FileResultRow>(){  
//	    @Override  
//	    public FileResultRow mapRow(ResultSet rs, int rownumber) throws SQLException {  
//	    	return new FileResultRow(
//					rs.getInt("file_id"),
//					rs.getInt("line_num"),
//					rs.getTimestamp("start_time"),
//					rs.getInt("expected_response_code"),
//					rs.getInt("obtained_response_code"),
//					rs.getString("expected_response_type"),
//					rs.getString("obtained_response_type"),
//					rs.getBoolean("result")
//					);
//	    }  
//	    });  
//	}
	
	
//	public List<FileResultRow> getByID(int id){
//		return jdbcTemplate.query("select * from execution_results where file_id=\""+id+"\";",(rs,i)->{
//			return new FileResultRow(
//					rs.getInt("file_id"),
//					rs.getInt("line_num"),
//					rs.getTimestamp("start_time"),
//					rs.getInt("expected_response_code"),
//					rs.getInt("obtained_response_code"),
//					rs.getString("expected_response_type"),
//					rs.getString("obtained_response_type"),
//					rs.getBoolean("result")
//					);
//		});
//	}
	
	

}
