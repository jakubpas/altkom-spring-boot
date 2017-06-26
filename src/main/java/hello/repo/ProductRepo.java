package hello.repo;

import java.util.List;

import hello.aop.Monitoring;
import hello.model.Product;

public interface ProductRepo {
	public Long insert(Product product);

	Long count();

	public void delete(Long id);

	public Product find(Long id);

	public void update(Product product);

	@Monitoring
	public List<Product> getAll();
}
