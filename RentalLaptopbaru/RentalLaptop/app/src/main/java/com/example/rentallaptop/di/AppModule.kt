package com.example.rentallaptop.di

import com.example.rentallaptop.main_ui.account.AccountViewModel
import com.example.rentallaptop.main_ui.browse.BrowseViewModel
import com.example.rentallaptop.main_ui.detail.DetailLaptopViewModel
import com.example.rentallaptop.main_ui.history.HistoryViewModel
import com.example.rentallaptop.main_ui.home.HomeViewModel
import com.example.rentallaptop.main_ui.payment.PaymentViewModel
import com.example.rentallaptop.viewmodel.SignInViewModel
import com.example.rentallaptop.viewmodel.SignUpViewModel
import com.example.rentallaptop.viewmodel.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashScreenViewModel(get()) }
    viewModel { SignInViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { AccountViewModel(get()) }
    viewModel { DetailLaptopViewModel(get()) }
    viewModel { BrowseViewModel() }
    viewModel { HistoryViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { PaymentViewModel(get()) }
}