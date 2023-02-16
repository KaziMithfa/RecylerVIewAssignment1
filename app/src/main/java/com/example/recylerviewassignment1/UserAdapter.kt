package com.example.recylerviewassignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val userList : ArrayList<User>,val listner : onItemClickListner) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {




    inner class UserViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{




        val imageView : ImageView = itemView.findViewById(R.id.imageView1)
        val nameTextView : TextView = itemView.findViewById(R.id.userNameTextView)
        val userPhoneTextView : TextView = itemView.findViewById(R.id.userPhoneTextView)
        val detailsIcon : ImageView = itemView.findViewById(R.id.detailsImageView)


        init {
            detailsIcon.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition

            if(position != RecyclerView.NO_POSITION){
                listner.onItemClick(position)
            }


        }


    }

    interface onItemClickListner{

        fun onItemClick(position : Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_layout,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.imageView.setImageResource(user.userProfileImage)
        holder.nameTextView.setText("Name : "+user.userName)
        holder.userPhoneTextView.setText("Phone: "+user.userPhoneNumber)

    }

    override fun getItemCount(): Int {
        return userList.size
    }
}