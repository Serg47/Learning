package tequila.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import tequila.dao.UserDao;
import tequila.dao.UserDaoImpl;
import tequila.entity.User;
import tequila.service.UserService;
import tequila.service.UserServiceImpl;

import javax.sql.DataSource;

@Configuration
public class SpringConfig{

    @Bean
    public JdbcTemplate getJdbcTemlate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/calls?useSLL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public UserDao getUserDao(){
        return new UserDaoImpl(getJdbcTemlate());
    }

    @Bean
    public UserService getUserService(){
        return new UserServiceImpl();
    }
}