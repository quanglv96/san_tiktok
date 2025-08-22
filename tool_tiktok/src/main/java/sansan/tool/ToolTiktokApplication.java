package sansan.tool;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "sansan.tool.Entity")
//@ComponentScan(basePackages = {"sansan.utility.lib", "sansan.common"})
//@EnableEurekaClient
public class ToolTiktokApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolTiktokApplication.class, args);
    }

}
