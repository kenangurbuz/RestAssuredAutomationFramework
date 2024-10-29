package test;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.User;
import utilities.DataProviders;

public class DDTests {

    @Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
    public void testCreateUser(String userID,String userName,String firstName,String lastName,String email,String
                               password,String phone)
    {
        User userPayload=new User();
        userPayload.setId(Integer.parseInt(userID));
        userPayload.setUsername(userName);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);

        Response response= UserEndPoints.createUser(userPayload);

        Assert.assertEquals(response.getStatusCode(),200);


    }

    @Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
    public void testDeleteUser(String userName){

        Response response=UserEndPoints.deleteUser(userName);
        Assert.assertEquals(response.getStatusCode(),200);



    }

}
