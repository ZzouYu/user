package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBUtils;
import com.model.UserInfo;


public class UserInfoService extends DBUtils{

	Connection conn = null ;
	
	public UserInfoService() throws SQLException{
		conn = getCon() ;
	}
	
	
	public boolean add(UserInfo u){
		PreparedStatement ps = null;
		boolean flag = false ;
		try {
			String sql = "insert into userinfo(name,age,remark) values ('"
					+ u.getName()+"',"
					+ u.getAge()+",'"
					+ u.getRemark()
					+ "')" ;
			System.out.println(sql);
			 ps  = (PreparedStatement) conn.prepareStatement(sql);
			 ps.execute();
			 flag = true ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag ;
	}
	
	
	public List<UserInfo> list(UserInfo u){
		PreparedStatement ps = null;
		List<UserInfo> list = new ArrayList<UserInfo>();
		UserInfo userInfo = null;
		try {
			String name = u.getName();
			int id = u.getId();
			
			String sql = "select * from userinfo where 1=1 ";
			if(id != 0 ){
				sql = sql + " and id ="+id ;
			}
			if(name != null && !name.isEmpty()){
				sql = sql + " and name like '%"+name+"%'" ;
			}
			System.out.println(sql);
			ps  = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet  rs= ps.executeQuery();
			while (rs.next()) {
				userInfo = new UserInfo(rs.getString("name"), 
						String.valueOf(rs.getInt("age")), 
						rs.getString("remark"));
				userInfo.setId(rs.getInt("id"));
				list.add(userInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list ;
	}
	
	
	public void deleteuserInfo(int id) throws SQLException {
		String sql = "DELETE FROM userinfo WHERE id = ?" ;
		 PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql) ;
		 pst.setInt(1, id);
		 pst.executeUpdate();
	}
	
	
	public UserInfo findUserById(int id) throws SQLException{
		String sql = "select * from userinfo where id = ?" ;
		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql) ;
		pst.setInt(1, id);
		ResultSet rs =pst.executeQuery();
		UserInfo userInfo = null ;
		while (rs.next()) {
			userInfo = new UserInfo(rs.getString("name"), 
					String.valueOf(rs.getInt("age")), 					
					rs.getString("remark"));
			userInfo.setId(id);
		}
		return userInfo ;
	}
	
	
	public void updateUser(UserInfo u) throws SQLException{
		String sql = "update userinfo set name=?,age=?,remark=? where id = ?" ;
		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql) ;
		pst.setString(1, u.getName());
		pst.setInt(2, Integer.valueOf(u.getAge()));
		pst.setString(3, u.getRemark());
		pst.setInt(4, u.getId());
        int i =pst.executeUpdate();
        System.out.println(i);
        if(i != 0){ 
        	System.out.println("ִ�гɹ�");
        } 
	}
}
