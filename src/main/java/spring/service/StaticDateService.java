package spring.service;

import java.util.List;

import entity.City;
import spring.service.ex.SystemException;

/**
 * ���ھ�̬�����ݵ�serviceʵ�ֽӿ�
 * @author ��Ԫ��
 *
 */
public interface StaticDateService {
    
	/**
	 * ��ȡ���еĳ��м���
	 * @return ���س��м���
	 * @exception ϵͳ�쳣
	 */
     List<City> getAllCity() throws SystemException;
}
