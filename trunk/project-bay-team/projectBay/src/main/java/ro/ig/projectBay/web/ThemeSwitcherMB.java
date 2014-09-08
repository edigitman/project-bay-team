package ro.ig.projectBay.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "themeMB")
@ApplicationScoped
public class ThemeSwitcherMB {

	private String theme;

	private List<String> themeList;

	@PostConstruct
	public void init() {
		theme = "flick";
		themeList = new ArrayList<String>();

		themeList.add("afterdark");
		themeList.add("afternoon");
		themeList.add("afterwork");
		themeList.add("aristo");
		themeList.add("black-tie");
		themeList.add("blitzer");
		themeList.add("bluesky");
		themeList.add("bootstrap");
		themeList.add("casablanca");
		themeList.add("cupertino");
		themeList.add("cruze");
		themeList.add("dark-hive");
		themeList.add("delta");
		themeList.add("dot-luv");
		themeList.add("eggplant");
		themeList.add("excite-bike");
		themeList.add("flick");
		themeList.add("glass-x");
		themeList.add("home");
		themeList.add("hot-sneaks");
		themeList.add("humanity");
		themeList.add("le-frog");
		themeList.add("metroui");
		themeList.add("midnight");
		themeList.add("mint-choc");
		themeList.add("overcast");
		themeList.add("pepper-grinder");
		themeList.add("redmond");
		themeList.add("rocket");
		themeList.add("sam");
		themeList.add("smoothness");
		themeList.add("south-street");
		themeList.add("start");
		themeList.add("sunny");
		themeList.add("swanky-purse");
		themeList.add("trontastic");
		themeList.add("ui-darkness");
		themeList.add("ui-lightness");
		themeList.add("vader");
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void saveTheme() {
		// this.theme ;
	}

	public List<String> getThemeList() {
		return themeList;
	}

	public void setThemeList(List<String> themeList) {
		this.themeList = themeList;
	}

}
