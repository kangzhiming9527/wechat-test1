package com.qq.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qq.weixin.bean.Constant;
import com.qq.weixin.bean.button.*;
import com.qq.weixin.util.MyHttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeixinDemo2ApplicationTests {

	@Test
	public void contextLoads() {
	}

	/**
	 * 得到服务器IP
	 */
//	@Test
	public void getServerIP() {
		String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
//                     https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN
		String token = Constant.getAccessToken().getAssessToken();
		url = url.replace("ACCESS_TOKEN",token);
		System.out.println(url);
		String s = MyHttpUtil.get(url);
		System.out.println(s);
		JSONObject jsonObject = JSONObject.parseObject(s);
		String ip_list = jsonObject.getString("ip_list");
		if(ip_list==null){
			System.out.println("失败："+s);
		}else{
			System.out.println("成功");
		}
	}

	/**
	 * 删除自定义菜单
	 */
//	@Test
	public void delMenu(){
		String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
		String token = Constant.getAccessToken().getAssessToken();
		System.out.println(token);
		String urlNew = url.replace("ACCESS_TOKEN", token);

		String jsonStr = MyHttpUtil.get(urlNew);
		System.out.println("删除自定义菜单结果:" + jsonStr);
	}

	/**
	 * 创建菜单
	 */
//	@Test
	public void creationMenu(){
		Button bt =new Button();
		bt.getButton().add(new ClickButton("菜单一","123"));
		bt.getButton().add(new ViewButton("菜单二","http://www.baidu.com"));
		SubButton sb = new SubButton("有子菜单");
		sb.getSub_button().add(new ClickButton("点击","333"));
		sb.getSub_button().add(new ViewButton("网易","http://www.163.com"));
		sb.getSub_button().add(new PhotoOrAlbumButton("传图","666"));
		bt.getButton().add(sb);
		String btStr = JSON.toJSONString(bt);
		System.out.println(btStr);
		String url = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

		/*		获取token	*/
//		String token ="";
		String token = Constant.getAccessToken().getAssessToken();
		/*		获取token	*/

		String urlNew = url.replace("ACCESS_TOKEN",token);
		String post = MyHttpUtil.post(urlNew, btStr);
		System.out.println(post);
		JSONObject jsonObject = JSONObject.parseObject(post);
		String errcode = jsonObject.getString("errcode");
		if("0".equals(errcode)){
			System.out.println("创建菜单成功");
		}
	}

}
