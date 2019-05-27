package fr.larmik.kotlinproject.manager

import android.content.Context

class PreferenceManager(private val context: Context) {

    private fun getDefaultSharedPreferences(context: Context) = context.getSharedPreferences(context.packageName + "_preferences",
        Context.MODE_PRIVATE)

    var email: String
        get() = getDefaultSharedPreferences(context).getString(Keys.KEY_LOGIN.key, "")!!
        set(value) = getDefaultSharedPreferences(context).edit().putString(Keys.KEY_LOGIN.key, value).apply()

    //TODO Declare all variables and keys to put in SharedPreferences


    fun clearCache() {
        getDefaultSharedPreferences(context).edit().putString(Keys.KEY_LOGIN.key, null).apply()
    }

    internal enum class Keys constructor(val key: String) {
        KEY_LOGIN("KEY_LOGIN")
    }

}
