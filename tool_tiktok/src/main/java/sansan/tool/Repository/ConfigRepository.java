package sansan.tool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sansan.tool.Entity.Config;

@Repository
public interface ConfigRepository extends JpaRepository<Config, String> {
    Config findAllByStatus(String value);
}
