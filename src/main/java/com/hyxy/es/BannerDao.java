package com.hyxy.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.hyxy.entity.UpDate;

public interface BannerDao extends ElasticsearchRepository<UpDate, Integer>{

}
