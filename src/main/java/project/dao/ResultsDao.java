package project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import project.model.FileResultRow;
import project.values.Queries;

@Repository
public class ResultsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<FileResultRow> getByID(int id) {
		String query = Queries.SELECT_RESULTS_BY_ID + id;
		return jdbcTemplate.query(query, (rs, i) -> {
			return new FileResultRow(rs.getInt("file_id"), rs.getInt("line_num"), rs.getString("method_name"), rs.getString("start_time"),
					rs.getString("stop_time"), rs.getInt("expected_response_code"),
					rs.getString("expected_response_type"), rs.getInt("obtained_response_code"),
					rs.getString("obtained_response_type"), rs.getBoolean("result"));
		});
	}
	
	public void insertResult(FileResultRow row) {
		jdbcTemplate.update(Queries.INSERT_RESULT_ROW, row.getFileId(), row.getLineNo(), row.getMethodName(), row.getStartTime(),
				row.getEndTime(), row.getExpectedResponseCode(), row.getObtainedResponseCode(),
				row.getExpectedResponseType(), row.getObtainedResponseType(), row.getResult());

	}

}
