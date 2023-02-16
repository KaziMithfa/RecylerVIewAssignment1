package com.example.recylerviewassignment1

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),UserAdapter.onItemClickListner {

    private lateinit var userList : ArrayList<User>
    private lateinit var userAdapter : UserAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recylerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        userList = ArrayList()


        userList.add(User(R.drawable.mithfa,"Kazi Mithfa","01837705605","Chanhara","Chanhara",
                        "Chattogram","Chattogram","Bangladesh"))

        userList.add(User(R.drawable.sanjad,"Kazi Sanjad","01837705608","Chanhara","Chanhara",
            "Chattogram","Chattogram","Bangladesh"))

        userList.add(User(R.drawable.bakkar,"Kazi Bakkar","01837705634","Harala","Harala",
            "Chattogram","Chattogram","Bangladesh"))





        userAdapter = UserAdapter(userList,this)
        recyclerView.adapter = userAdapter





    }

    override fun onItemClick(position: Int) {

        val user  = userList[position]
        val userImage = user.userProfileImage
        val userName = user.userName
        val userPhone = user.userPhoneNumber
        val villageName = user.villageName
        val postOfficeName = user.postOfficeName
        val districtName = user.districtName
        val divisionName = user.divisionName
        val countryName = user.countryName



        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.sample_alert_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.GREEN))


        val userImagealert : ImageView = dialog.findViewById(R.id.imageView2)
        val textUserNamealert : TextView = dialog.findViewById(R.id.userNameTextView1)
        val textUserPhonealert : TextView = dialog.findViewById(R.id.userPhoneTextView1)
        val textVillagealert : TextView = dialog.findViewById(R.id.userVillageTextView1)
        val textPostofficealert : TextView = dialog.findViewById(R.id.userPostOfficeTextView1)
        val textDistrictalert : TextView = dialog.findViewById(R.id.userDistrictTextView1)
        val textDivisiontalert : TextView = dialog.findViewById(R.id.userDivisionTextView1)
        val textcountrytalert : TextView = dialog.findViewById(R.id.userCountryTextView1)

        val cancelBtnalert : Button = dialog.findViewById(R.id.closeanccancelBtn)


        userImagealert.setImageResource(userImage)
        textUserNamealert.setText("User Name: "+userName)
        textUserPhonealert.setText("User Phone: "+userPhone)
        textVillagealert.setText("Village Name: : "+villageName)
        textPostofficealert.setText("Post Office Name: "+postOfficeName)
        textDistrictalert.setText("District Name: "+districtName)
        textDivisiontalert.setText("Division Name: "+divisionName)
        textcountrytalert.setText("Country Name: "+countryName)

        cancelBtnalert.setOnClickListener{
            dialog.dismiss()
        }



        dialog.show()



    }
}