package spring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entity.City;
import spring.mapper.StaticDataMapper;
import spring.service.StaticDateService;
import spring.service.ex.SystemException;

/**
 * ���ھ�̬�������ݵ�service�ӿ�ʵ����
 * @author ��Ԫ��
 *
 */
@Service("staticDataService")
public class StaticDataServiceImpl implements StaticDateService {

	@Autowired
	private StaticDataMapper mapper;
	
	/**
	 * ��ѯ�����еļ���
	 */
	public List<City> getAllCity() throws SystemException {
		
		List<City> cities=mapper.getAllCity();	
		if(cities==null)
		{
			throw new SystemException("ϵͳ�����쳣������ϵ����Ա��");
		}
		return cities;
	}
}
