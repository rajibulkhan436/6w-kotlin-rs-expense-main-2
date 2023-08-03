package com.rajibul.expensetracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.rajibul.expensetracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController= findNavController(R.id.navHost)
        binding.bottomView.setOnItemSelectedListener {
            if(it.itemId==R.id.home){
                navController.navigate(R.id.homeFragment)
            }
            else if(it.itemId==R.id.input){
                navController.navigate(R.id.inputFragment)
            }else if(it.itemId==R.id.calculator){
                navController.navigate(R.id.calculatorFragment)
            }else if (it.itemId==R.id.history){
                navController.navigate(R.id.historyFragment)
            }
            return@setOnItemSelectedListener true
        }
    }
}