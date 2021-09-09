package com.project.core.models.Impl;

import com.project.core.models.Pricing;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,adapters = Pricing.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PricingImpl implements Pricing {

    @Inject
    String number;

    @Inject
    String ifor;

    @Inject
    String type;

    @Inject
    String prop1;

    @Inject
    String prop2;

    @Inject
    String prop3;


    @Override
    public String getFor() {
        return ifor;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getProp1() {
        return prop1;
    }

    @Override
    public String getProp2() {
        return prop2;
    }

    @Override
    public String getProp3() {
        return prop3;
    }
}
