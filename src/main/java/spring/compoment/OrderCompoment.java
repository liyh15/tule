package spring.compoment;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import dao.TrainDao;

/**
 * ����������
 * @author ��Ԫ��
 *
 */
@Component
public class OrderCompoment {

	/**
	 * �Զ�servlet����dao��
	 * @return
	 */
	@Bean
	public TrainDao returnTrainDao(){
		return new TrainDao();
	}
}
