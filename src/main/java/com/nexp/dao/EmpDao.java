package com.nexp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.nexp.beans.Emp;

public class EmpDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Emp p) {
		
		int count = 0 ;
		String Communicationlanguage = null;
		
		String[] items = p.getCommunication_language();
        for(int loopIndex = 0; loopIndex < items.length; loopIndex++){
        	count = loopIndex;
        	if(count==0){
        		Communicationlanguage = items[loopIndex];        		
        	}else{
        		Communicationlanguage = Communicationlanguage+","+items[loopIndex];        		
        	}
        	//a = items[loopIndex];
        	//b = a +","+items[loopIndex+1];
        	//System.out.println(items[loopIndex]);
        	//System.out.println(Communicationlanguage);
            
        }
        //System.out.println("Print count : "+count);
        //System.out.println("Print Communicationlanguage : "+Communicationlanguage);
		
		String sql = "insert into user_management(First_name,Middle_name,Last_name,Gender,Role, communication_language) values('" + p.getFirst_name()
				+ "','" + p.getMiddle_name() + "','" + p.getLast_name() + "','" + p.getGender() + "','" + p.getRole() + "','" + Communicationlanguage + "')";
		
		//System.out.println(template.update(sql));
		return template.update(sql);
		//return 0;
		
	}

	public Emp getEmpById(int id) {
		String sql = "select * from user_management where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	public int update(Emp p) {
		int count = 0 ;
		String Communicationlanguage = null;
		
		String[] items = p.getCommunication_language();
        for(int loopIndex = 0; loopIndex < items.length; loopIndex++){
        	count = loopIndex;
        	if(count==0){
        		Communicationlanguage = items[loopIndex];        		
        	}else{
        		Communicationlanguage = Communicationlanguage+","+items[loopIndex];        		
        	}
        	//a = items[loopIndex];
        	//b = a +","+items[loopIndex+1];
        	//System.out.println(items[loopIndex]);
        	//System.out.println(Communicationlanguage);
            
        }
        //System.out.println("Print count : "+count);
        //System.out.println("Print Communicationlanguage : "+Communicationlanguage);
		String sql = "update user_management set First_name='" + p.getFirst_name() + "', Middle_name='"
				+ p.getMiddle_name() + "',Last_name='" + p.getLast_name() + "',Gender='" + p.getGender() + "',Role='" + p.getRole() + "',communication_language='" + Communicationlanguage + "' where id="
				+ p.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from user_management where id=" + id + "";
		return template.update(sql);
	}

	public List<Emp> getEmployees() {
		return template.query("select * from user_management", new RowMapper<Emp>() {
			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setFirst_name(rs.getString(2));
				e.setMiddle_name(rs.getString(3));
				e.setLast_name(rs.getString(4));
				e.setGender(rs.getString(5));
				e.setRole(rs.getString(6));
				e.setCommunicationlanguage(rs.getString(7));
				return e;
			}
		});
	}
	
	public List<Emp> getEmployeesByPage(int pageid,int total){  
		String sql1 = "select COUNT(*) from user_management";
		
		//int a  = template.update(sql1);
		int count = template.queryForObject(sql1, Integer.class);
		System.out.println("Count ::- "+count);
		int count_div = count/total;
		System.out.println("Count Div ::- "+count_div);
		if(count%total==0){
			System.out.println("Count IF ::- "+count_div);
		}else{
			count_div = count_div+1;
			System.out.println("Count ELSE	 ::- "+count_div);
		}
		final int pagination = count_div;
		System.out.println("Count Final	 ::- "+pagination);
		
		
		
	    String sql="select * from user_management limit "+(pageid-1)+","+total;  
	    System.out.println("SQL Query ::- "+sql);
	    return template.query(sql,new RowMapper<Emp>(){  
	        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
	            Emp e=new Emp();  
	            e.setId(rs.getInt(1));  
	            e.setFirst_name(rs.getString(2));
				e.setMiddle_name(rs.getString(3));
				e.setLast_name(rs.getString(4));
				e.setGender(rs.getString(5));
				e.setRole(rs.getString(6));
				e.setCommunicationlanguage(rs.getString(7));
				e.setPagination(pagination);
	            return e;  
	        }  
	    });  
	} 
	
}
