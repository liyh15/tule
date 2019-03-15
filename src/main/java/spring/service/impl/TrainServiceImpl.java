package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entity.TrainArrange;
import entity.TrainDateArrange;
import spring.mapper.TrainMapper;
import spring.service.ITrainService;
@Service
public class TrainServiceImpl implements ITrainService {
	@Autowired
	private TrainMapper trainMapper;
	/**
	 * �����͵ķ���
	 * @author ��Ԫ��
	 */
	public TrainArrange getTrainArrangeById(Integer id) {		
		return trainMapper.getTrainArrangeById(id);
	}
	
	/**
	 * ͨ����Ż�û����ڰ��Ŷ���
	 * @param id
	 * @return
	 */
	public TrainDateArrange getTrainDateArrangeById(Integer id) {
		return trainMapper.getTrainDateArrangeById(id);
	}

}
