package project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import project.model.FileModel;
import project.values.Queries;

@Repository
public class HistoryDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<FileModel> getHistory() {

		return jdbcTemplate.query(Queries.SELECT_ALL_TEST_SUMMARY, (rs, i) -> {
			return new FileModel(rs.getInt("file_id"), rs.getString("file_name"), rs.getLong("records_total"),
					rs.getString("start_time"), rs.getString("end_time"), rs.getLong("records_passed"),
					rs.getLong("records_failed"), rs.getDouble("pass_percentage"), rs.getInt("execution_time"));
		});
	}
	
	public void saveSummary(FileModel fm) {
		jdbcTemplate.update(Queries.INSERT_SUMMARY, fm.getFileId(), fm.getFileName(), fm.getStartTime(),
				fm.getStopTime(), fm.getExecutionTime(), fm.getRecordsCount(), fm.getRecordsPassed(),
				fm.getRecordsFailed(), fm.getPassPercentage());
	}
}
