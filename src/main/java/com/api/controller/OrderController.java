package com.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.util.RedisUtil;
import com.hyxy.entity.Commodity;
import com.hyxy.entity.UpDate;
import com.hyxy.es.BannerDao;
import com.hyxy.es.CommodityDao;

@RestController
public class OrderController {

	@Value("${server.port}")
	private String serverPort;

//	@Autowired
//	private OrderFeign orderFeign;
	
	@Autowired
	private CommodityDao commodityDao;
	
	@Autowired
	private BannerDao bannerDao;
	
	@Autowired
	private RedisUtil redisutil;

	@RequestMapping("getOrder")
	public List<Commodity> getMember(HttpServletResponse response) {
		// 允许所有的域都可以跨域访问
		response.addHeader("Access-Control-Allow-Origin", "*");
		// 允许跨域GET和POST请求
		response.addHeader("Access-Control-Allow-Method", "*");
		// 解决JSON格式的ajax请求，先是 Options请求，这是预检命令，如果预检命令检查通过之后才进行真正的请求。
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		// 缓存预检命令，在规定的时间内不需要重复的进行预检操作。
		response.addHeader("Access-Control-Max-Age", "3600");// 单位为秒。

		List<Commodity> list = new ArrayList<Commodity>();
		Iterable<Commodity> iter = commodityDao.findAll();
		for (Commodity commodity : iter) {
			list.add(commodity);
		}
		return list;
	}
	
	@RequestMapping("getBanner")
	public List<UpDate> getBanner(HttpServletResponse response) {
		// 允许所有的域都可以跨域访问
		response.addHeader("Access-Control-Allow-Origin", "*");
		// 允许跨域GET和POST请求
		response.addHeader("Access-Control-Allow-Method", "*");
		// 解决JSON格式的ajax请求，先是 Options请求，这是预检命令，如果预检命令检查通过之后才进行真正的请求。
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		// 缓存预检命令，在规定的时间内不需要重复的进行预检操作。
		response.addHeader("Access-Control-Max-Age", "3600");// 单位为秒。

		List<UpDate> list = (List<UpDate>) redisutil.get("shop_banner");
		
		return list;
	}

}
