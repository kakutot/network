package com.example.temp.presentation.restaurants;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.temp.R;
import com.example.temp.domain.entity.Restaurant;
import com.example.temp.domain.mvpbase.BaseContract;
import com.example.temp.presentation.BaseFragment;
import com.example.temp.presentation.collections.CollectionsContract;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

public class RestaurantsFragment extends BaseFragment<RestaurantsContract.RestaurantsPresenter>
        implements RestaurantsContract.RestaurantsView {

    public static RestaurantsFragment getInstance() {
        return new RestaurantsFragment();
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
        return inflater.inflate(R.layout.fragment_restaurants, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.i(this.getClass().getName(), "OnCreateOptMenu");
        menu.clear();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Restaurants");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        inflater.inflate(R.menu.menu_collections, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

        MenuItem menuItem = menu.findItem(R.id.action_search);
        menuItem.setActionView(searchView);
        menuItem.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        searchView.setQueryHint("Rest search");
        /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        });*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : getActivity().getSupportFragmentManager()
                                                  .beginTransaction().remove(this).commit();
                                    getActivity().getSupportFragmentManager().popBackStack();
                                    return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void injectDependencies() {

    }

    @Override
    protected void setupViewContent() {

    }

    @Override
    public void renderRestaurants(List<Restaurant> restaurants) {

    }

    @Override
    public void showRestaurantsOrderSelectionView() {

    }
}
