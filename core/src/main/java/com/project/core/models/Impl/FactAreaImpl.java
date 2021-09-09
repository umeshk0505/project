package com.project.core.models.Impl;

import com.project.core.models.FactArea;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = FactArea.class,
//        resourceType = HomeBannerImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FactAreaImpl implements FactArea{

    private static final Logger LOG = LoggerFactory.getLogger(FactAreaImpl.class);

    @Inject
    Resource componentResource;

    @Override
    public List<Map<String, String>> getFactDetailsWithMap() {
        List<Map<String, String>> factDetailsMap=new ArrayList<>();
        try {
            Resource factDetail=componentResource.getChild("factdetailswithmap");
            if(factDetail!=null){
                for (Resource fact : factDetail.getChildren()) {
                    Map<String,String> factMap=new HashMap<>();
                    factMap.put("factnumber",fact.getValueMap().get("factnumber",String.class));
                    factMap.put("factlabel",fact.getValueMap().get("factlabel",String.class));
//                    bookMap.put("publishyear",fact.getValueMap().get("publishyear",String.class));
                    factDetailsMap.add(factMap);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Fact Details {} ",e.getMessage());
        }
        LOG.info("\n SIZE {} ",factDetailsMap.size());
        return factDetailsMap;
    }
}
