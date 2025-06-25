package lk.ijse.payment_service.service.impl;

import lk.ijse.payment_service.dto.PaymentDTO;
import lk.ijse.payment_service.entity.Payment;
import lk.ijse.payment_service.repo.PaymentRepository;
import lk.ijse.payment_service.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PaymentDTO processPayment(PaymentDTO paymentDTO) {
        paymentDTO.setTransactionStatus("SUCCESS");
        paymentDTO.setTransactionTime(LocalDateTime.now().toString());
        paymentDTO.setReceiptUrl("https://mock-receipts.com/" + UUID.randomUUID());

        Payment payment = modelMapper.map(paymentDTO, Payment.class);

        Payment saved = paymentRepository.save(payment);
        return modelMapper.map(saved, PaymentDTO.class);
    }
}

