package br.com.luisfelipeas5.dynamicfeature2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.luisfelipeas5.androidmultimodule.BaseFragment

class Feature2Fragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_dynamic_feature2, container, false)
    }

}
