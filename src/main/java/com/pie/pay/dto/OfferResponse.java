package com.pie.pay.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OfferResponse {
    private int noOfOffersIdentified;
    private int noOfNewOffersCreated;
}
