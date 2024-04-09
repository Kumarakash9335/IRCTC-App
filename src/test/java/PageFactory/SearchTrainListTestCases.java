package PageFactory;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Utils.JsonConfigKeys.STATION_FROM;
import static Utils.JsonConfigKeys.STATION_TO;
import static Utils.JsonUtilities.getJSONArray;

public class SearchTrainListTestCases extends BaseTest {
    JSONObject testData = (JSONObject) getJSONArray("src/main/DataFiles/TestData.json").get(0);
    String stationFrom = (String) testData.get(STATION_FROM);
    String stationTo = (String) testData.get(STATION_TO);
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void findTrains() throws InterruptedException {
        HomeScreen homeScreen= new HomeScreen(driver);
        TrainServices trainServices = new TrainServices(driver);
        if (homeScreen.isHomeScreenVisible()){
            homeScreen.gotoTrainService();
            if (trainServices.isTrainServiceScreenVisible()){
                trainServices.findTrains(stationFrom, stationTo);
                softAssert.assertEquals();

            }
        }

    }
}
