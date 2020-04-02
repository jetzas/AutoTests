package core.TestRail.TestRailMethods;

import core.TestRail.api.*;
import java.text.*;
import java.util.*;
import org.json.*;
import org.testng.*;
import org.testng.internal.*;



public class TestCases extends CryptoToken {


	private JSONObject getPostData(String name, JSONArray createStep) {
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		JSONObject postData = new JSONObject();
		postData.put("priority_id", 2);
		postData.put("created_on", "Created By Auto Test");
		postData.put("description", timeStamp);
		postData.put("name", name);
		postData.put("title", name);
		postData.put("template_id", 2);
		postData.put("type_id", 9);
		postData.put("refs", "Auto Test");
		postData.put("custom_preconds", JSONObject.NULL);
		postData.put("created_on", "Created By Auto Test");
		postData.put("custom_steps_separated", createStep);
		return postData;
	}

	public JSONObject deleteCase(int caseId) {
		return new JSONObject(apiPost(
				getHeader("/delete_case/" + caseId),
				getPostData(null, new JSONArray())
		));
	}

	public JSONArray getCases(int sectionId) {
		return new JSONArray(apiGet(getHeader("/get_cases/2&suite_id=7&section_id=" + sectionId)));
	}

	public String getCase(int case_id) {
		return apiGet(getHeader("/get_case/" + case_id));
	}

	/**
	 * @param section id of group
	 * @return
	 */
	public JSONObject createCase(String name, int section) {
		return new JSONObject(apiPost(
				getHeader("/add_case/" + section),
				getPostData(name, new JSONArray())
		));
	}

	private void createCaseFromSuiteList(ISuite suite, int idSection) {
		List<ITestNGMethod> listOfSuiteTestName = suite.getAllMethods();
		for (Object testName : listOfSuiteTestName) {
			createCase(((TestNGMethod) testName).getMethodName(), idSection);
		}
	}

}
