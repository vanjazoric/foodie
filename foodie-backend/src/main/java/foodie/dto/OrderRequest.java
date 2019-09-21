package foodie.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

	private String note;

	private double amount;

	private String newUserAddress;

	private String newUserPhone;

	private List<OrderItemDto> orderItems;
	
	private Date orderDate;
	
	private String status;

}
