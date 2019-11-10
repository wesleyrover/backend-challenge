package com.invillia.acme.auth.service;

import com.invillia.acme.auth.db.entity.Payment;
import com.invillia.acme.auth.repository.PaymentRepository;
import com.invillia.acme.store.service.BaseService;
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
