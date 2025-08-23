package sansan.tool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sansan.tool.Entity.Config;

import java.util.List;

@Repository
public interface ConfigRepository extends JpaRepository<Config, String> {
    List<Config> findAllByStatus(String value);
}
