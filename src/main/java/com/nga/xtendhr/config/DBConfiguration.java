package com.nga.xtendhr.config;

/*
 * DataBase configuration file 
 * Used to dynamically pick schema and the artifact table path
 * 
 * @author	:	Manish Gupta  
 * @email	:	manish.g@ngahr.com
 * @version	:	0.0.1
 */

public class DBConfiguration {
	public static final String SCHEMA_NAME = "AMREST_DOC_GENERATION";
	public static final String ARTIFACT_PATH = "com.amrest.docgeneration";

	public static final String TABLE_PATH = ".db::Table.";

	public static final String FHD_COUNTRIES = "\"" + ARTIFACT_PATH + TABLE_PATH + "DGEN_COUNTRIES\"";
}
