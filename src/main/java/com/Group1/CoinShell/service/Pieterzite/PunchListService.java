package com.Group1.CoinShell.service.Pieterzite;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Group1.CoinShell.model.Feeder.Coin;
import com.Group1.CoinShell.model.Pieterzite.PunchList;
import com.Group1.CoinShell.model.Pieterzite.PunchListDao;
import com.Group1.CoinShell.model.Yiwen.Members;
import com.Group1.CoinShell.model.Yiwen.MembersDao;

@Service
@Transactional
public class PunchListService {

	@Autowired
	private PunchListDao punchListDao; 
	
	@Autowired
	private MembersDao membersDao;
	
	// 簽到
	public PunchList goPunchIn(int Id) {
		Optional<PunchList> optional = punchListDao.findByPunchListMemberId(Id);
		
		if(optional.isPresent()) {
			PunchList punchList = optional.get();
			Date now = new Date();
			long nowtime = 0; 
			nowtime = now.getTime();

			
// 有簽到記錄
			
			// 取得上次簽到時間
			long lastTime = punchList.getPunchDateTime().getTime();
			// 相差天數
			long differDays = (nowtime - lastTime)/1000/60/60/24;
			
			// 判斷
			// 簽到完不到一天
			if(differDays < 1) { 
				
			return null;
			
			}
			// 有連續簽到
			if (differDays >= 1 && differDays < 2) {
				// 簽到表更新為現在時間
				punchList.setPunchDateTime(now);
				// 連續簽到 天數+1
				punchList.setPunchCount(punchList.getPunchCount()+1);
				// 儲存簽到表
				punchListDao.save(punchList);
				
				
			}
			// 連續簽到中斷
			if (differDays >= 2) { 
				punchList.setPunchDateTime(now);
				punchList.setPunchCount(1);
				punchListDao.save(punchList);
				
			}
			return punchList;
		}
		
// 沒有簽到記錄 
		
		else {
			// 建立一個新簽到表 給第一次簽到的使用者
			PunchList newPunchList = new PunchList();
			Optional<Members> option = membersDao.findById(Id);
			
			if(option.isPresent()) {
				newPunchList.setMember(option.get());
				newPunchList.setPunchDateTime(new Date());
				newPunchList.setPunchCount(1); // 第一天
				
				punchListDao.save(newPunchList);
				
				return newPunchList;
			}
		}
		return null;
	}

	public Optional<PunchList> findByPunchListMemberId(int memberId) {
		return punchListDao.findByPunchListMemberId(memberId);
	}
}