package spring.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import dao.TrainDao;
import entity.Order;
import entity.Passenger;
import entity.TrainArrange;
import entity.TrainDateArrange;
import spring.service.IOrderService;
import spring.service.IPassengerService;
import spring.service.ITrainService;
import spring.service.ex.SystemException;
import staticdate.OrderStaticDate;
import utils.OrderUtil;
/**
 * ������spring���������
 * @author ��Ԫ��
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	
	 @Autowired
	 private IOrderService orderService;
	 @Autowired
	 private ITrainService trainService;
	 @Autowired
	 private IPassengerService passengetService;
	 
	 @RequestMapping(value = "/orderDetailView.do")	 
	 /**
	  * ���ݶ�����Ų�ѯ��������
	  * @param id �������
	  * @param session
	  * @return
	  */
     public String orderDetailView(@RequestParam("id") int id,HttpSession session){	
		 session.removeAttribute("orderList");
		 Order order = orderService.getOrderByOrderId(id);	
		 // ��ȡ������ڰ��ű��
		 Integer tdai = order.getTrafficDateArrangeId();
		 String trafficType = order.getType();
		 if(OrderStaticDate.TRAIN_TYPE.equals(trafficType)){
			 // �����������Ϊ������
			 TrainDateArrange trainDateArrange = trainService.getTrainDateArrangeById(tdai);
			 TrainArrange trainArrange = trainService.getTrainArrangeById(trainDateArrange.getTrainArrangeId());
			 trainArrange.setDate(trainDateArrange.getDay());
			 trainArrange.setEndDate(trainDateArrange.getEndDay());
			 session.setAttribute("TrainArrange", trainArrange);
		 }
		 Integer [] passengerId = order.getPassengerId();
		 // ��ó˿���Ϣ
		 List<Passenger> passengers = passengetService.getPassengersById(passengerId);	
    	 session.setAttribute("passengers", passengers);
    	 order.setStatus(OrderUtil.getDisByName(order.getStatus()));
    	 order.setCreateTime(order.getCreateTime().substring(0,19));
    	 session.setAttribute("order", order); 
    	 try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(order.getTimeClose().substring(0,19));
			session.setAttribute("timeClose", date.getTime());			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 return "train_order";
     }
	 
	 /**
	  * ȡ����������
	  * @param id �������
	  * @return ���ز���״̬
	  */
	 @RequestMapping("/cancelOrder.do")
	 @ResponseBody
	 public ResultResponse<String> cancelOrderController(@RequestParam("id") Integer id){
		 ResultResponse<String> resultResponse = new ResultResponse<String>();
		 Integer state = orderService.cancelOrderById(id);
		 if(state == 0){
			 throw new SystemException("ȡ�����������쳣�����Ժ�����");
		 }
		 resultResponse.setMessage("������ȡ��");
		 resultResponse.setState(200);
		 return resultResponse;
	 }
	 
	 /**
	  * ɾ��������controller
	  * @param id
	  * @return
	  */
	 @RequestMapping("/deleteOrder.do")
	 @ResponseBody
	 public ResultResponse<String> deleteOrderController(@RequestParam("id") Integer id){
		 ResultResponse<String> resultResponse = new ResultResponse<String>();		 
		 Integer state = orderService.deleteOrderById(id);
		 if(state == 0){
			 throw new SystemException("ɾ�����������쳣�����Ժ�����");
		 }
		 resultResponse.setMessage("������ɾ��");
		 resultResponse.setState(200);
		 return resultResponse;
	 }
	 
	 /**
	  * ��Ӷ�ʱ������ʱ���¶�����״̬
	  * ��ʱ���ʺ�4.3.9�汾��spring
	  * ����Ҫ����spring-aop������
	  */
	 @Scheduled(cron = "0/1 * * * * ?")
	 public void updateOrderState(){
		 orderService.cancelOrder();
	 }
}
 