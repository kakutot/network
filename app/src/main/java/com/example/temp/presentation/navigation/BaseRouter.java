package com.example.temp.presentation.navigation;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseRouter {

    private AppCompatActivity context;
    private FragmentManager fragmentManager;

    protected BaseRouter(AppCompatActivity context) {
        this.context = context;
        this.fragmentManager = context.getSupportFragmentManager();
    }

    protected void addFragmentToActivity(@NonNull Fragment fragment, @NonNull int frameId) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .add(frameId, fragment)
                .commit();
    }

    protected void replaceFragmentInActivity(@NonNull Fragment fragment, @NonNull int frameId) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(frameId, fragment)
                .commit();
    }

    protected void navigateToActivity(Intent activityIntent){
        context.startActivity(activityIntent);
    }

    protected AppCompatActivity getContext() {
        return context;
    }

    protected FragmentManager getFragmentManager() {
        return fragmentManager;
    }

}
