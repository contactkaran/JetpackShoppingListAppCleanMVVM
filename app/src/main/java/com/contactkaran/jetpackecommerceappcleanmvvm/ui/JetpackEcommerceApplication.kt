package com.contactkaran.jetpackecommerceappcleanmvvm.ui

import android.app.Application

class JetpackEcommerceApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}