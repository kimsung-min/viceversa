package com.work.apiserver.controller;

import com.work.apiserver.model.PublicData;
import com.work.apiserver.service.DataCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collect")
public class DataCollectorController {

    @Autowired
    private DataCollectorService dataCollectorService;

    @GetMapping("/api/collect-and-save")
    public String collectAndSaveData() {
        dataCollectorService.collectAndSaveData();
        return "데이터 수집 및 저장 완료";

    }


}
