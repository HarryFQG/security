package m.itiandou.springsecurity2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"m.itiandou.springsecurity2.dao.**"})
public class SpringSecurity2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity2Application.class, args);
	}
}
