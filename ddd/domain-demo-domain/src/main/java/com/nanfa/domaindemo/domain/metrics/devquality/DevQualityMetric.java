package com.nanfa.domaindemo.domain.metrics.devquality;

import com.nanfa.domaindemo.domain.metrics.MainMetric;
import com.nanfa.domaindemo.domain.metrics.MainMetricType;
import com.nanfa.domaindemo.domain.user.UserProfile;
import lombok.Data;

@Data
public class DevQualityMetric extends MainMetric {

    private BugMetric bugMetric;

    public DevQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setDevQualityMetric(this);
        this.metricMainType = MainMetricType.DEV_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getDevQualityWeight();
    }
}
