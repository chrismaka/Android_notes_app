package com.example.chris.coldturkey;

import com.example.chris.coldturkey.Model.AppDatabase;
import com.example.chris.coldturkey.ui.MyViewModel;

import dagger.Component;

/**
 * Created by chris on 7/11/2019.
 */
@Component(modules = {AppDatabase.class,ContextModule.class})
public interface AppComponent {

    void inject(MyViewModel viewModel);
}
