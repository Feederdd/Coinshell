package com.Group1.CoinShell.model.Yiwen;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomizedUserAvatarDao extends JpaRepository<CustomizedUserAvatar, Integer> {

	/**
	 * 加入使用者頭像
	 * 
	 * @param aliasAvatar
	 * @param userAvatar
	 */
	@Query(value = "INSERT INTO CustomizedUserAvatar (aliasAvatar, userAvatar) VALUES(:aliasAvatar2, :userAvatar2)", nativeQuery = true)
	public void insertAvatar(@Param("aliasAvatar2") String aliasAvatar,
						     @Param("userAvatar2") byte[] userAvatar);

	/**
	 * 透過Id刪除使用者頭像
	 * 
	 * @param id
	 */
	@Modifying
	@Query(value = "DELETE FROM CustomizedUserAvatar WHERE id=:id2", nativeQuery = true)
	public void deleteAvatarById(@Param("id2") Integer id);

//findbyName
	@Query(value = "SELECT * FROM customizedUserAvatar WHERE aliasAvatar LIKE '%'+:aliasAvatar2+'%'", nativeQuery = true)
	public List<CustomizedUserAvatar> findAvatarByName(@Param("aliasAvatar2") String aliasAvatar);

//findById
	@Query(value = "SELECT * FROM customizedUserAvatar WHERE id=:id2", nativeQuery = true)
	public CustomizedUserAvatar findAvatarById(@Param("id2") Integer id);

//updateById
	@Query(value = "UPDATE customizedUserAvatar SET aliasAvatar = :aliasAvatar2, userAvatar = :userAvatar2 WHERE id = :id2", nativeQuery = true)
	public void updateAvatarById(@Param("aliasAvatar2") String aliasAvatar, 
								 @Param("userAvatar2") byte[] userAvatar,
								 @Param("id2")Integer id);

//findAll
	@Query(value = "SELECT * FROM customizedUserAvatar", nativeQuery = true)
	public List<CustomizedUserAvatar> findAllAvatars();
}
