package spring.service.impl;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import entity.User;
import spring.mapper.UserMapper;
import spring.service.IUserService;
import spring.service.ex.PassErrorException;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	/**
	 * �û��޸�����
	 * @param oldPass ������
	 * @param newPass ������
	 * @exception ����������쳣
	 */
	public void changeUserPass(String phone,String oldPass, String newPass) throws PassErrorException {
	     User user=userMapper.getUserByPhone(phone);
	     String pass=getMd5Password(oldPass, user.getSalt());
	     if(!user.getPassword().equals(pass))
	     {
	    	 throw new PassErrorException("ԭ�������");
	     }
	     else {
	    	 userMapper.changeUserPass(phone, getMd5Password(newPass, user.getSalt()));
		}	     
	}
	/**
	 * ��ȡ�������ֵ
	 * @return
	 */
	private String getSalt()
	{
		return UUID.randomUUID().toString().toUpperCase();
	}
	/**
	 * ��ȡ���ܺ������
	 * @param password ԭ����
	 * @param salt ��ֵ
	 * @return
	 */
	private String getMd5Password(String password,String salt)
	{
		String one=md5(password);
		String two=md5(salt);
		String three=one+two;
		for(int i=0;i<5;i++)
		{
			three=md5(three);
		}
		return three;
	}
	
	/**
	 * ���ַ�������md5����
	 * @param str
	 * @return
	 */
	private String md5(String str)
	{
		return DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
	}
}
