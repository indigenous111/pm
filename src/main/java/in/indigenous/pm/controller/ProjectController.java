package in.indigenous.pm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.indigenous.pm.facade.ProjectFacade;
import in.indigenous.pm.model.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectFacade projectFacade;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreate(Model model) {
		model.addAttribute("project", new Project());
		return "create-proj";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Project project, Model model) {
		Project created = projectFacade.create(project);
		model.addAttribute("project", created);
		return "view-proj";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String showUpdate(@PathVariable Long id, Model model) {
		model.addAttribute("project", projectFacade.findById(id));
		model.addAttribute("statuses", projectFacade.listStatus());
		return "edit-proj";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Project project, Model model) {
		Project updated = projectFacade.update(project);
		model.addAttribute("project", updated);
		return "view-proj";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("projects", projectFacade.listProjects());
		return "list-proj";
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("project", projectFacade.findById(id));
		return "view-proj";
	}
}
