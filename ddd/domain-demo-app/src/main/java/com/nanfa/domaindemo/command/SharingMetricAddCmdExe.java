package com.nanfa.domaindemo.command;

import com.alibaba.cola.dto.Response;
import com.nanfa.domaindemo.domain.metrics.techinfluence.InfluenceMetric;
import com.nanfa.domaindemo.domain.metrics.techinfluence.SharingMetric;
import com.nanfa.domaindemo.domain.metrics.techinfluence.SharingMetricItem;
import com.nanfa.domaindemo.domain.metrics.techinfluence.SharingScope;
import com.nanfa.domaindemo.domain.user.UserProfile;
import com.nanfa.domaindemo.dto.SharingMetricAddCmd;
import com.nanfa.domaindemo.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * SharingMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-02 5:00 PM
 */
@Component
public class SharingMetricAddCmdExe{

    @Resource
    private MetricGateway metricGateway;

    public Response execute(SharingMetricAddCmd cmd) {
        SharingMetricItem sharingMetricItem = new SharingMetricItem();
        BeanUtils.copyProperties(cmd.getSharingMetricCO(), sharingMetricItem);
        sharingMetricItem.setSubMetric(new SharingMetric(new InfluenceMetric(new UserProfile(cmd.getSharingMetricCO().getOwnerId()))));
        sharingMetricItem.setSharingScope(SharingScope.valueOf(cmd.getSharingMetricCO().getSharingScope()));
        metricGateway.save(sharingMetricItem);
        return Response.buildSuccess();
    }
}
