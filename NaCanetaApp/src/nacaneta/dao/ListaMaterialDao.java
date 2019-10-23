package nacaneta.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.CallableStatement;

import nacaneta.model.ListaMaterial;
import nacaneta.rowmapper.ListaMaterialRowMapper;

public class ListaMaterialDao implements DaoGenerico<ListaMaterial> {
	
	private JdbcTemplate jdbcTemp;
	
	public ListaMaterialDao(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ListaMaterial> getAll() {
		List<ListaMaterial> list = jdbcTemp.query("CALL Mostrar_ListaMaterial_ALL()", new ListaMaterialRowMapper());
		
		return list;
	}

	@Override
	public void insert(String[] parameter) throws SQLException {
		
		if (parameter.length == 3) {
			
			int idEscola = Integer.parseInt(parameter[0]);
			String serie = parameter[1];
			int ano = Integer.parseInt(parameter[2]);
		
			String procedureQuery = "CALL Adicionar_ListaMaterial (?, ?, ?)";
			CallableStatement  statement = (CallableStatement ) jdbcTemp.getDataSource().getConnection().prepareCall(procedureQuery);
			
			statement.setInt(1, idEscola);
			statement.setString(2, serie);
			statement.setInt(3, ano);
		
			statement.execute();
		}
		
	}
	
public void getByEscola(String[] parameter) throws SQLException {
		
		if (parameter.length == 1) {
			
			int idEscola = Integer.parseInt(parameter[0]);
		
			String procedureQuery = "CALL Mostrar_Cotacao_BY_ID (?)";
			CallableStatement  statement = (CallableStatement ) jdbcTemp.getDataSource().getConnection().prepareCall(procedureQuery);
			
			statement.setInt(1, idEscola);
		
			statement.execute();
		}
		
	}
	
}
