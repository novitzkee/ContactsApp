package pl.farmaprom.trainings.contactsapp.contacts.view

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.farmaprom.trainings.contactsapp.R

class ContactListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val contactLabelTextView: TextView

    val callButton: Button

    init {
        contactLabelTextView = view.findViewById(R.id.contact_label)
        callButton = view.findViewById(R.id.call_button)
    }

}