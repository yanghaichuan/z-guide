package com.yhc.example.zguide.user.sev.server.impl;

import com.yhc.example.zguide.common.util.reponse.R;
import com.yhc.example.zguide.user.api.mode.AreaEntity;
import com.yhc.example.zguide.user.sev.config.RedisCacheConfig;
import com.yhc.example.zguide.user.sev.dao.AreaDaoMapper;
import com.yhc.example.zguide.user.sev.redis.util.RedisUtil;
import com.yhc.example.zguide.user.sev.server.AreaServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("areaServer")
public class AreaServerImpl implements AreaServer {

    @Autowired
    AreaDaoMapper areaDaoMapper;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public List<AreaEntity> listAreaByParentCode(String areaCode) {
        return null;
    }

    @Override
    public R listAreaByParentCode(Map<String, Object> params) {
        return null;
    }

    @Override
    @CacheEvict("area")
    public boolean saveArea(AreaEntity area) {
        boolean flag = false;
        int i = areaDaoMapper.save(area);
        if(i>0){
            flag =true;
        }
        return flag;
    }

    @Override
    public R getAreaById(Long areaId) {
        return null;
    }

    @Override
    public boolean updateArea(AreaEntity area) {
        return false;
    }

    @Override
    public R batchRemoveArea(Long[] id) {
        return null;
    }

    @Override
    @Cacheable(RedisCacheConfig.areaCache)
    public List<AreaEntity> list() {
        long startTime=System.currentTimeMillis(); //获取开始时间
        List<AreaEntity> list = areaDaoMapper.list();
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("sql程序运行时间："+(endTime-startTime)+"ms");
//        if(!redisUtil.hasKey("area_list_all")){
//            long startTime=System.currentTimeMillis(); //获取开始时间
//            List<AreaEntity> list = areaDaoMapper.list();
//            long endTime=System.currentTimeMillis(); //获取结束时间
//            System.out.println("sql程序运行时间："+(endTime-startTime)+"ms");
//            long startTime1=System.currentTimeMillis(); //获取开始时间
//            redisUtil.set("area_list_all",list,60);
//            long endTime1=System.currentTimeMillis(); //获取结束时间
//            System.out.println("redis程序运行时间："+(endTime1-startTime1)+"ms");
//            return list;
//        }
//        long startTime2=System.currentTimeMillis(); //获取开始时间
//        List<AreaEntity> list = (List<AreaEntity>)redisUtil.get("area_list_all");
//        long endTime2=System.currentTimeMillis(); //获取结束时间
//        System.out.println("取redis程序运行时间："+(endTime2-startTime2)+"ms");
        return list;
    }
}
