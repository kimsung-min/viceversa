package com.work.apiserver.service;

import com.work.apiserver.model.PublicData;
import com.work.apiserver.repository.PublicDataRepository;
import com.work.apiserver.specifications.PublicDataSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicDataService {

    @Autowired
    private PublicDataRepository publicDataRepository;

    public void saveAllData(List<PublicData> publicDataList) {
        publicDataRepository.saveAll(publicDataList);
    }

    public List<PublicData> searchData(String title, String photographer) {
        Specification<PublicData> spec = Specification.where(null);

        if (title != null && !title.isEmpty()) {
            spec = spec.and(PublicDataSpecifications.hasTitle(title));
        }
        if (photographer != null && !photographer.isEmpty()) {
            spec = spec.and(PublicDataSpecifications.hasPhotographer(photographer));
        }

        return publicDataRepository.findAll(spec);
    }
}
