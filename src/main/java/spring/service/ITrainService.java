package spring.service;

import org.apache.ibatis.annotations.Param;

import entity.TrainArrange;
import entity.TrainDateArrange;

/**
 * �����͵ķ���
 * @author ��Ԫ��
 *
 */
public interface ITrainService {
   
	/**
	 * ͨ���𳵰��ű�Ż�û𳵰�����Ϣ
	 * @param id �𳵰��ű��
	 * @return ���ػ𳵰�����Ϣ
	 */
	public TrainArrange getTrainArrangeById(Integer id);
	
	/**
	 * ͨ����Ż�û����ڰ��Ŷ���
	 * @param id
	 * @return
	 */
	public TrainDateArrange getTrainDateArrangeById(Integer id);
	
}
