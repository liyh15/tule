package utils;

import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Json�Ļ�����
 * @author ��Ԫ��
 *
 */
public class JsonUtil {
   
	
	/**
	 * ���json���϶����ַ���
	 * @param object
	 * @return
	 */
	public static String getJsonArrayStrByObject(Object object){
		return JSONArray.fromObject(object).toString();
	}
	
	/**
	 * ���json��ͨ�����ַ���
	 * @param object
	 * @return
	 */
	public static String getJsonObjectStrByObject(Object object){
		return JSONObject.fromObject(object).toString();
	}
	
	/**
	 * ͨ���ַ������jsonArray����
	 * @param str
	 * @return
	 */
	public static JSONArray getJsonArrayByStr(String str){
		return JSONArray.fromObject(str);
	}
	
	/**
	 * ͨ�������ַ������jsonObject����
	 * @param str
	 * @return
	 */
	public static JSONObject getJsonObjectByStr(String str){
		return JSONObject.fromObject(str);
	}
	
	/**
	 * ͨ����ͬ�����json�����ȡ����ʵ��
	 * @param obj json����
	 * @param cls �����
	 * @return
	 */
	public static Object getObjectByJsonObject(JSONObject obj,Class cls){
		return JSONObject.toBean(obj,cls);
	}
	
	/**
	 * ͨ��json���϶����ü��϶���ʵ��
	 * @param array
	 * @param cls
	 * @return
	 */
	public static List getListByJsonArray(JSONArray array,Class cls){
		return JSONArray.toList(array, cls);
	}
}
