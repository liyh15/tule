package entity;
import java.io.Serializable;
import java.util.List;
/**
 * ���е�ʵ����
 * @author ��Ԫ��
 *
 */
public class City implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;     //���б��
	private String name;//��������
	private String pinyin;//����ƴ��
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
	
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", pinyin=" + pinyin + "]";
	}
	
}
