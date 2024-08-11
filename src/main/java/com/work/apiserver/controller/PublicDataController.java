package com.work.apiserver.controller;


import com.work.apiserver.model.PublicData;
import com.work.apiserver.service.PublicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class PublicDataController {

    @Autowired
    private PublicDataService publicDataService;

    @PostMapping("/save")
    public ResponseEntity<String> savePublicData(@RequestBody List<PublicData> publicDataList) {
        publicDataService.saveAllData(publicDataList);
        return ResponseEntity.ok("Data saved successfully");
    }

}
