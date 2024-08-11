package com.work.apiserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String galContentId;
    private String galContentTypeId;
    private String galTitle;
    private String galWebImageUrl;
    private String galCreatedtime;
    private String galModifiedtime;
    private String galPhotographyMonth;
    private String galPhotographyLocation;
    private String galPhotographer;
    private String galSearchKeyword;
}
