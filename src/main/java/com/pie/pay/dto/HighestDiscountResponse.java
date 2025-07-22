package com.pie.pay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HighestDiscountResponse {
    private double highestDiscountAmount;
}