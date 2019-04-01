package com.example.temp.presentation.collections;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.temp.R;
import com.example.temp.domain.navigation.CollectionsRouter;
import com.example.temp.presentation.BaseActivity;
import com.example.temp.presentation.navigation.CollectionScreenRouterImpl;
import com.example.temp.presentation.restaurants.RestaurantsActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionsActivity extends BaseActivity {

    @BindView(R.id.appbar_layout)
    View app_bar_layout;

    private CollectionsRouter router;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);
        ButterKnife.bind(this);

        IncludedLayout appBarLayout = new IncludedLayout();
        ButterKnife.bind(appBarLayout, app_bar_layout);
        setSupportActionBar(appBarLayout.toolbar);
        Log.i(getClass().getName(), "onCreate");
        if(savedInstanceState == null) {
            router.routeToCollectionsScreen();
        }
    }

    @Override
    protected void injectDependencies() {
        //TODO DI
        router = new CollectionScreenRouterImpl(this);
    }

    private void navigateToRestaurantsScreen(View view){
        Intent intent = new Intent(this,RestaurantsActivity.class);
        intent.getExtras().putString("TEST","TESTVALUE");
        startActivity(intent);
    }

    static class IncludedLayout {
        @BindView(R.id.toolbar)
        Toolbar toolbar;
    }
}
