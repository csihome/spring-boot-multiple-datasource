package net.famunity.multidatasource.gcp.repository.cassandra;

import net.famunity.multidatasource.gcp.model.Credential;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;


public interface CredentialCassandraRepository extends CassandraRepository<Credential, String> {

	@Query("Select * from credential where accessKey=?0")
	public Credential findByAccessKey(String accessKey);

}