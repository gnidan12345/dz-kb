package dataproviders;

import api.models.UserInfo;
import org.testng.annotations.DataProvider;

import static utils.DBReader.getSelectedProjectFromDB;
import static utils.DBReader.getPropertiesFromDB;

public class TestDataProvider{

      @DataProvider(name = "userData")
    public static Object[][] userData(){

        UserInfo userInfo1 = new UserInfo("testuser1", "fakepassword");
        UserInfo userInfo2 = new UserInfo("testadmin", "654321");

        return new Object[][]{
                {"testuser", "fakepassword"}, {"testadmin", "654321"}
        };
    }


    @DataProvider(name = "projectsDB")
    public static Object[][] projectsDB() {

        return getPropertiesFromDB().stream().map(property -> new Object[]{property.getId(), property.getName() })
                .toArray(Object[][]::new);
    }



    @DataProvider(name = "firstprojectsDB")
    public static Object[][] firstprojectsDB() {

        return getSelectedProjectFromDB().stream().map(property -> new Object[]{property.getId(), property.getName() })
                .toArray(Object[][]::new);
    }

}
