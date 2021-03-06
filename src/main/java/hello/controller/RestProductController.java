package hello.controller;


import javax.inject.Inject;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.aop.Monitoring;
import hello.model.Product;
import hello.repo.ProductRepo;

@RestController
@RequestMapping("/product")
public class RestProductController {

	@Inject
	ProductRepo repo;


    @ApiOperation(value = "Add a product")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody Product product){
        repo.insert(product);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }

	@Monitoring
	@ApiOperation("List products")
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> list() {
		return repo.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		repo.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody Product product) {
		repo.update(product);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> save(@RequestBody Product product) {
		Long id = repo.insert(product);
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);
	}

}
