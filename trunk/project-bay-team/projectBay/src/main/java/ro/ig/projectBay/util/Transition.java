package ro.ig.projectBay.util;

public class Transition {

	public static final String PROJECT_DETAILS = getTransition("projectDetails");
	public static final String CURRENT_PROJECTS = getTransition("currentProjects");
	public static final String MAIN_PAGE = getTransition("default");

	public static final String REDIRECT = "";
	private static final String PREFIX = "";
	private static final String SUFFIX = ".xhtml";

	private static String getTransition(String transition) {
		return PREFIX + transition + SUFFIX;
	}
}
