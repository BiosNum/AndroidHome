package com.example.recipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import adapters.RecipeAdapter;
import models.Recipe;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Recipe>recipes = new ArrayList<Recipe>();
    RecipeAdapter recipeAdapter;

    public void onClick(View v)
    {
        TextView name = (TextView) v.findViewById(R.id.tvName);
        TextView hard = (TextView) v.findViewById(R.id.tvHard);

        Intent intent = new Intent(this, FullActivity.class);
        intent.putExtra("nameFull", name.getText().toString());
        intent.putExtra("hardFull", hard.getText().toString());
        intent.putExtra("descFull", getRecipeDesc(name.getText().toString()));

        startActivity(intent);
    }

    protected String getRecipeDesc(String name)
    {
        for (Recipe recipe:recipes)
            if (recipe.name == name)
                return recipe.desc;

        return "нет описания";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createRecipes();
        recipeAdapter = new RecipeAdapter(this, recipes);

        ListView lvMain = (ListView) findViewById(R.id.listView);
        lvMain.setAdapter(recipeAdapter);
    }

    void createRecipes()
    {
        ArrayList<Recipe> rec = recipes;
        Recipe r;

        r = new Recipe("Тосты с гуакамоле и белой фасолью", 5,
                "Нарежьте хлеб на порционные кусочки, запеките в заранее разогретой до 200 °C духовке до легкого колера и хрустящей корочки.\n" +
                        "Разрежьте чеснок пополам, слегка натрите каждый тост чесноком. Оставшиеся зубчики переложите в глубокую миску.\n" +
                        "Авокадо очистите, извлеките столовой ложкой мякоть, выложите ее в емкость к чесноку, добавьте соль, молотый перец, лимонный сок и оливковое масло, немного томатного соуса от фасоли и измельчите погружным блендером.\n" +
                        "Красный лук нарежьте как можно мельче.\n" +
                        "Помидор очистите от кожицы и семян, нарежьте мякоть кубиками, добавьте белую фасоль без соуса и измельченный перец чили, перемешайте.\n" +
                        "Выложите на тосты пасту из авокадо, присыпьте красным луком, сверху дополните томатно-фасолевой смесью, украсьте листиками кинзы и подавайте в качестве закуски.");

        rec.add(r);

        r = new Recipe("Мусс из козьего сыра с кукурузой и мёдом", 2,
                "Охлажденные сливки взбейте с сахарной пудрой до легкой пены, затем аккуратно смешайте с козьим сыром.\n" +
                        "Мёд смешайте с сильно измельченным розмарином. \n" +
                        "На дно креманок выложите кукурузу, затем сырный мусс и розмариновый мёд.\n" +
                        "Перед подачей посыпьте десерт измельченным бисквитным печеньем.");

        rec.add(r);

        r = new Recipe("Брускетта с тапенадом из маслин",
                100500,
                "В блендере смешайте маслины (без рассола), чеснок, сыр, лимонный сок, оливковое масло, базилик, соль и перец по вкусу. Взбейте все до однородной пасты.\n" +
                        "В сковороде растопите сливочное масло и обжарьте багет до золотистой корочки с двух сторон.\n" +
                        "Выложите тапенад из маслин на теплые брускетты и подайте к столу.");
        rec.add(r);

        r = new Recipe("Блюдо 2", 5, "Описание 2");
        rec.add(r);

        r = new Recipe("Блюдо 3", 6, "Описание 3");
        rec.add(r);

        r = new Recipe("Блюдо 4", 5, "Описание 4");
        rec.add(r);

        r = new Recipe("Блюдо 5", 7, "Описание 5");
        rec.add(r);
    }

}
