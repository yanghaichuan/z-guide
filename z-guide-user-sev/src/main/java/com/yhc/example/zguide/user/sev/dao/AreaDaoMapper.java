package com.yhc.example.zguide.user.sev.dao;

import com.yhc.example.zguide.user.api.mode.AreaEntity;

import java.util.List;
import java.util.Map;

/**
 * 行政区域
 */
public interface AreaDaoMapper {

	List<AreaEntity> listAreaByParentCode(Map<String, Object> query);

	int countAreaChildren(Long areaId);

	List<AreaEntity> list();

	int save(AreaEntity areaEntity);

	int update(AreaEntity areaEntity);

	AreaEntity get(Long areaId);
	
}
