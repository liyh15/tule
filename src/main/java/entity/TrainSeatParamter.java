package entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
/**
 * ����ÿ�ֻ𳵵���������json�ַ���
 * @author tarena
 */
public class TrainSeatParamter implements Serializable{
   public static int softBerth=1; //���Ե���ʼ����
   public static int hardBerth=3; //Ӳ�Ե���ʼ����
   public static int hardSeat=5;//Ӳ������ʼ����
   public static int businessSeat=1;//����������ʼ����
   public static int firstSeat=3;//һ��������ʼ����
   public static int secondSeat=5;//����������ʼ����
   public static String normalTrain; //��ͨ����λ�Ų����
   public static String highTrain;   //����������λ�Ų����
   public static Map<String, Integer> seatA=new HashMap<String, Integer>();

   static
   {
	    TrainSeat seat1=new TrainSeat();
		TrainSeat seat2=new TrainSeat();
		TrainSeat seat3=new TrainSeat();
		TrainSeat seat4=new TrainSeat();
		seat1.setSeatType("Ӳ��");
		seat2.setSeatType("Ӳ��");
		seat3.setSeatType("����");
		seat1.setPrice(300);
		seat2.setPrice(200);
		seat3.setPrice(100);
		seat4.setSeatType("����");
		seat4.setPrice(50);
		List<TrainSeat> trainSeats=new ArrayList<TrainSeat>();
		trainSeats.add(seat1);
		trainSeats.add(seat2);
		trainSeats.add(seat3);
		trainSeats.add(seat4);
		JSONArray jsonArray=JSONArray.fromObject(trainSeats);
	    normalTrain=jsonArray.toString();
	    seat1.setSeatType("������");
	    seat2.setSeatType("һ����");
	    seat3.setSeatType("������");
	    List<TrainSeat> trainSeats2=new ArrayList<TrainSeat>();
	    trainSeats2.add(seat1);
		trainSeats2.add(seat2);
		trainSeats2.add(seat3);
		JSONArray jsonArray2=JSONArray.fromObject(trainSeats2);
		highTrain=jsonArray2.toString();
		seatA.put("Ӳ��", 0);
		seatA.put("Ӳ��", 1);
		seatA.put("����", 2);
		seatA.put("����", 3);
	    seatA.put("������", 0);
	    seatA.put("һ����", 1);
	    seatA.put("������", 2);
   }
   public static void main(String[] args) {
	  //System.out.println(TrainSeatParamter.highTrain);
	  System.out.println(TrainSeatParamter.normalTrain);
}
}
