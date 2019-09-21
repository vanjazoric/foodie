package foodie.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodie.dto.OrderRequest;
import foodie.model.Order;
import foodie.model.OrderStatus;
import foodie.repository.CustomerRepository;
import foodie.repository.OrderRepository;
import foodie.service.OrderItemService;
import foodie.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderItemService orderItemService;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Boolean createOrder(OrderRequest orderRequest, String email) {
		Order order = new Order();
		order.setAmount(orderRequest.getAmount());
		order.setNote(orderRequest.getNote());
		order.setOrderDate(new Date());
		order.setStatus(OrderStatus.ORDERED);
		order.setOrderItems(orderItemService.convertOrderItemsDtoToOrderItems(orderRequest.getOrderItems()));
		order.setCustomer(customerRepository.findByEmail(email));
		Order newOrder = orderRepository.save(order);
		if (newOrder != null)
			return true;
		return false;
	}

	@Override
	public List<OrderRequest> findAllByCustomerId(String userEmail) {
		List<Order> orders = orderRepository.findAllByCustomerEmail(userEmail);
		return convertOrderToOrderRequest(orders);
	}

	List<OrderRequest> convertOrderToOrderRequest(List<Order> orders) {
		List<OrderRequest> ordersDto = new ArrayList<OrderRequest>();
		for (Order order : orders) {
			OrderRequest dto = new OrderRequest();
			dto.setAmount(order.getAmount());
			dto.setOrderItems(orderItemService.convertOrderItemsToOrderItemsDto(order.getOrderItems()));
			dto.setOrderDate(order.getOrderDate());
			ordersDto.add(dto);
		}
		return ordersDto;
	}
}