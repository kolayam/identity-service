package eu.nimble.core.infrastructure.identity.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johannes Innerbichler on 25.09.18.
 */
@ApiModel(value = "CompanyDescription")
public class CompanyDescription {

    @ApiModelProperty(value = "Statement of the company")
    private String companyStatement = null;

    @ApiModelProperty(value = "Main website of the company")
    private String website = null;

    @ApiModelProperty(value = "List of social media references (e.g. Facebook)")
    private List<String> socialMediaList = new ArrayList<>();

    @ApiModelProperty(value = "List of past events")
    private List<CompanyEvent> pastEvents = new ArrayList<>();

    @ApiModelProperty(value = "List of upcoming events")
    private List<CompanyEvent> upcomingEvents = new ArrayList<>();

    public String getCompanyStatement() {
        return companyStatement;
    }

    public void setCompanyStatement(String companyStatement) {
        this.companyStatement = companyStatement;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<String> getSocialMediaList() {
        return socialMediaList;
    }

    public void setSocialMediaList(List<String> socialMediaList) {
        this.socialMediaList = socialMediaList;
    }

    public List<CompanyEvent> getPastEvents() {
        return pastEvents;
    }

    public void setPastEvents(List<CompanyEvent> pastEvents) {
        this.pastEvents = pastEvents;
    }

    public List<CompanyEvent> getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(List<CompanyEvent> upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }
}