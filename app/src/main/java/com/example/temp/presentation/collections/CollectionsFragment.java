package com.example.temp.presentation.collections;

import com.example.temp.domain.entity.Collection;
import com.example.temp.presentation.BaseFragment;

import java.util.List;

public class CollectionsFragment extends BaseFragment<CollectionsContract.CollectionsPresenter>
        implements CollectionsContract.CollectionsView {

    @Override
    protected void injectDependencies() {

    }

    @Override
    public void renderCollections(List<Collection> collections) {

    }
}
