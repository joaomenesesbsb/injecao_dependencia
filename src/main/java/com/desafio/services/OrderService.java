package com.desafio.services;

import com.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public Double total(Order order){
        return shippingService.shipment(order) + order.getBasic() - (order.getBasic() * (order.getDiscount()/100));
    }
}
