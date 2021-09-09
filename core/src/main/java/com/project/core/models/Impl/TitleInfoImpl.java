package com.project.core.models.Impl;

import com.project.core.models.TitleInfo;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,adapters = TitleInfo.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TitleInfoImpl implements TitleInfo {

    @Inject
    boolean sectiongap;

    @Inject
    String title;

    @Inject
    String info;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public Boolean isSectiongap() {
        return sectiongap;
    }
}
