package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import  static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider="Booksdata")
	public void addbook(String isbn,String aisle) 
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response= given().header("Content-Type","application/json").body(payload.Addbook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js=Reusablemethods.rawToJson(response);
		String id=js.get("ID");
		System.out.println(id);
		
		//delete book
	}


	
@DataProvider(name="Booksdata")
public Object[][] getdata()
{
	//array- collection of elements
	//multidimensional array-collection of arrays
	
	return new Object[][] {{"zxuv","9876"},{"ghtu","3457"},{"ykio","5789"}};	
}
}
