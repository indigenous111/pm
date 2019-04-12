package in.indigenous.pm.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.indigenous.common.jpa.entity.pm.ProjectStatus;
import in.indigenous.pm.model.Organisation;
import in.indigenous.pm.model.Project;
import in.indigenous.pm.services.OrganisationService;
import in.indigenous.pm.services.ProjectService;
import in.indigenous.pm.services.ProjectStatusService;

/**
 * 
 * @author sarkh
 *
 */
@Component
public class ProjectFacade {

	@Autowired
	private OrganisationService organisationService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectStatusService projectStatusService;
	
	/**
	 * 
	 * @return
	 */
	public Organisation getOrganisation() {
		return organisationService.getOrganisation();
	}
	
	/**
	 * 
	 * @param organisation
	 * @return
	 */
	public Organisation update(Organisation organisation) {
		return organisationService.update(organisation);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Project> listProjects() {
		return projectService.list();
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Project findByName(String name) {
		return projectService.findByName(name);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Project findById(Long id) {
		return projectService.findById(id);
	}
	
	/**
	 * 
	 * @param project
	 * @return
	 */
	public Project create(Project project) {
		return projectService.create(project);
	}
	
	/**
	 * 
	 * @param project
	 * @return
	 */
	public Project update(Project project) {
		return projectService.update(project);
	}
	
	/**
	 * 
	 * @param status
	 * @return
	 */
	public ProjectStatus findByStatus(String status) {
		return projectStatusService.findByStatus(status);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<ProjectStatus> listStatus() {
		return projectStatusService.list();
	}
}
