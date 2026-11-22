package example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import example.beans.JdbcUtils;
import example.entity.Department;

public class DepartmentDao implements AppDao<Department, Integer>{
	
	@Override
	public Department getById(Integer deptNo) {
		Department foundDept = null;
		String sqlQuery =
				"select dname, loc, deptno from dept where deptno in (?)";
		try(
				Connection dbConnection = JdbcUtils.obtainConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
			pstmt.setInt(1, deptNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString(1);
				String location = rs.getString(2);
                int deptId = rs.getInt(3);
                foundDept = new Department(deptId, name, location);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

		return foundDept;
	}
}
