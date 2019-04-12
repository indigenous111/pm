package in.indigenous.pm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.indigenous.pm.facade.ProjectFacade;
import in.indigenous.pm.model.Organisation;

@Controller
@RequestMapping("/org")
public class OrganisationController {

	@Autowired
	private ProjectFacade projectFacade;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model) {
		model.addAttribute("organisation", projectFacade.getOrganisation());
		return "view-org";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model) {
		model.addAttribute("organisation", projectFacade.getOrganisation());
		return "edit-org";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String update(Organisation org, Model model) {
		model.addAttribute("organisation", projectFacade.update(org));
		return "view-org";
	}
}
