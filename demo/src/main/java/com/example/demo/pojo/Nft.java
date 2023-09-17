package com.example.demo.pojo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Nft {
    private String identifier;
    private String collection;
    private String contract;
    private String tokenStandard;
    private String name;
    private String description;
    private String imageUrl;
    private String metadataUrl;
    private String createdAt;
    private String updatedAt;
    private Boolean isDisabled;
    private Boolean isNsfw;
    private Boolean isSuspicious;
    private String creator;
    private String traits;
    private List<Owner> owners;
    private String rarity;
}
