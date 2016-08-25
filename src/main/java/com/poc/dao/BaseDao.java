package com.poc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.poc.dto.DataTransferObject;

/**
 * extends this class if you want the class to be a dao class
 * @author joliveros
 *
 */
@Repository
public abstract class BaseDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * @return jdbctemplate for CRUD methods
	 */
	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
	
	/**
	 * 
	 * @param successFlag
	 * @return boolean if success
	 */
	public boolean successChecker(int successFlag){
		boolean isSuccessful;
		if(successFlag>0){
			isSuccessful= true;
		}else{
			isSuccessful= false;
		}
		return isSuccessful;
	}
	
	public abstract DataTransferObject find(DataTransferObject dto);
	public abstract boolean insert(DataTransferObject dto);
	public abstract boolean delete(DataTransferObject dto);
	public abstract boolean update(DataTransferObject dto);
}
