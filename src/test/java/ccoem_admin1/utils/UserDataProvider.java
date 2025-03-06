package ccoem_admin1.utils;

import java.util.List;

import org.testng.annotations.DataProvider;

import ccoem_admin1.models.User;

public class UserDataProvider {
	
	@DataProvider(name = "userData")
    public static Object[][] getUserData() {
        List<User> users = JsonReader.getUsers("src/test/java/ccoem_admin1/testdata/UserData.json");

        if (users == null || users.isEmpty()) {
            throw new RuntimeException("No users found in JSON file.");
        }

        Object[][] data = new Object[users.size()][6];

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            data[i][0] = user.getFname();
            data[i][1] = user.getLname();
            data[i][2] = user.getEmail();
            data[i][3] = user.getPhone();
            data[i][4] = user.getPassword();
            data[i][5] = user.getRole();
        }

        return data;
    }

}
