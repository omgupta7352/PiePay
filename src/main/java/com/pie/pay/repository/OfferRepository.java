package com.pie.pay.repository;

import com.pie.pay.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    boolean existsByBankNameAndTitle(String bankName, String title);

    List<Offer> findByBankNameIgnoreCase(String bankName);

    List<Offer> findByBankNameIgnoreCaseAndPaymentInstrumentIgnoreCase(String bankName, String paymentInstrument);
}
