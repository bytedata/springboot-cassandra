package com.bytedata.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.bytedata.model.Product;

public interface ProductRepository extends CassandraRepository<Product, Integer> {
	@AllowFiltering
	List<Product> findByPriceGreaterThan(double price);

}
