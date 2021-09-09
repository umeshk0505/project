package com.project.core.models.Impl;

import com.project.core.models.TileTitle;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
@Model(adaptables = Resource.class,adapters = TileTitle.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TileTitleImpl implements TileTitle {
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
}
