package org.kshrd.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.kshrd.model.RoleModel;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository {
	@Select("Select role_id, role_name, description,role_hash FROM tbl_role")
	@Results({
		@Result(property="id",column="role_id"),
		@Result(property="roleName",column="role_name")
	})
	public List<RoleModel> getAllRole();
	
	@Delete("DELETE FROM tbl_role WHERE role_hash = #{roleHash}")
	public boolean deleteRole(@Param("roleHash") String roleHash);
	
	@Insert("INSERT INTO tbl_role(role_name,description,role_hash) VALUES(#{role.roleName},#{role.description},#{role.role_hash})")
	public boolean addRole(@Param("role") RoleModel role);
	
	@Select("Select role_id, role_name, description,role_hash FROM tbl_role WHERE role_hash = #{roleHash}")
	@Results({
		@Result(property="roleName", column="role_name")
	})
	public RoleModel findRoleByHash(@Param("roleHash") String roleHash);
	
	@Update("UPDATE tbl_role SET "
			+ "role_name = #{role.roleName}, "
			+ "description = #{role.description} "
			+ " WHERE role_hash = #{role.role_hash}")
	public boolean updateRole(@Param("role") RoleModel role);

}
