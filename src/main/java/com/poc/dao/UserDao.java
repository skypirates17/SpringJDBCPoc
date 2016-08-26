package com.poc.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.poc.dto.DataTransferObject;
import com.poc.model.User;

@Repository
public class UserDao extends BaseDao{
	private static final String INSERT_USER = "INSERT INTO student_info (student_name,student_age,student_address) " +
			"VALUES (?, ? ,?)";
	private static final String UPDATE_USER = "UPDATE student_info SET student_name = ?,student_age = ?,student_address = ? WHERE student_id = ?";
	private static final String DELETE_USER = "delete from student_info WHERE student_id = ?";
	private static final String SELECT_USER = "select student_name as name, student_age as age,student_address as address from student_info where "+
			"student_id = ?";
	@Override
	public DataTransferObject find(DataTransferObject dto) {
		// TODO Auto-generated method stub
		DataTransferObject returndto = new DataTransferObject();
		User user =  (User) getJdbcTemplate().queryForObject(
				SELECT_USER,
                new Object[] { dto.getUser().getId() },
                new BeanPropertyRowMapper<User>(User.class));
		returndto.setUser(user);
		return returndto;
	}

	@Override
	public boolean insert(DataTransferObject dto) {
		int successFlag =getJdbcTemplate().update(INSERT_USER,
				dto.getUser().getName(),dto.getUser().getAge(),dto.getUser().getAddress());
		return successChecker(successFlag);
	}

	@Override
	public boolean delete(DataTransferObject dto) {
		int successFlag =getJdbcTemplate().update(DELETE_USER,
				dto.getUser().getId());
		return successChecker(successFlag);
	}

	@Override
	public boolean update(DataTransferObject dto) {
		int successFlag =getJdbcTemplate().update(UPDATE_USER,
				dto.getUser().getName(),dto.getUser().getAge(),dto.getUser().getAddress(),dto.getUser().getId());
		return successChecker(successFlag);
	}
	

}
