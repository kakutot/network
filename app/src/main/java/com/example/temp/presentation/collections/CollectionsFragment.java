package com.example.temp.presentation.collections;

import android.os.Bundle;
import android.support.constraint.BuildConfig;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;

import com.example.temp.R;
import com.example.temp.data.datasource.CityNetworkDataSource;
import com.example.temp.data.datasource.CollectionNetworkDataSource;
import com.example.temp.data.mapper.CityMapper;
import com.example.temp.data.mapper.CollectionMapper;
import com.example.temp.data.model.CollectionModel;
import com.example.temp.data.network.ZomatoApi;
import com.example.temp.data.network.ZomatoService;
import com.example.temp.data.repositoryimpl.CityRepositoryImpl;
import com.example.temp.data.repositoryimpl.CollectionRepositoryImpl;
import com.example.temp.domain.entity.Collection;
import com.example.temp.presentation.BaseFragment;
import com.example.temp.presentation.navigation.CollectionScreenRouterImpl;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CollectionsFragment extends BaseFragment<CollectionsContract.CollectionsPresenter>
        implements CollectionsContract.CollectionsView {

    @BindView(R.id.collectionsRV)
    RecyclerView collectionsRV;

    @BindView(R.id.restButton)
    MaterialButton button;

    public CollectionsFragment () {
    }

    public static CollectionsFragment getInstance() {
        return new CollectionsFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CollectionScreenRouterImpl router = new CollectionScreenRouterImpl((AppCompatActivity) getActivity());
        button.setOnClickListener((View v)-> {
            router.routeToRestaurantsScreen(45);
        });
        Log.i(this.getClass().getName(), "IS BUTTON NULL :" + (button == null));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collections, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.i(this.getClass().getName(), "OnCreateOptMenu");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Collections");
        inflater.inflate(R.menu.menu_collections, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

        MenuItem menuItem = menu.findItem(R.id.action_search);
        menuItem.setActionView(searchView);
        menuItem.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String cityName) {
                if(getPresenter() != null) {
                    Log.i(this.getClass().getName(), "QUERY :" + cityName);
                    getPresenter().collectionsSearch(cityName);
                }

                return true;
            }
        });
    }

    @Override
    protected void injectDependencies() {
        //TODO DI
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        builder.addInterceptor(chain -> {
            Request original = chain.request();

            Request request = original.newBuilder()
                    .header("Accept", "application/json")
                    .header("user-key", ZomatoApi.API_KEY)
                    .build();

            return chain.proceed(request);
        });

        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);

        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZomatoApi.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ZomatoApi zomatoApi = new ZomatoService(retrofit);
        setPresenter(new CollectionsPresenter(new CollectionRepositoryImpl(new CollectionNetworkDataSource(zomatoApi),
               new CollectionMapper()), new CityRepositoryImpl(new CityNetworkDataSource(zomatoApi),new CityMapper()),
               this, new CollectionScreenRouterImpl((AppCompatActivity) this.getActivity())));

    }

    @Override
    protected void setupViewContent() {
        //TODO implement location autodection
        //presenter.collectionsSearchDefault();
       // getPresenter().collectionsSearch("Milan");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoadingError() {
        //TODO change
        showToastMessage("Error during loading");
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void renderCollections(List<Collection> collections) {
        for(Collection collection : collections) {
            Log.e(this.getTag(), collection.toString());
        }
    }
}
