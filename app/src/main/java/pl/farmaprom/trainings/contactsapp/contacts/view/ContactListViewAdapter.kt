package pl.farmaprom.trainings.contactsapp.contacts.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.farmaprom.trainings.contactsapp.R
import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import pl.farmaprom.trainings.contactsapp.contacts.data.ContactList

class ContactListViewAdapter(
    private val contactList: ContactList,
    private val onContactButtonClick: (Contact) -> Unit
) :
    RecyclerView.Adapter<ContactListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactListViewHolder(view)
    }

    override fun getItemCount(): Int = contactList.getAllContacts().size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
        val contact = contactList.getAllContacts()[position]
        holder.contactLabelTextView.text = "${contact.name} ${contact.surname}"
        holder.callButton.setOnClickListener { onContactButtonClick(contact) }
    }
}