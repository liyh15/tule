package spring.mapper;

import java.util.List;

import entity.City;

/**
 * �뾲̬�������ݶ�Ӧ��myBatis Mapper�ӿ�
 * @author ��Ԫ��
 *
 */
public interface StaticDataMapper {
    
	/**
	 * ��ȡ���еĳ���
	 * @return ���س��еļ���
	 */
	List<City> getAllCity(); 
}
