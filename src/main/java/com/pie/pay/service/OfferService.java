package com.pie.pay.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pie.pay.dto.OfferResponse;
import com.pie.pay.entity.Offer;
import com.pie.pay.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public OfferResponse saveOffers(JsonNode flipkartOfferApiResponse) {
        int identified = 0;
        int created = 0;

        // Parse the JSON (you need to adjust these keys based on Flipkart response)
        Iterator<JsonNode> offers = flipkartOfferApiResponse.get("offers").elements();
        while (offers.hasNext()) {
            identified++;
            JsonNode offerNode = offers.next();
            String bankName = offerNode.get("bankName").asText();
            String title = offerNode.get("title").asText();
            double discountAmount = offerNode.get("discountAmount").asDouble();
            String paymentInstrument = offerNode.get("paymentInstrument").asText();

            if (!offerRepository.existsByBankNameAndTitle(bankName, title)) {
                Offer offer = Offer.builder()
                        .bankName(bankName)
                        .title(title)
                        .discountAmount(discountAmount)
                        .paymentInstrument(paymentInstrument)
                        .createdAt(LocalDateTime.now())
                        .build();
                offerRepository.save(offer);
                created++;
            }
        }
        return new OfferResponse(identified, created);
    }

    public double getHighestDiscount(Double amountToPay, String bankName, String paymentInstrument) {
        System.out.println(">>> DEBUG: Searching for bankName=" + bankName + ", paymentInstrument=" + paymentInstrument);

        List<Offer> offers;
        if (paymentInstrument != null && !paymentInstrument.isBlank()) {
            offers = offerRepository.findByBankNameIgnoreCaseAndPaymentInstrumentIgnoreCase(bankName, paymentInstrument);
        } else {
            offers = offerRepository.findByBankNameIgnoreCase(bankName);
        }

        System.out.println(">>> DEBUG: Found offers count=" + offers.size());
        for (Offer o : offers) {
            System.out.println(">>> DEBUG: Offer => " + o.getBankName() + " | " + o.getDiscountAmount() + " | " + o.getPaymentInstrument());
        }

        double maxDiscount = 0.0;
        for (Offer offer : offers) {
            maxDiscount = Math.max(maxDiscount, offer.getDiscountAmount());
        }
        return maxDiscount;
    }

}
