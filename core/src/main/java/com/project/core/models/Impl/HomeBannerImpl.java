package com.project.core.models.Impl;

import com.project.core.models.HomeBanner;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
adapters = HomeBanner.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HomeBannerImpl implements HomeBanner {

    @Inject
    String myfirsttext;

    @Inject
    String secondfield;

    @Inject
    String multilinefield;

    @ValueMapValue
    String button;

    @ValueMapValue
    String fileReference;

    @Override
    public String getFullname() {
        return secondfield;
    }

    @Override
    public String getBio() {
        return myfirsttext;
    }

    @Override
    public String getIntro() {
        return multilinefield;
    }

    @Override
    public String getButton() {
        return button;
    }

    @Override
    public String getImage() {
        return fileReference;
    }
}
