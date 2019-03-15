package spring.mapper;
import org.apache.ibatis.annotations.Param;

import entity.TrainArrange;
import entity.TrainDateArrange;

/**
 * �𳵵�mybatisʵ�ֽӿ�mapper
 * @author ��Ԫ��
 */
public interface TrainMapper {
   
	/**
	 * ͨ���𳵰��ű�Ż�û𳵰�����Ϣ
	 * @param id �𳵰��ű��
	 * @return ���ػ𳵰�����Ϣ
	 */
	public TrainArrange getTrainArrangeById(@Param("id") Integer id);
	
	/**
	 * ͨ����Ż�û����ڰ��Ŷ���
	 * @param id
	 * @return
	 */
	public TrainDateArrange getTrainDateArrangeById(@Param("id") Integer id);
}

