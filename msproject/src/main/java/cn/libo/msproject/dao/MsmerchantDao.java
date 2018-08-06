package cn.libo.msproject.dao;

import cn.libo.msproject.entity.Msmerchant;

public interface MsmerchantDao {

	public void insertMsmerchant(Msmerchant msmerchant);
	
	public Msmerchant queryMsmerchantByid(int id);
	
	public void updateMsmerchant(Msmerchant msmerchant);
	
	public void deleteMsmerchantByid(int id);
}
