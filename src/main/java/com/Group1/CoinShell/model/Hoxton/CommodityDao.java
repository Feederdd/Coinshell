package com.Group1.CoinShell.model.Hoxton;

import java.util.List;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityDao extends JpaRepository<Commodity, Integer> {
	/**
	 * 加入商品
	 */
	@Query(value = "INSERT INTO commodity " + "(commodity_name," + "discribe," + "photo," + "coin," + "volume,"
			+ "myshell," + "shell_or_coin) "

			+ "VALUES(" + " :commodityName2," + ":discribe2," + ":photo2," + ":coin2," + ":volume2" + ":myshell2"
			+ ":shellOrCoin)", nativeQuery = true)
	public void insertcommodity(@Param("commodityName2") String commodityName, @Param("discribe2") String discribe,
			@Param("photo2") String photo, @Param("coin2") Integer price, @Param("volume2") Integer volume,
			@Param("myshell2") Integer myShell, @Param("shellOrCoin") String shellOrCoin);

	/**
	 * 透過Id刪除商品
	 * 
	 * @param id :商品id
	 */
	@Modifying
	@Query(value = "DELETE FROM commodity WHERE id=:id2", nativeQuery = true)
	public void deleteCommodityById(@Param("id2") Integer id);

	@Query(value = "SELECT * FROM commodity WHERE commodity_name LIKE '%'+:commodityName2+'%'", nativeQuery = true)
	public List<Commodity> findCommodityByName(@Param("commodityName2") String commodityName);
	
	@Query(value = "SELECT * FROM commodity WHERE id=:id", nativeQuery = true)
	public Commodity findCommodityById(@Param("id") Integer id);

		@Modifying
	@Query(value = "UPDATE commodity SET  commodity_name=:commodity_name2, describe=:describe2, shell_or_coin=:shell_or_coin2, myshell=:myShell2, coin=:coin2, volume=:volume2 WHERE id= :id2", nativeQuery = true)
	public void updateCommodityById
	(@Param("commodity_name2") String commodityName,
			@Param("describe2") String discribe, 
			@Param("shell_or_coin2") String shell_or_coin,
			@Param("myShell2") Integer myShell, 
			@Param("coin2") Integer coin, 
			@Param("volume2") Integer volume,
			@Param("id2")Integer id); 

	@Query(value = "SELECT * FROM commodity", nativeQuery = true)
	public List<Commodity> findAllCommodity();
	


}
