package com.Group1.CoinShell.service.Yiwen;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Group1.CoinShell.model.Yiwen.CustomizedUserAvatar;
import com.Group1.CoinShell.model.Yiwen.CustomizedUserAvatarDao;

@Service
@Transactional
public class CustomizedUserAvatarService {

	@Autowired
	private CustomizedUserAvatarDao cuaDao;
	
	public void save(CustomizedUserAvatar cuAvatar) {
		cuaDao.save(cuAvatar);
	}
	
	
	//Insert
	public void insertAvatar(String aliasAvatar, byte[] userAvatar) {
		cuaDao.insertAvatar(aliasAvatar, userAvatar);
	}
	
	//DeletebyId
	public void deleteAvatarById(Integer id) {
		cuaDao.deleteAvatarById(id);
	}
	
	//findbyName
	public List<CustomizedUserAvatar> findAvatarByName(String aliasAvatar) {
		List<CustomizedUserAvatar> cuaList = cuaDao.findAvatarByName(aliasAvatar);
		return cuaList;
	}
	
	//findById
	public CustomizedUserAvatar findAvatarById(Integer Id) {
		CustomizedUserAvatar resCua = cuaDao.findAvatarById(Id);
		return resCua;
	}
	
	//updateById
	public void updateAvatarById(String aliasAvatar, byte[] userAvatar, Integer id) {
		cuaDao.updateAvatarById(aliasAvatar, userAvatar, id);
	}
	
	//findAll
	public List<CustomizedUserAvatar> findAllAvatars(){
		List<CustomizedUserAvatar> cuaList = cuaDao.findAllAvatars();
		return cuaList;
	}
	
	
}
