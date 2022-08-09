package com.Group1.CoinShell.model.Pieterzite;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Group1.CoinShell.model.Yiwen.Members;

@Repository
public interface PunchListDao extends JpaRepository<PunchList, Integer> {

	@Query(value = "SELECT * FROM punch_list WHERE member_Id =:member_Id2 ", nativeQuery = true)
	public Optional<PunchList> findByPunchListMemberId(@Param("member_Id2") int Id);}

//	@Query(value = "SELECT * FROM punch_list WHERE Id = ?1", nativeQuery = true)
//	public Optional<PunchList> findByMembersId(int Id);
//}
