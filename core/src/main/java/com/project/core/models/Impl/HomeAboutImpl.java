package com.project.core.models.Impl;

import com.project.core.models.HomeAbout;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

@Model(adaptables = Resource.class,adapters = HomeAbout.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HomeAboutImpl implements HomeAbout {

    @Inject
    String bio;

    @Inject
    String details;

    @Inject
    String intro;

    @Inject
    String button;

    @ValueMapValue
    String fileReference;

    @Override
    public String getBio() {
        return bio;
    }

    @Override
    public String getDetails() {
        return details;
    }

    @Override
    public String getIntro() {
        return intro;
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
