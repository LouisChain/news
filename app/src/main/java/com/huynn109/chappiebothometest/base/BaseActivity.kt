package com.huynn109.chappiebothometest.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.huynn109.chappiebothometest.util.widget.ProgressDialogFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

/**
 * Created by huynn109 on 4/8/19.
 */
abstract class BaseActivity<M : BaseViewModel, B: ViewDataBinding>(clazz : KClass<M>) : AppCompatActivity(), BaseFragment.Callback {

    val getViewModel: M by lazy { getViewModel(clazz) }
    lateinit var viewDataBinding: B
    private lateinit var progressDialog: ProgressDialogFragment

    /**
     * @return layout resource id
     */
    abstract val layoutResId: Int

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract fun getBindingVariable(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        initView(savedInstanceState)
        observerViewModel()
        setupProgressDialog()
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResId)
        viewDataBinding.setVariable(getBindingVariable(), getViewModel)
        viewDataBinding.executePendingBindings()
    }

    private fun setupProgressDialog() {
        progressDialog = ProgressDialogFragment.newInstance()
    }

    fun showProgressDialog() = progressDialog.show(supportFragmentManager, "progressDialog")
    fun hideProgressDialog() = progressDialog.dismiss()

    open fun setupToolbar(toolbar: Toolbar? = null, titleToolbar: Int? = null) {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = titleToolbar?.let { getString(it) }
        }
    }

    open fun initView(savedInstanceState: Bundle?) {}
    open fun observerViewModel() {}

}