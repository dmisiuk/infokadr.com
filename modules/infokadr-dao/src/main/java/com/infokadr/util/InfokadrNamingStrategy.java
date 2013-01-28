package com.infokadr.util;

import org.hibernate.cfg.DefaultNamingStrategy;

public class InfokadrNamingStrategy extends DefaultNamingStrategy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String classToTableName(String className) {
		return "ik_" + super.classToTableName(className).toLowerCase();
	}
	
	@Override
	public String columnName(String columnName) {
		return super.columnName(columnName);
	}
}
