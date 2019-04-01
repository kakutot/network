package com.example.temp.presentation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.temp.R;
import com.example.temp.domain.mvpbase.BaseContract;


public abstract class BaseFragment<P extends BaseContract.BasePresenter>
        extends Fragment implements BaseContract.BaseView<P>{

    private P presenter;

    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        setupViewContent();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(this.getClass().getName(), "OnResume");
        if(getPresenter() != null){
            getPresenter().attachView(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(getPresenter() != null){
            getPresenter().detachView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public P getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(P presenter) {
        this.presenter = presenter;
        presenter.attachView(this);
    }

    @Override
    public void onError() {
        showToastMessage(getResources().getString(R.string.error_message_default));
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showToastMessage(int message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected abstract void injectDependencies();

    protected abstract void setupViewContent();
}