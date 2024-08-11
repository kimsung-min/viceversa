package com.work.apiserver.service;

import com.work.apiserver.model.PublicData;
import com.work.apiserver.repository.PublicDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicDataService {

    @Autowired
    private PublicDataRepository publicDataRepository;

    public void saveAllData(List<PublicData> dataList) {
        publicDataRepository.saveAll(dataList);
    }
}
