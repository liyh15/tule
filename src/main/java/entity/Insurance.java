package entity;

import java.io.Serializable;

/**
 * ���յ�ʵ����
 * @author ��Ԫ��
 */
public class Insurance implements Serializable {
    private int id;      //���յı��
    private String name; //���յ�����
    private int price;   //���յĵļ۸�
    private int comId;//���չ�˾�ı��
    private String type; //���յ�����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getComId() {
		return comId;
	}
	public void setComId(int comId) {
		this.comId = comId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
}
