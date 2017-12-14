package it.itspiemonte.MeteoApp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ArticleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_detail);
        final String title = getIntent().getStringExtra("articleTitle");
        final String state = getIntent().getStringExtra("state");
        final String tempMax = getIntent().getStringExtra("tempMax");
        final String tempMin = getIntent().getStringExtra("tempMin");
        TextView articleTitle = (TextView) findViewById(R.id.article_title);
        TextView articleState = (TextView) findViewById(R.id.state);
        TextView articleTempMax = (TextView) findViewById(R.id.tempMax);
        TextView articleTempMin = (TextView) findViewById(R.id.tempMin);
        final Button favorite = (Button) findViewById(R.id.button);
        articleTitle.setText(title);
        articleState.setText(state);
        articleTempMax.setText("Temp Max: " + tempMax + "°");
        articleTempMin.setText("Temp Min: " + tempMin + "°");
        final SharedPreferences sharedPref = ArticleActivity.this.getSharedPreferences("MY_PRIVATE_PREF", Context.MODE_PRIVATE);
        String favoriteArticle = sharedPref.getString("favoriteArticle", null);

        if (favoriteArticle != null && favoriteArticle.equals(title)) {
            favorite.setVisibility(View.INVISIBLE);
        }

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("favoriteArticle", title);
                editor.commit();
                favorite.setVisibility(View.INVISIBLE);
            }
        });
    }
}
