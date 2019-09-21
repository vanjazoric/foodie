package foodie.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodie.dto.OrderRequest;
import foodie.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("create")
	public ResponseEntity<Boolean> createOrder(@RequestBody OrderRequest order, Principal principal) {
		orderService.createOrder(order, principal.getName());
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<OrderRequest>> getOrders(Principal principal) {
		List<OrderRequest> orders = orderService.findAllByCustomerId(principal.getName());
		return new ResponseEntity<List<OrderRequest>>(orders, HttpStatus.OK);
	}
}