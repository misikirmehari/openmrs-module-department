/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.department.web.controller;

import org.openmrs.api.context.Context;
import org.openmrs.messagesource.MessageSourceService;
import org.openmrs.module.department.Department;
import org.openmrs.module.department.api.DepartmentService;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

import static org.apache.solr.core.SolrConfig.log;

/**
 * This class configured as controller using annotation and mapped with the URL of
 * 'module/${rootArtifactid}/${rootArtifactid}Link.form'.
 */
@Controller("${rootrootArtifactid}.DepartmentController")
@RequestMapping(value = "module/${rootArtifactid}/${rootArtifactid}.form")
public class DepartmentController {
	
	@RequestMapping(value = "/module/department/departmentForm.form", method = RequestMethod.POST)
	public String submitDepartment(WebRequest request, HttpSession httpSession, ModelMap model,
	        @RequestParam(required = false, value = "action") String action,
	        @ModelAttribute("department") Department department, BindingResult errors) {
		
		MessageSourceService mss = Context.getMessageSourceService();
		DepartmentService departmentService = Context.getService(DepartmentService.class);
		if (!Context.isAuthenticated()) {
			errors.reject("department.auth.required");
		} else if (mss.getMessage("department.purgeDepartment").equals(action)) {
			try {
				departmentService.purgeDepartment(department);
				httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "department.delete.success");
				return "redirect:departmentList.list";
			}
			catch (Exception ex) {
				httpSession.setAttribute(WebConstants.OPENMRS_ERROR_ATTR, "department.delete.failure");
				log.error("Failed to delete department", ex);
				return "redirect:departmentForm.form?departmentId=" + request.getParameter("departmentId");
			}
		} else {
			departmentService.saveDepartment(department);
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "department.saved");
		}
		return "redirect:departmentList.list";
	}
	
}
