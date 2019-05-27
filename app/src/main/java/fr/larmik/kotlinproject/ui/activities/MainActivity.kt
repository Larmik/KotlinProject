package fr.larmik.kotlinproject.ui.activities

import android.os.Bundle
import android.view.View
import fr.larmik.kotlinproject.tasks.GetPostByIdTask
import fr.larmik.kotlinproject.tasks.GetPostsTask
import fr.larmik.kotlinproject.R
import fr.larmik.kotlinproject.core.abstractui.AbstractActivity
import fr.larmik.kotlinproject.core.retrofit.RequestCallback
import fr.larmik.kotlinproject.models.DefaultResponse
import fr.larmik.kotlinproject.models.Post
import fr.larmik.kotlinproject.models.User
import fr.larmik.kotlinproject.tasks.HomeTask
import fr.larmik.kotlinproject.tasks.RegisterTask
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(View.OnClickListener {
            GetPostsTask().execute(object: RequestCallback<List<Post>>() {
                override fun onSuccess(result: List<Post>) {
                    print(result)
                }


            })
        })
        button.setOnClickListener(View.OnClickListener {
            /*RegisterTask(
                User(editText.text.toString(), editText2.text.toString(),
                    editText3.text.toString(), editText4.text.toString())
            ).execute(object :RequestCallback<User>() {
                override fun onSuccess(result: User) {
                    print(result)
                }
            })*/
            HomeTask().execute(object : RequestCallback<DefaultResponse>() {
                override fun onSuccess(result: DefaultResponse) {
                    print("Success")
                }
            })
        })
    }
}
