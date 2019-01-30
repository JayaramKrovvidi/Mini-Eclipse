package project.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import project.model.FileModel;


@Repository
public class HistoryDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;


	public List<FileModel> getHistory() {
		
		return jdbcTemplate.query("select * from test_summary",(rs,i)->{
			return new FileModel(
					rs.getInt("file_id"),
					rs.getString("file_name"),
					rs.getLong("records_total"),
					rs.getTimestamp("start_time"),
					rs.getTimestamp("end_time"),
					rs.getLong("records_passed"),
					rs.getLong("records_failed"),
					rs.getDouble("pass_percentage"),
					rs.getInt("execution_time")
					);
		});
	}
}
