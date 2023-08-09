package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.util.List;

public class User_StepDefs {


    String actualUserCount;
    @Given("Establish the database connection")
    public void establish_the_database_connection() {
       // DB_Util.createConnection();

    }
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
     String query = "SELECT COUNT(ID) FROM users";
     DB_Util.runQuery(query);

        String actualUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println(actualUserCount);




    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

        String query="select count(distinct id) from users";
        DB_Util.runQuery(query);

        String expectedUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println(expectedUserCount);

        Assert.assertEquals(expectedUserCount,actualUserCount);


        //Close Conn
       // DB_Util.destroy();
    }

    @Before
    public void setupDB(){
        DB_Util.createConnection();
        System.out.println("connecting to database.....");

    }

    @After
    public void destroyDB(){
        DB_Util.destroy();
        System.out.println("closing connection....");

    }

    //US01
    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        String query = "select * from users";

        DB_Util.runQuery(query);

        List<String> actualColumnList = DB_Util.getAllColumnNamesAsList();

        System.out.println("actualColumnList = " + actualColumnList);


    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expectedColumns) {

    }


}


