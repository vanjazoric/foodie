package foodie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodie.repository.ItemRepository;
import foodie.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	ItemRepository itemRepository;
}
