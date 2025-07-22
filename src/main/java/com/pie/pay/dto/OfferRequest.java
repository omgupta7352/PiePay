package com.pie.pay.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class OfferRequest {
    private JsonNode flipkartOfferApiResponse;
}