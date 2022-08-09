package com.Group1.CoinShell.service.Yiwen;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.Group1.CoinShell.model.Yiwen.Members;
import com.Group1.CoinShell.model.Yiwen.MembersDao;

@Service
@Transactional
public class MembersService {

	@Autowired
	private MembersDao membersDao;

	public void save(Members members) {
		membersDao.save(members);
	}

	public Members findMemberByEMail(String eMail) {
		Members resMem = membersDao.findMemberByEMail(eMail);
		return resMem;
	}

	public void updateCustomizedUserAvatarById(Integer id, Integer avatarId) {
		membersDao.updateCustomizedUserAvatarById(avatarId, id);
	}
	
	// findAllMembers
	public List<Members> findAllMembers() {
		List<Members> memList = membersDao.findAll();
		return memList;
	}

	public List<Map<String,Object>> findAllMembers2() {
		List<Map<String,Object>> memList = membersDao.findAll2();
		return memList;
	}
	
	public void updateCustomizedUserNameById(String customizedUserName,Integer id) {
		membersDao.updateCustomizedUserNameById(customizedUserName, id);
	}

	// insertMember
	public void insertMember(Integer coin, Integer customizedUserAvatar,
			 String customizedUserName, String eMail, Date joinTime, Integer myShell, String password) {
		membersDao.insertMember(coin, customizedUserAvatar, customizedUserName, eMail, joinTime, myShell, password);
	};
	
	// deleteMemberById
	public void deleteMemberById(Integer id) {
//		membersDao.deleteMemberById(id);
		membersDao.deleteById(id);
	}
		
	// findMemberByName 模糊查詢
	public List<Map<String, Object>> findMemberByName(String customizedUserName){
		List<Map<String, Object>> memList = membersDao.findMemberByName(customizedUserName);
		return memList;
	}

		
	// findById  
	public Members findMemberById (Integer Id) {
		Members resMem = membersDao.findMemberById(Id);
		return resMem;
	}
	
	// findById  
	public List<Members> findMemberById2 (Integer Id) {
		return membersDao.findMemberById2(Id);
	}
	
	public List<Map<String, Object>> findMemberById3 (Integer Id) {
		return membersDao.findMemberById3(Id);
	}
		
	// updateMemberById
	public void updateMemberById(Integer coin, Integer customizedUserAvatar, String customizedUserName,
			 String eMail, Date joinTime, Integer myShell, String password, Integer id) {
		membersDao.updateMemberById(coin, customizedUserAvatar, customizedUserName, eMail, joinTime, myShell, password, id);
	}
	
	public Members findById(int id) {
		Optional<Members> option = membersDao.findById(id);
		
		if (option.isPresent()) {
			return option.get();
		}
		return null;
	}
	
	public Members countReward(int Id, int reward) {

		// 得到使用者全部的獎勵
		Members members = findById(Id);
		int myShell = members.getMyShell();
		// 累加獎勵
		members.setMyShell(myShell + reward);
		
		return members;
	}
		
}
