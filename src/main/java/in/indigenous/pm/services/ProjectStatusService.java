package in.indigenous.pm.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.indigenous.common.jpa.entity.pm.ProjectStatus;
import in.indigenous.common.jpa.repository.pm.ProjectStatusRepository;

/**
 * 
 * @author sarkh
 *
 */
@Service
@Transactional(transactionManager = "pmTransactionManager", readOnly = false)
public class ProjectStatusService {

	@Autowired
	private ProjectStatusRepository projectStatusRepository;

	/**
	 * 
	 * @param status
	 * @return
	 */
	public ProjectStatus findByStatus(String status) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(projectStatusRepository.findByStatus(status), ProjectStatus.class);
	}

	/**
	 * 
	 * @return
	 */
	public List<ProjectStatus> list() {
		ObjectMapper mapper = new ObjectMapper();
		return projectStatusRepository.findAll().stream().map(status -> {
			return mapper.convertValue(status, ProjectStatus.class);
		}).collect(Collectors.toList());
	}
}
