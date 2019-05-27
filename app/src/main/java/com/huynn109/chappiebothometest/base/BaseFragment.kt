package com.huynn109.chappiebothometest.base

import android.content.Context
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass
import androidx.annotation.LayoutRes
import org.koin.androidx.viewmodel.ext.android.getViewModel
import android.os.Bundle
import androidx.annotation.Nullable
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.huynn109.chappiebothometest.util.extension.inflateLayout
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


/**
 * Created by huynn109 on 2019-05-23.
 */

abstract class BaseFragment<M : BaseViewModel, B: ViewDataBinding>(clazz: KClass<M>) : Fragment() {

    val getViewModel: M by lazy { getViewModel(clazz) }
    var currentActivity: BaseActivity<M, B>? = null
    var viewDataBinding: B? = null
    private var mRootView: View? = null

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract fun getBindingVariable(): Int

    @Suppress("UNCHECKED_CAST")
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            val activity = context as BaseActivity<M, B>
            this.currentActivity = activity
            activity.onFragmentAttached()
        }
    }


    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        context?.inflateLayout(getLayoutId(), container, false)
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mRootView = viewDataBinding?.root
        return mRootView
    }

    override fun onViewCreated(@NonNull view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding?.setVariable(getBindingVariable(), getViewModel)
        viewDataBinding?.lifecycleOwner = this
        viewDataBinding?.executePendingBindings()
    }


    override fun onDetach() {
        currentActivity?.onFragmentAttached()
        currentActivity = null
        super.onDetach()
    }

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}

