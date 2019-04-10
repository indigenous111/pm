package in.indigenous.pm.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.indigenous.common.jpa.repository.pm.OrganisationRepository;
import in.indigenous.pm.model.Organisation;

/**
 * 
 * @author sarkh
 *
 */
@Service
@Transactional(transactionManager = "pmTransactionManager", readOnly = false)
public class OrganisationService {

	@Autowired
	private OrganisationRepository organisationRepository;

	/**
	 * 
	 * @return
	 */
	public Organisation getOrganisation() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(organisationRepository.findAll().get(0), Organisation.class);
	}

	/**
	 * 
	 * @param organisation
	 * @return
	 */
	public Organisation update(Organisation organisation) {
		Optional<in.indigenous.common.jpa.entity.pm.Organisation> entity = organisationRepository.findById(organisation.getId());
		ObjectMapper mapper = new ObjectMapper();
		if (entity.isPresent()) {
			in.indigenous.common.jpa.entity.pm.Organisation target = entity.get();
			target.setName(organisation.getName());
			target.setDescription(organisation.getDescription());
			organisationRepository.saveAndFlush(target);
			return mapper.convertValue(target, Organisation.class);
		}
		throw new EntityNotFoundException("No organisation found.");
	}
}
