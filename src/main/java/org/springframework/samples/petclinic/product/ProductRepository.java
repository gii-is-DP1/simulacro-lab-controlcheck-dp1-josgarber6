package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    public List<Product> findAll();

    @Query("SELECT pt from ProductType pt")
    public List<ProductType> findAllProductTypes();
    public Optional<Product> findById(int id);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product findByName(@Param("name") String name);
    public Product save(Product p);
    @Query("SELECT pt FROM ProductType pt WHERE pt.name = :name")
    public ProductType findTypeByName(@Param("name") String name);

    public List<Product> findByPriceLessThan(double price);

}
