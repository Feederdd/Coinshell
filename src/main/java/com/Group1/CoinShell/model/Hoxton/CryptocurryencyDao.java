package com.Group1.CoinShell.model.Hoxton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocurryencyDao extends JpaRepository<Cryptocurrency,Integer>{
	

	@Query(value="SELECT TOP 1 * FROM cryptocurrency WHERE Symbol_of_Cryptocurrency = :currencyName1 ORDER BY InformationDate DESC",nativeQuery = true)
	public Cryptocurrency findLastestCurrencyInformation(@Param("currencyName1") String currencyName);
	
	@Query(value="   SELECT*,  (SELECT TOP 1 volume24hUsd  FROM  Cryptocurrency WHERE  YEAR(informationDate)=T1.y  and  MONTH(informationDate)=T1.m and  DAY(informationDate)=T1.d and  symbol_of_cryptocurrency = T1. symbol_of_cryptocurrency) Volume24hUsd,  (SELECT TOP 1 USD_Market_Cap  FROM  Cryptocurrency WHERE  YEAR(informationDate)=T1.y  and  MONTH(informationDate)=T1.m and  DAY(informationDate)=T1.d and  symbol_of_cryptocurrency = T1. symbol_of_cryptocurrency) USD_Market_Cap,  (SELECT TOP 1 USD_Price_of_Cryptocurrency  FROM  Cryptocurrency WHERE  YEAR(informationDate)=T1.y  and  MONTH(informationDate)=T1.m and  DAY(informationDate)=T1.d and  symbol_of_cryptocurrency = T1. symbol_of_cryptocurrency) Frist_USD_Price_of_Cryptocurrency, (SELECT TOP 1 USD_Price_of_Cryptocurrency  FROM  Cryptocurrency WHERE  YEAR(informationDate)=T1.y  and  MONTH(informationDate)=T1.m and  DAY(informationDate)=T1.d and  symbol_of_cryptocurrency = T1. symbol_of_cryptocurrency ORDER BY id DESC) Latest_USD_Price_of_Cryptocurrency FROM ( SELECT YEAR(informationDate) y, MONTH(informationDate) m, DAY(informationDate) d, CONVERT(nvarchar,YEAR(informationDate))+'-0'+CONVERT(nvarchar,MONTH(informationDate))+'-'+CONVERT(nvarchar,DAY(informationDate)) as day, symbol_of_cryptocurrency, MIN(USD_Price_of_Cryptocurrency) MIN_USD_Price_of_Cryptocurrency, MAX(USD_Price_of_Cryptocurrency) MAX_USD_Price_of_Cryptocurrency FROM Cryptocurrency  WHERE Symbol_of_Cryptocurrency = :currencyName2 GROUP BY  YEAR(informationDate) , MONTH(informationDate), DAY(informationDate), symbol_of_cryptocurrency ) T1 ORDER BY day",nativeQuery = true)
	public List<Map<String,Object>> findHistoricalCurrencyInformation(@Param("currencyName2")String currencyName);
	//Example:http://localhost:8080/coinshell/historical/get?currencyName=eth

	@Query(value="select * FROM Cryptocurrency WHERE DATEDIFF(dd,InformationDate,GETDATE())<=30 and Symbol_of_Cryptocurrency =:currencyName3",nativeQuery = true)
	public List<Map<String,Object>> find30DaysCurrencyInformation(@Param("currencyName3")String currencyName);
	//返回指定幣別30天的的json資料
	
	@Query(value="select * FROM Cryptocurrency WHERE DATEDIFF(dd,InformationDate,GETDATE())<=7 and Symbol_of_Cryptocurrency =:currencyName3",nativeQuery = true)
	public List<Map<String,Object>> find7DaysCurrencyInformation(@Param("currencyName3")String currencyName);
	//返回指定幣別天的的json資料
	
	@Query(value="select  InformationDate FROM Cryptocurrency WHERE DATEDIFF(dd,InformationDate,GETDATE())<=30 and Symbol_of_Cryptocurrency =:currencyName3",nativeQuery = true)
	public List<String> find30DaysCurrencyInformationDate(@Param("currencyName3")String currencyName);
	//返回指定幣別30天的的json日期資料
	
	@Query(value="select  USD_Price_of_Cryptocurrency FROM Cryptocurrency WHERE DATEDIFF(dd,InformationDate,GETDATE())<=30 and Symbol_of_Cryptocurrency =:currencyName3",nativeQuery = true)
	public List<String> find30DaysCurrencyUsdPrice(@Param("currencyName3")String currencyName);
	//返回指定幣別30天的的json日期資料
	


	
}