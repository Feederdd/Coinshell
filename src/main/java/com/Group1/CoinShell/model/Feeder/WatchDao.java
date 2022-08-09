package com.Group1.CoinShell.model.Feeder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchDao extends JpaRepository<Watch, Integer> {

	@Query(value="select * from coin where name = :name", nativeQuery=true)
	public List<Coin> findByName(@Param("name") String name);
	
	//刪除語句 回傳int 搭配@Modifyung
	@Modifying
	@Query(value="delete watch where memberId = :memberId and coinId = :coinId", nativeQuery=true )
	public int deleteByCoinId(Integer memberId ,Integer coinId);
	
	//如果單一參數 用這個
//	public Long deleteByCoinId(Integer coinId);
	
	@Query(value="select * from watch where memberId = :memberId", nativeQuery=true)
	public List<Watch> findByMemberId(@Param("memberId") Integer memberId);

	
}
