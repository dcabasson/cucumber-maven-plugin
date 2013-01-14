package org.codehaus.mojo.cucumber.bean;

public class FeatureSummary {

    private String featureTitle;

    private String featureDescription;

    public FeatureSummary() {
        super();
    }

    public FeatureSummary(String featureTitle, String featureDescription) {
        super();
        this.featureTitle = featureTitle;
        this.featureDescription = featureDescription;
    }

    public String getFeatureTitle() {
        return featureTitle;
    }

    public void setFeatureTitle(String featureTitle) {
        this.featureTitle = featureTitle;
    }

    public String getFeatureDescription() {
        return featureDescription;
    }

    public void setFeatureDescription(String featureDescription) {
        this.featureDescription = featureDescription;
    }

}
