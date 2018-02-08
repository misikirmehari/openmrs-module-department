/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.department.api.dao;

import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.department.Department;
import org.openmrs.module.department.Item;
import org.openmrs.module.department.api.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("department.DepartmentDao")
/**
 * Database methods for {@link DepartmentService}.
 */
public interface DepartmentDAO {
	
	/**
	 * @see org.openmrs.module.department.api.DepartmentService#getAllDepartments()
	 */
	List<Department> getAllDepartments();
	
	/**
	 * @see org.openmrs.module.department.api.DepartmentService#getDepartment(java.lang.Integer)
	 */
	Department getDepartment(Integer departmentId);
	
	/**
	 * @see org.openmrs.module.department.api.DepartmentService#saveDepartment(org.openmrs.module.department.Department)
	 */
	Department saveDepartment(Department department);
	
	/**
	 * @see org.openmrs.module.department.api.DepartmentService#purgeDepartment(org.openmrs.module.department.Department)
	 */
	void purgeDepartment(Department department);
}
