package com.work.apiserver.specifications;

import com.work.apiserver.model.PublicData;
import org.springframework.data.jpa.domain.Specification;

public class PublicDataSpecifications {
    public static Specification<PublicData> hasTitle(String title) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("galTitle"), "%" + title + "%");
    }

    public static Specification<PublicData> hasPhotographer(String photographer) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("galPhotographer"), "%" + photographer + "%");
    }
}
