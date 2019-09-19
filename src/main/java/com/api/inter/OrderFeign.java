package com.api.inter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyxy.entity.Commodity;

@FeignClient("zk-vip")
public interface OrderFeign {
	
	@RequestMapping("getOrder")
	public Commodity getOrder(Commodity commodity) ;

}
