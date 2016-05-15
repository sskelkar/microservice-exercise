package com.globomart.productcatalogue.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.globomart.productcatalogue.domain.Product;
import com.globomart.productcatalogue.domain.ProductType;

/**
 * This class serves as the database layer. For the purpose of this test, SQLite is being used.
 * 
 * The underlying database implementation can be changed without effecting the rest of the service.
 * 
 * @author Administrator
 *
 */
@Component
public class ProductRepository {

	List<Product> productDatabase = new ArrayList<>();
	private static volatile Long id = 1L;
	
	public ProductRepository() {
		addDummyValues();
	}
	public void add(Product product) {
		product.setId(getId());
		productDatabase.add(product);
	}
	
	public void delete(Long productId) {
		Iterator<Product> it = productDatabase.iterator();
		while(it.hasNext()) {
			Product curr = it.next();
			if(curr.getId() == productId) {
				it.remove();
				break;
			}
		}
	}
	
	public List<Product> getAllProducts() {
		return productDatabase;
	}
	
	private synchronized Long getId() {
		id ++;
		return id;
	}
//	public ProductRepository() {
////		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
////	    EmbeddedDatabaseConnection db = builder.setType(H2).addScript("my-schema.sql").addScript("my-test-data.sql").build();
////		JdbcDataSource ds = new JdbcDataSource();
////		
////		ds.setUser("sa");
////		ds.setPassword("sa");
////		try {
////			Connection conn = ds.getConnection();
////			conn.
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
//	}
	
	private void addDummyValues() {
		productDatabase.add(new Product(2L, "Lenovo k4 note", ProductType.ELECTRONIC));
		productDatabase.add(new Product(3L, "Blue jean", ProductType.GARMENTS));
	}
	
}
