package com.hyxy.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.hyxy.entity.Commodity;

//ElasticsearchRepository参数User---文档类型，Integer----主键类型
public interface CommodityDao extends ElasticsearchRepository<Commodity, Integer>{

}
