package com.gouli.user.biz.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * druid监控数据的外部化调用
 *
 * @author pengnanfa
 * @date 2021/1/14 17:18
 */
@RestController
public class DruidStatController {
    @GetMapping("/stat")
    public Object druidStat() {
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}
