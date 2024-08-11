package com.work.apiserver.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.work.apiserver.model.PublicData;
import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {
    private Response response;

    @Data
    public static class Response {
        private Header header;
        private Body body;

        @Data
        public static class Header {
            private String resultCode;
            private String resultMsg;
        }

        @Data
        public static class Body {
            private Items items;
            private int numOfRows;
            private int pageNo;
            private int totalCount;

            @Data
            public static class Items {
                @JsonProperty("item")
                private List<PublicData> itemList;
            }
        }
    }
}
