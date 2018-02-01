/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.department.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.department.Department;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The main service of this module, which is exposed for other modules. See
 * moduleApplicationContext.xml on how it is wired up.
 */
public interface DepartmentService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<Department> getAllDepartments();
	
	/**
	 * Gets a department for a given id.
	 * 
	 * @param id the department id
	 * @return the department with the given id
	 */
	@Transactional(readOnly = true)
	Department getDepartment(Integer departmentId);
	
	/**
	 * Saves a new or existing department.
	 * 
	 * @param department the department to save.
	 * @return the saved department.
	 */
	Department saveDepartment(Department department);
	
	/**
	 * Deletes a department from the database.
	 * 
	 * @param department the department to delete.
	 */
	void purgeDepartment(Department department);
}
