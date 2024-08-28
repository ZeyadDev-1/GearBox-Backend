package com.ziad.e_com_proj1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ziad.e_com_proj1.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	@Query("select p from Product p where" + " lower (p.name) like lower (concat('%', :keyword ,'%')) or"
			+ " lower (p.description) like lower (concat('%', :keyword ,'%')) or"
			+ " lower (p.brand) like lower (concat('%', :keyword ,'%')) or"
			+ " lower (p.category) like lower (concat('%', :keyword ,'%'))")
	List<Product> searchProducts(String keyword);
}
