package com.project.core.models.Impl;

import com.project.core.models.Testimonial;
//import com.project.core.models.TitleText;
import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.Default;
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
        adaptables = Resource.class,
        adapters = Testimonial.class,
//resourceType =HomeAbout.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TestimonialImpl implements Testimonial {
    private static final Logger LOG = LoggerFactory.getLogger(TestimonialImpl.class);
    @Inject
    Resource componentResource;
    @Override
    public List<Map<String, String>> getTestimonialDetailsWithMap() {
        List<Map<String, String>> testimonialDetailsMap=new ArrayList<>();
        try {
            Resource testimonialDetail=componentResource.getChild("testimonialdetailswithmap");
            if(testimonialDetail!=null){
                for (Resource testimonial : testimonialDetail.getChildren()) {
                    Map<String,String> testimonialMap =new HashMap<>();
                    testimonialMap.put("question",testimonial.getValueMap().get("question",String.class));
                    testimonialMap.put("name",testimonial.getValueMap().get("name",String.class));
                    testimonialMap.put("profession",testimonial.getValueMap().get("profession",String.class));
                    testimonialDetailsMap.add(testimonialMap);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Fact Details {} ",e.getMessage());
        }
        LOG.info("\n SIZE {} ",testimonialDetailsMap.size());
        return testimonialDetailsMap;
    }
}