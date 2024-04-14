package files;

import static io.restassured.RestAssured.*;

public class GraphQLScripts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//query
		String response=given().log().all().header("Content-Type","application/json").body("{\"query\":\"query($characterId:Int!, $episodeId:Int!)\\n{\\n  character(characterId:$characterId)\\n  {\\n    name\\n    gender\\n    status\\n    type\\n  }\\n  episode(episodeId:$episodeId)\\n  {\\n    name\\n    air_date\\n    episode\\n  }\\n  \\n}\\n\",\"variables\":{\"characterId\":7244,\"episodeId\":5798}}")
		.when().post("https://rahulshettyacademy.com/gq/graphql")
		.then().extract().response().asString();
		System.out.println(response);
		
		
		
		//mutations
		String mutationresponse=given().log().all().header("Content-Type","application/json").body("{\"query\":\"mutation($locationName:String!,$characterName:String!,$episodeName:String!)\\n{\\n  createLocation(location: {name:$locationName, type: \\\"South\\\", dimension: \\\"2345\\\"}) \\n  {\\n    id\\n  }\\n  createCharacter(character: {name:$characterName, type: \\\"actor\\\", status: \\\"live\\\", species: \\\"human\\\", gender: \\\"Male\\\", image: \\\"asdf34\\\", originId: 4567, locationId: 2345})\\n  {\\n    id\\n  }\\n  createEpisode (episode:{name:$episodeName,air_date:\\\"4-13-2019\\\",episode:\\\"asdf34\\\"})\\n  {\\n    id\\n  }\\n}\\n\\n\",\"variables\":{\"locationName\":\"NewZeland\",\"characterName\":\"Dinesh\",\"episodeName\":\"Tanatan\"}}")
		.when().post("https://rahulshettyacademy.com/gq/graphql")
		.then().extract().response().asString();
		System.out.println(mutationresponse);
	}
	

}
