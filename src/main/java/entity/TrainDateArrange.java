package entity;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * �𳵰�������ʵ����
 * @author ��Ԫ��
 *
 */
public class TrainDateArrange {
	
	// ���
    private Integer id;
    
    // �г̰��ſ�ʼ����
    private String day;
    
    // �𳵰��ű��
    private Integer trainArrangeId;
    
    // ��λʣ�����
    private String explain;
    
    // �г̰��Ž�������
    private String endDay;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Integer getTrainArrangeId() {
		return trainArrangeId;
	}

	public void setTrainArrangeId(Integer trainArrangeId) {
		this.trainArrangeId = trainArrangeId;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
    
    
}
