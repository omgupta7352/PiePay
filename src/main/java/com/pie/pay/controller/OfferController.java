package com.pie.pay.controller;

import com.pie.pay.dto.OfferRequest;
import com.pie.pay.dto.OfferResponse;
import com.pie.pay.dto.HighestDiscountResponse;
import com.pie.pay.entity.Offer;
import com.pie.pay.repository.OfferRepository;
import com.pie.pay.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;
    private final OfferRepository offerRepository;

    @GetMapping("/debug-offers")
    public List<Offer> debugOffers() {
        return offerRepository.findAll();
    }

    @PostMapping("/offer")
    public OfferResponse createOffer(@RequestBody OfferRequest request) {
        return offerService.saveOffers(request.getFlipkartOfferApiResponse());
    }

    @GetMapping("/highest-discount")
    public HighestDiscountResponse getHighestDiscount(
            @RequestParam double amountToPay,
            @RequestParam String bankName,
            @RequestParam(required = false) String paymentInstrument) {
        double discount = offerService.getHighestDiscount(amountToPay, bankName, paymentInstrument);
        return new HighestDiscountResponse(discount);
    }
}
