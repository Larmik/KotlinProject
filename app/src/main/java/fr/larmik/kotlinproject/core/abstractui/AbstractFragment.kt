package fr.larmik.kotlinproject.core.abstractui

import androidx.fragment.app.Fragment

abstract class AbstractFragment : Fragment() {

    val activity: AbstractActivity?
        get() = super.getActivity() as AbstractActivity?

    fun finishActivity() {
        activity!!.finish()
    }

    //TODO implement common methods to all fragments

}