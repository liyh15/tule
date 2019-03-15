package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;
import java.sql.PreparedStatement;
import java.sql.Connection;
import entity.City;
/**
 * ���ڳ��е���ز�ѯ
 * @author tarena
 *
 */
public class CityDao {
	/**
	 * ��ȡ���еĳ��м���
	 * 
	 * @return
	 */
	public List<City> getAllCity() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<City> cities = new ArrayList<City>();
		String sql = "select * from tule_city";
		try {
			connection = DBUtils.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				City city = new City();
				city.setId(id);
				city.setName(name);
				cities.add(city);
			}
			return cities;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, resultSet, statement);
		}
		return null;
	}
	/**
	 * ��ӳ���
	 * @param name
	 *            ��ӵĳ�������
	 */
	public void addCity(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql="insert into tule_city(name) values(?)";
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, resultSet, statement);
		}
	}
	/**
	 * ���ָ��id�ĳ�������
	 * @param id
	 */
     public String getCityNameById(int id)
     {
    	 Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select name from tule_city where id=?";
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				return resultSet.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, resultSet, statement);
		}
		return null;
     }
     /**
      * ����ָ�����ƻ�ó��е�id
      * @param cityName
      * @return
      */
     public int getCityIdByName(String cityName)
     {
    	Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select id from tule_city where name=?";		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, cityName);
			resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				return resultSet.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, resultSet, statement);
		}
		return 0;
     }
	public static void main(String[] args) {
		CityDao cityDao = new CityDao();
		System.out.println(cityDao.getCityIdByName("����"));
	}
}
