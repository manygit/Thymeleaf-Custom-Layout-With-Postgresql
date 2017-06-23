package org.kshrd.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.kshrd.model.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	
	@Select("Select id, user_name, gender, email, phone, status,user_hash,role_id,role_name from tbl_users U "
			+ "INNER JOIN tbl_role R ON R.role_id=U.user_role")
	@Results({
		@Result(property="name",column="user_name"),
		@Result(property="role.id",column="role_id"),
		@Result(property="role.roleName",column="role_name"),
		@Result(property="userHash",column="user_hash")
	})
	public List<UserModel> getAllUser();
	
	@Delete("DELETE FROM tbl_users WHERE user_hash=#{userHash}")
	public boolean deleteUser(@Param("userHash") String userHash);
	
	@Insert("INSERT INTO tbl_users(user_name,gender,email,phone,status,user_role,user_hash) "
			+ "VALUES(#{user.name}, #{user.gender}, #{user.email}, #{user.phone}, #{user.status},#{user.role.id}, #{user.userHash})")
	public boolean addUser(@Param("user") UserModel user);
	
	@Select("Select id, user_name, gender, email, phone, status,user_hash,role_id,role_name from tbl_users U "
			+ " INNER JOIN tbl_role R ON R.role_id=U.user_role "
			+ " WHERE user_hash = #{userHash}")
	@Results({
		@Result(property="name",column="user_name"),
		@Result(property="role.id",column="role_id"),
		@Result(property="role.roleName",column="role_name"),
		@Result(property="userHash",column="user_hash")
	})
	public UserModel findUserByHashCode(@Param("userHash") String userHash);
	
	@Select("Select id, user_name, gender, email, phone, status,user_hash,role_id,role_name from tbl_users U "
			+ " INNER JOIN tbl_role R ON R.role_id=U.user_role "
			+ " WHERE id = #{id}")
	@Results({
		@Result(property="name",column="user_name"),
		@Result(property="role.id",column="role_id"),
		@Result(property="role.roleName",column="role_name"),
		@Result(property="userHash",column="user_hash")
	})
	public UserModel findUserById(@Param("id") int id);
	
	
	@Select("Select id, user_name, gender, email, phone, status,user_hash,role_id,role_name from tbl_users U "
			+ " INNER JOIN tbl_role R ON R.role_id=U.user_role "
			+ " WHERE LOWER(user_name) like #{name}")
	@Results({
		@Result(property="name",column="user_name"),
		@Result(property="role.id",column="role_id"),
		@Result(property="role.roleName",column="role_name"),
		@Result(property="userHash",column="user_hash")
	})
	public List<UserModel> findAllUserByName(@Param("name") String name);
	
	
	@Update("UPDATE tbl_users SET "
			+ "user_name = #{user.name}, "
			+ "gender = #{user.gender}, "
			+ "email = #{user.email}, "
			+ "phone = #{user.phone}, "
			+ "status = #{user.status}, "
			+ "user_role = #{user.role.id} "
			+ "WHERE user_hash = #{user.userHash}")
	public boolean updateUser(@Param("user") UserModel user);

}
