package foodie.service;

import java.util.List;

import foodie.dto.OrderRequest;

public interface OrderService {

	Boolean createOrder(OrderRequest order, String email);

	List<OrderRequest> findAllByCustomerId(String name);
}
