package ro.ig.projectBay.util;

public class Transition {

	public static final String PROJECT_DETAILS = "projectDetails";
	public static final String CURRENT_PROJECTS = "currentProjects";
	public static final String NEW_PROJECT = "addProject";
	public static final String COLLABORATORS_OVERVIEW = "collaboratorsOverview";
	public static final String MY_COLLABORATORS = "myCollaborators";
	public static final String NEW_COLLABORATOR = "newCollaborator";
	public static final String PAST_COLLABORATIONS = "pastCollaborations";
	public static final String PAST_PROJECTS = "pastProjects";
	public static final String WON_PROJECTS = "wonProjects";
	public static final String CLEARED_PROJECTS = "clearedProjects";

	public static final String MAIN_PAGE = "default";

	public static final String REDIRECT = "";
	public static final String PREFIX = "secure/";
	public static final String SUFFIX = "";

	private static String getTransition(String prefix, String transition,
			String suffix) {
		return transition;
	}
}
