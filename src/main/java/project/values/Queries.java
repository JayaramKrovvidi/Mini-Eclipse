package project.values;

public class Queries {
	
	private Queries() {}
	
	public static final String INSERT_FILE = "insert into test_suite(file_name,file_timestamp,file_data) values(?,?,?)";
	public static final String INSERT_SUMMARY = "insert into test_summary(file_id, file_name, start_time, end_time, execution_time, records_total, records_passed, records_failed, pass_percentage) values(?,?,?,?,?,?,?,?,?)";
	public static final String SELECT_FILE = "select file_data from test_suite where file_id=";
	public static final String SELECT_FILENAME = "select file_name from test_suite where file_id=";
	public static final String INSERT_RESULT_ROW = "insert into execution_results(file_id,line_num,method_name,start_time,stop_time,expected_response_code,obtained_response_code,expected_response_type,obtained_response_type,result) values(?,?,?,?,?,?,?,?,?,?)";
	public static final String SELECT_ALL_TEST_SUMMARY = "select * from test_summary";
	public static final String SELECT_RESULTS_BY_ID = "select * from execution_results where file_id=";
	public static final String SELECT_ALL_RESULTS = "select * from execution_results";
}
