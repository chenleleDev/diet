package com.javaclimb.schedule;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.javaclimb.entity.StatisticsBean;
import com.javaclimb.entity.User;
import com.javaclimb.entity.UserIntakeDaily;
import com.javaclimb.service.UserFoodsService;
import com.javaclimb.service.UserIntakeDailyService;
import com.javaclimb.service.UserService;
import com.javaclimb.service.UserSportService;
import com.javaclimb.util.ReturnDataForLayui;

@Component
public class UserIntakeSchedule {
	
	private static final Logger logger = LoggerFactory.getLogger(UserIntakeSchedule.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserSportService userSportService;	
	@Autowired
	private UserFoodsService userFoodsService;
	@Autowired
	private UserIntakeDailyService userIntakeDailyService;
	
	/**
	 * 自动更新用户今日可摄入量
	 */
	@Scheduled(fixedDelay = 30000)
	public void updateMerchantDailyIncome() {
		logger.info("===自动更新可摄入量开始====");
		long begin = System.currentTimeMillis();
		
		//取得所有用户的列表		
		ReturnDataForLayui list = userService.getList(new User());
		List<User> userList = (List<User>) list.getData();
		
		//遍历用户
		for (User user : userList) {
			//查询条件
			StatisticsBean statisticsBean = new StatisticsBean();
			statisticsBean.setUid(user.getId());
			
			//查询今日总的运动消耗的卡路里
			BigDecimal todayTotalHeatSport = userSportService.getTodayTotalHeat(statisticsBean);			
			//查询今日总的食物增加的卡路里
			BigDecimal todayTotalHeatFoods = userFoodsService.getTodayTotalHeat(statisticsBean);
			
			//计算差值
			BigDecimal substractValue = todayTotalHeatSport.subtract(todayTotalHeatFoods);
			
			//可摄取量
			BigDecimal finalValue = user.getIntake().subtract(substractValue);
			
			if(finalValue.doubleValue()<0) {
				finalValue = new BigDecimal(0);
			}
			
			//保存到今日可摄取量表
			UserIntakeDaily userIntakeDaily = new UserIntakeDaily();
			userIntakeDaily.setUid(user.getId());
			userIntakeDaily.setInsertDate(new Date());
			userIntakeDaily.setIntake(finalValue);
			userIntakeDailyService.add(userIntakeDaily);			
		}
		
		long end = System.currentTimeMillis();
		logger.info("===自动更新可摄入量结束，共耗时：【"+(end - begin)/1000 +"】秒===");
	}
}
























