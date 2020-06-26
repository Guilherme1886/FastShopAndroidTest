package com.gui.antonio.testefastshop.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gui.antonio.testefastshop.R
import com.gui.antonio.testefastshop.dagger.AppComponent
import com.gui.antonio.testefastshop.dagger.DaggerAppComponent
import com.gui.antonio.testefastshop.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var component : AppComponent
    @Inject
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        component = DaggerAppComponent.factory().create(this, this)
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}