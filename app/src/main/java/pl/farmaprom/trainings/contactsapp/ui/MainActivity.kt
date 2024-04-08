package pl.farmaprom.trainings.contactsapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.farmaprom.trainings.contactsapp.R
import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import pl.farmaprom.trainings.contactsapp.contacts.data.ContactListMock
import pl.farmaprom.trainings.contactsapp.contacts.view.ContactListViewAdapter
import pl.farmaprom.trainings.contactsapp.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView()
        createContactList()
    }

    private fun bindView() {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun createContactList() {
        val dataMock = ContactListMock(applicationContext)
        val adapter = ContactListViewAdapter(dataMock, ::dialContact)
        val list = findViewById<RecyclerView>(R.id.contact_list)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
    }

    private fun dialContact(contact: Contact) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${contact.phone}"));
        startActivity(intent)
    }
}
