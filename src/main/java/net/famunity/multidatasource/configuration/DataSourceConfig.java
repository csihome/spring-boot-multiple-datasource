package net.famunity.multidatasource.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "net.famunity.multidatasource.gcp.repository.mysql")
@EnableCassandraRepositories(basePackages = "net.famunity.multidatasource.gcp.repository.cassandra")
public class DataSourceConfig {
}
