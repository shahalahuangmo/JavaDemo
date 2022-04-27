package com.nanfa.domaindemo.domain;

import com.alibaba.cola.exception.BizException;
import com.nanfa.domaindemo.domain.metrics.appquality.AppMetric;
import com.nanfa.domaindemo.domain.metrics.appquality.AppMetricItem;
import com.nanfa.domaindemo.domain.metrics.appquality.AppQualityMetric;
import com.nanfa.domaindemo.domain.metrics.devquality.BugMetric;
import com.nanfa.domaindemo.domain.metrics.devquality.BugMetricItem;
import com.nanfa.domaindemo.domain.metrics.devquality.DevQualityMetric;
import com.nanfa.domaindemo.domain.metrics.techcontribution.CodeReviewMetric;
import com.nanfa.domaindemo.domain.metrics.techcontribution.CodeReviewMetricItem;
import com.nanfa.domaindemo.domain.metrics.techcontribution.ContributionMetric;
import com.nanfa.domaindemo.domain.metrics.techinfluence.ATAMetric;
import com.nanfa.domaindemo.domain.metrics.techinfluence.ATAMetricItem;
import com.nanfa.domaindemo.domain.metrics.techinfluence.InfluenceMetric;
import com.nanfa.domaindemo.domain.metrics.weight.DevWeight;
import com.nanfa.domaindemo.domain.metrics.weight.QAWeight;
import com.nanfa.domaindemo.domain.user.UserProfile;
import org.junit.Assert;
import org.junit.Test;

/**
 * UserProfileTest
 *
 * @author Frank Zhang
 * @date 2020-08-28 2:03 PM
 */
public class UserProfileTest {

    @Test
    public void testCalculateScore(){
        UserProfile userProfile = new UserProfile();
        userProfile.setWeight(new DevWeight());

        //App Quality Metric
        AppMetricItem appMetricItem1 = new AppMetricItem();
        appMetricItem1.setAppName("app1");
        appMetricItem1.setCyclomaticComplexityCount(200);
        appMetricItem1.setDuplicatedMethodCount(80);
        appMetricItem1.setLongMethodCount(70);
        appMetricItem1.setBlockedCodeConductCount(20);
        appMetricItem1.calculateScore();

        AppMetricItem appMetricItem2 = new AppMetricItem();
        appMetricItem2.setAppName("app2");
        appMetricItem2.setCyclomaticComplexityCount(20);
        appMetricItem2.setDuplicatedMethodCount(30);
        appMetricItem2.setLongMethodCount(7);
        appMetricItem2.setBlockedCodeConductCount(5);
        appMetricItem2.calculateScore();

        AppMetric appMetric = new AppMetric();
        appMetric.addMetricItem(appMetricItem1);
        appMetric.addMetricItem(appMetricItem2);

        AppQualityMetric appQualityMetric = new AppQualityMetric(userProfile);
        appMetric.setParent(appQualityMetric);

        //influence Metric
        InfluenceMetric influenceMetric = new InfluenceMetric(userProfile);
        InfluenceMetricTest.prepareSubMetrics(influenceMetric);

        //techContribution Metric
        CodeReviewMetric codeReviewMetric = new CodeReviewMetric();
        CodeReviewMetricItem codeReviewMetricItem = new CodeReviewMetricItem();
        codeReviewMetricItem.setNoteCount(4);
        codeReviewMetricItem.setReviewId("12234455");
        codeReviewMetric.addMetricItem(codeReviewMetricItem);
        ContributionMetric contributionMetric = new ContributionMetric(userProfile);

        //dev quality metric
        DevQualityMetric devQualityMetric = new DevQualityMetric(userProfile);
        BugMetric bugMetric = new BugMetric();
        BugMetricItem bugMetricItem = new BugMetricItem(2, 1000);
        bugMetric.addMetricItem(bugMetricItem);
        devQualityMetric.setBugMetric(bugMetric);

        //Execution
        userProfile.calculateScore();

        //Assertion
        Assert.assertEquals(45.8, userProfile.getTotalScore(), 0.01);
    }

    @Test(expected = BizException.class)
    public void testNPE(){
        UserProfile userProfile = new UserProfile();
        userProfile.setWeight(new DevWeight());

        userProfile.calculateScore();
    }
}
