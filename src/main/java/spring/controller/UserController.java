package spring.controller;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;
import spring.service.IUserService;
import utils.CodeUtil;
/**
 * �û�����Ŀ�������
 * @author ��Ԫ��
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {	
	@Autowired
	@Qualifier("userService")
	private IUserService service;
	/**
	 * ת������¼����
	 * @param session
	 * @param method Ҫ���¼��ע��
	 * @return
	 */
	@RequestMapping("/login.do")
	public String loginView(HttpSession session,
			@RequestParam(value="method",required=false) String method,
			HttpServletRequest request)
	{
		request.setAttribute("method", method);
		return "login";
	}
	
	/**
	 * ת����������
	 * @return
	 */
	@RequestMapping("mainView.do")
	public String mainView()
	{
		return "main";
	}
	
	/**
	 * ת�����𳵹�Ʊ������
	 * @return
	 */
	@RequestMapping("trainView.do")
	public String trainView()
	{
	   return "train_main";
	}
	
	/**
	 * ��̬�Ļ�ȡ��֤��
	 * @param session
	 * @param response
	 */
	@RequestMapping("/codePic.do")
	public void codePic(HttpSession session,HttpServletResponse response)
	{	
    	OutputStream out;
    	Map<String, Object> map = CodeUtil.generateCodeAndPic();
    	session.setAttribute("code",map.get("code").toString().toUpperCase());
		try {
			out = response.getOutputStream();
			ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �û��޸�����
	 * @param old_pwd ������
	 * @param new_pwd ������
	 */
	@RequestMapping(value="/changePass.do",method=RequestMethod.POST)
	@ResponseBody
	public ResultResponse<Void> changeUserPassWord(@RequestParam("old_pwd") String oldPass,
			@RequestParam("new_pwd") String newPass,
			HttpSession session
			)
	{
		User user=(User) session.getAttribute("user");	
		service.changeUserPass(user.getPhone(), oldPass, newPass);
		ResultResponse<Void> response=new ResultResponse<Void>();
		response.setMessage("�޸�����ɹ�");
		return response;
	}
}
