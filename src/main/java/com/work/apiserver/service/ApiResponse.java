package com.work.apiserver.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.work.apiserver.model.PublicData;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    private Response response;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {
        private Header header;
        private Body body;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Header {
            private String resultCode;
            private String resultMsg;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Body {
            private Items items;
            private int numOfRows;
            private int pageNo;
            private int totalCount;

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Items {
                private List<PublicData> item;
            }
        }
    }
}
