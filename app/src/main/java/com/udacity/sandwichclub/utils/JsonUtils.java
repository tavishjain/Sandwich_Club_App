package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();

        List<String> alsoKnownAsList = new ArrayList<>();
        List<String> ingredientsList = new ArrayList<>();

        //This class parses the JSON file

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.optJSONObject("name");
            String mainNameString = name. optString("mainName");
            JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsArray.optString(i));
            }
            String placeOfOriginString = jsonObject.optString("placeOfOrigin");
            String descriptionString = jsonObject.optString("description");
            String imageString = jsonObject.optString("image");

            JSONArray ingredientsArray = jsonObject.getJSONArray("ingredients");
            for (int i = 0; i < ingredientsArray.length(); i++) {
                ingredientsList.add(ingredientsArray.optString(i));
            }

            sandwich.setMainName(mainNameString);
            sandwich.setPlaceOfOrigin(placeOfOriginString);
            sandwich.setDescription(descriptionString);
            sandwich.setImage(imageString);
            sandwich.setAlsoKnownAs(alsoKnownAsList);
            sandwich.setIngredients(ingredientsList);

            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
