package com.iu.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.iu.util.DBConnector;

@Repository
public class MemberDAO {

	public int insert(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into member values(?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		st.setString(6, memberDTO.getFname());
		st.setString(7, memberDTO.getOname());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(con, st);
		
		return result;
	}
	
	public int update(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "update member set pw=?, phone=?, email=?, fname=?, oname=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getPw());
		st.setString(2, memberDTO.getPhone());
		st.setString(3, memberDTO.getEmail());
		st.setString(4, memberDTO.getFname());
		st.setString(5, memberDTO.getOname());
		st.setString(6, memberDTO.getId());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(con, st);
		
		return result;
	}
	
	public int delete(String id) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "delete member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(con, st);
		
		return result;
	}
	
	public ArrayList<MemberDTO> selectList() throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from member order by num desc";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		MemberDTO memberDTO = null;
		while(rs.next()){
			memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString("id"));
			memberDTO.setPw(rs.getString("pw"));
			memberDTO.setName(rs.getString("name"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setFname(rs.getString("fname"));
			memberDTO.setOname(rs.getString("oname"));
			ar.add(memberDTO);
		}
		
		DBConnector.disConnect(con, st, rs);
		
		return ar;
	}
	
	public MemberDTO selectOne(String id) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		
		MemberDTO memberDTO = null;
		while(rs.next()){
			memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString("id"));
			memberDTO.setPw(rs.getString("pw"));
			memberDTO.setName(rs.getString("name"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setFname(rs.getString("fname"));
			memberDTO.setOname(rs.getString("oname"));
		}
		
		DBConnector.disConnect(con, st, rs);
		
		return memberDTO;
	}
	
	public MemberDTO selectOne(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from member where id=? and pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		
		ResultSet rs = st.executeQuery();
		
		memberDTO = null;
		while(rs.next()){
			memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString("id"));
			memberDTO.setPw(rs.getString("pw"));
			memberDTO.setName(rs.getString("name"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setFname(rs.getString("fname"));
			memberDTO.setOname(rs.getString("oname"));
		}
		
		DBConnector.disConnect(con, st, rs);
		
		return memberDTO;
	}
	
	public int idCheck(String id) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select count(*) from member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		int result = rs.getInt(1);
		
		return result;
	}
}
