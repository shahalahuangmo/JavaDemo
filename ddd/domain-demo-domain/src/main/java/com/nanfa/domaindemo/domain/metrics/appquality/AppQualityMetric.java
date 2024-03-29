package com.nanfa.domaindemo.domain.metrics.appquality;

import com.nanfa.domaindemo.domain.metrics.MainMetric;
import com.nanfa.domaindemo.domain.metrics.MainMetricType;
import com.nanfa.domaindemo.domain.metrics.devquality.BugMetric;
import com.nanfa.domaindemo.domain.user.UserProfile;

public class AppQualityMetric extends MainMetric {

    private AppMetric appMetric;

    public AppQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setAppQualityMetric(this);
        this.metricMainType = MainMetricType.APP_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getAppQualityWeight();
    }
}
