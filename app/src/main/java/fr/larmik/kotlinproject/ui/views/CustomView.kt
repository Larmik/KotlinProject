package fr.larmik.kotlinproject.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import fr.larmik.kotlinproject.R

class CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                           defStyle: Int = 0, defStyleRes: Int = 0) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.custom_view, this, false)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomView, defStyle, defStyleRes)

        //Extract attributes like
        val title = attributes.getString(R.styleable.CustomView_title)

        //use attributes, then
        attributes.recycle()
    }

}