package com.gui.antonio.testefastshop.dagger

import android.content.Context
import com.gui.antonio.testefastshop.view.activity.MainActivity
import com.gui.antonio.testefastshop.view.fragment.MoviesFragment
import dagger.BindsInstance
import dagger.Component

@Component (modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context, @BindsInstance activity: MainActivity): AppComponent
    }

    fun inject(activity: MainActivity)

}