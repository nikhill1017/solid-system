package com.lti.product;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
@Path("/product")
public class ProductService {
	@POST
	public Status add(Product product) {
		ProductDao dao = new ProductDao();
		dao.insert(product);
		
		Status status = new Status();
		status.setMessage("product added successfully");
		return status;
	}
}
