package sansan.tool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sansan.tool.Entity.Product;
@Repository
public interface ProductRepository  extends JpaRepository<Product, String> {
}
