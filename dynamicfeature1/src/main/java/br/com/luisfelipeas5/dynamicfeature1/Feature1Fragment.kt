package br.com.luisfelipeas5.dynamicfeature1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.luisfelipeas5.androidmultimodule.BaseFragment
import kotlinx.android.synthetic.main.activity_dynamic_1_feature.*

class Feature1Fragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_dynamic_1_feature, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btDynamic2.setOnClickListener {
            router.pushFeature2()
        }
    }

}