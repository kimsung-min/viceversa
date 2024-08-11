package com.work.apiserver.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.work.apiserver.model.PublicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

@Service
public class DataCollector {

    @Autowired
    private PublicDataService publicDataService;

    private RestTemplate restTemplate;

    public DataCollector() {
        this.restTemplate = new RestTemplate();
        this.restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this.restTemplate.getMessageConverters().add(new MappingJackson2XmlHttpMessageConverter());
    }

    public void collectAndSaveData() {
        String apiKey = "o47MmMuwXvSJYLyCLSp%2B%2BoTJMOF%2BPZMABTji0c%2BIDGtQaYKCWMzbrgYAd0aot7UcEzdrvhyqz%2FW32Kn9rBmYrg%3D%3D"; // 인코딩된 키 사용
        String url = "http://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?serviceKey=" + apiKey + "&numOfRows=60&pageNo=1&MobileOS=ETC&MobileApp=TestApp&_type=json";

        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();
            String response = responseEntity.getBody();

            System.out.println("HTTP 상태 코드: " + statusCode);
            System.out.println("API 응답: " + response);  // 응답을 콘솔에 출력

            if (statusCode == HttpStatus.OK) {
                if (response == null || response.isEmpty()) {
                    System.out.println("응답 본문이 비어있습니다.");
                    return;
                }

                if (response.startsWith("<")) {
                    // XML 응답 처리
                    System.out.println("XML 형식 응답 처리 필요");
                    // XML 파싱 및 오류 처리 로직 추가 필요
                } else {
                    // JSON 응답 처리
                    ObjectMapper objectMapper = new ObjectMapper();
                    ApiResponse apiResponse = objectMapper.readValue(response, ApiResponse.class);
                    if (apiResponse.getResponse() == null || apiResponse.getResponse().getBody() == null) {
                        System.out.println("API 응답이 null입니다.");
                    } else {
                        List<PublicData> dataList = apiResponse.getResponse().getBody().getItems().getItem();
                        publicDataService.saveAllData(dataList);
                    }
                }
            } else {
                System.out.println("HTTP 오류 발생: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("응답 파싱 중 오류 발생: " + e.getMessage());
        }
    }
}
