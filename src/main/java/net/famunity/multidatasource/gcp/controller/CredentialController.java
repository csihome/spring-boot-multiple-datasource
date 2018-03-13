package net.famunity.multidatasource.gcp.controller;

import net.famunity.multidatasource.gcp.exception.ResourceNotFoundException;
import net.famunity.multidatasource.gcp.model.Credential;
import net.famunity.multidatasource.gcp.repository.mysql.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CredentialController {

    @Autowired
    CredentialRepository credentialRepository;

    @GetMapping("/credentials")
    public List<Credential> getAllCredentials() {
        return credentialRepository.findAll();
    }

    @PostMapping("/credential")
    public Credential createCredential(@Valid @RequestBody Credential credential) {
        return credentialRepository.save(credential);
    }

    @GetMapping("/credential/{id}")
    public Credential getCredentialById(@PathVariable(value = "id") String credentialId) {
        return credentialRepository.findById(credentialId)
                .orElseThrow(() -> new ResourceNotFoundException("Credential", "id", credentialId));
    }

    @PutMapping("/credentials/{id}")
    public Credential updateCredential(@PathVariable(value = "id") String credentialId,
                                 @Valid @RequestBody Credential credentialDetails) {

        Credential credential = credentialRepository.findById(credentialId)
                .orElseThrow(() -> new ResourceNotFoundException("Credential", "id", credentialId));

        credential.setAccessKey(credentialDetails.getAccessKey());
        credential.setSecretKey(credentialDetails.getSecretKey());

        Credential updatedCredential = credentialRepository.save(credential);
        return updatedCredential;
    }

    @DeleteMapping("/credentials/{id}")
    public ResponseEntity<?> deleteCredential(@PathVariable(value = "id") String credentialId) {
        Credential credential = credentialRepository.findById(credentialId)
                .orElseThrow(() -> new ResourceNotFoundException("Credential", "id", credentialId));

        credentialRepository.delete(credential);

        return ResponseEntity.ok().build();
    }
}