package com.yhc.example.zguide.user.sev.server;

import com.yhc.example.zguide.common.util.R;
import com.yhc.example.zguide.user.api.mode.AreaEntity;

import java.util.List;
import java.util.Map;

public interface AreaServer {
    List<AreaEntity> listAreaByParentCode(String areaCode);

    R listAreaByParentCode(Map<String, Object> params);

    boolean saveArea(AreaEntity area);

    R getAreaById(Long areaId);

    boolean updateArea(AreaEntity area);

    R batchRemoveArea(Long[] id);

    List<AreaEntity> list();
}
