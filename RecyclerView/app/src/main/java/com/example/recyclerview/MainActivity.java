package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<FoodRecipe> foodRecipeList = new LinkedList<>();
    // dummy data
    private String title;
    private String briefDescription;
    private ArrayList<String> ingredients;
    private String procedure;
    private RecyclerView recyclerView;
    private FoodRecipeListAdapter foodRecipeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add data
        for (int i = 1; i <= 20; i++) {
            title = "Food recipe " + i;
            briefDescription = "Food recipe " + i + " description";
            ingredients = new ArrayList<String>() {
                {
                    add("Ingredient 1");
                    add("Ingredient 2");
                    add("Ingredient 3");
                    add("Ingredient 4");
                    add("Ingredient 5");
                }
            };
            procedure = "Procedure " + i;
            FoodRecipe foodRecipe = new FoodRecipe(title, briefDescription, ingredients, procedure, R.drawable.foodimg);
            foodRecipeList.add(foodRecipe);
        }

        // get a handle to the RecyclerView
        recyclerView = findViewById(R.id.recyclerview);
        // create an adapter and supply the data to be displayed
        foodRecipeListAdapter = new FoodRecipeListAdapter(this, foodRecipeList);
        // connect the adapter with the RecyclerView
        recyclerView.setAdapter(foodRecipeListAdapter);
        // give the RecyclerView a default layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}