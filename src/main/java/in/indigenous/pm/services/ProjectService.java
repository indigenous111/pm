package in.indigenous.pm.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import in.indigenous.common.jpa.repository.pm.OrganisationRepository;
import in.indigenous.common.jpa.repository.pm.ProjectRepository;
import in.indigenous.common.jpa.repository.pm.ProjectStatusRepository;
import in.indigenous.pm.model.Project;

/**
 * 
 * @author sarkh
 *
 */
@Service
@Transactional(transactionManager = "pmTransactionManager", readOnly = false)
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjectStatusRepository projectStatusRepository;

	@Autowired
	private OrganisationRepository organisationRepository;

	/**
	 * 
	 * @return
	 */
	public List<Project> list() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		return projectRepository.findAll().stream().map(prj -> {
			return mapper.convertValue(prj, Project.class);
		}).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public Project findByName(String name) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		return mapper.convertValue(projectRepository.findByName(name), Project.class);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Project findById(Long id) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		Optional<in.indigenous.common.jpa.entity.pm.Project> entity = projectRepository.findById(id);
		if (entity.isPresent()) {
			return mapper.convertValue(entity.get(), Project.class);
		} else {
			throw new EntityNotFoundException("Project not found.");
		}
	}

	/**
	 * 
	 * @param project
	 * @return
	 */
	public Project create(Project project) {
		in.indigenous.common.jpa.entity.pm.Project entity = projectRepository.findByName(project.getName());
		if (entity == null) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			entity = mapper.convertValue(project, in.indigenous.common.jpa.entity.pm.Project.class);
			entity.setCreatedOn(LocalDateTime.now());
			entity.setStatus(projectStatusRepository.findByStatus("IDEA"));
			projectRepository.save(entity);
			return mapper.convertValue(entity, Project.class);
		} else {
			throw new EntityExistsException("Project with name " + project.getName() + " already exists.");
		}
	}

	/**
	 * 
	 * @param project
	 * @return
	 */
	public Project update(Project project) {
		Optional<in.indigenous.common.jpa.entity.pm.Project> entity = projectRepository.findById(project.getId());
		in.indigenous.common.jpa.entity.pm.Project target = null;
		if (entity.isPresent()) {
			target = entity.get();
			target.setName(project.getName());
			target.setDescription(project.getDescription());
			target.setModifiedOn(LocalDateTime.now());
			Optional<in.indigenous.common.jpa.entity.pm.ProjectStatus> statusEntity = projectStatusRepository
					.findById(project.getStatus().getId());
			if (statusEntity.isPresent()) {
				target.setStatus(statusEntity.get());
			}
			target.setOrganisation(organisationRepository.findAll().get(0));
		} else {
			throw new EntityNotFoundException("Project does not exist.");
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		return mapper.convertValue(target, Project.class);
	}
}
