package net.famunity.multidatasource;

import net.famunity.multidatasource.gcp.controller.CredentialCassandraController;
import net.famunity.multidatasource.gcp.controller.CredentialController;
import net.famunity.multidatasource.gcp.model.Credential;
import net.famunity.multidatasource.server.AbstractEmbeddedCassandraTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests extends AbstractEmbeddedCassandraTest {

	@Autowired
	private CredentialController credentialController;


	@Autowired
	private CredentialCassandraController credentialCassandraController;

	@Before
	public void setup(){
	}

	@Test
	public void contextLoads() {
		assertThat(credentialController).isNotNull();
		Credential credential = new Credential().setAccessKey("ACCESS_KEY").setSecretKey("ACCESS_SECRET_KEY");
		Credential savedCredential = credentialController.createCredential(credential);
		System.out.println(savedCredential.getId());
		assertThat(savedCredential.getId()).isNotBlank();
	}

	@Test
	public void contextLoadsCassandra() {
		assertThat(credentialCassandraController).isNotNull();
		Credential credential = new Credential().setAccessKey("ACCESS_KEY").setSecretKey("ACCESS_SECRET_KEY");
		Credential savedCredential = credentialCassandraController.createCredential(credential);
		System.out.println(savedCredential.getId());
		assertThat(savedCredential.getId()).isNotBlank();
	}
}
