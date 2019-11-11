package com.invillia.acme.payment.service;

import com.invillia.acme.payment.db.entity.Payment;
import com.invillia.acme.payment.repository.PaymentRepository;
import com.invillia.acme.payment.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService extends BaseService<Payment, PaymentRepository> {

    /**
     * Método de buscar uma Pagamento
     *
     * @param name
     * @param address
     * @return List<Store>
     */
    public List<Payment> findStore(String name , String address) {
        return getRepository().findAll();
    }

    /**
     * Método de salvar o pagamento
     *
     * @param payment
     * @return Payment
     */
    public Payment persistence(Payment payment) throws Exception {
        return this.save(payment);
    }

}
