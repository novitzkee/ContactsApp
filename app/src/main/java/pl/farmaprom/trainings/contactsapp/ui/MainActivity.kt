package pl.farmaprom.trainings.contactsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.farmaprom.trainings.contactsapp.R
import pl.farmaprom.trainings.contactsapp.contacts.data.ContactListMock
import pl.farmaprom.trainings.contactsapp.contacts.view.ContactListViewAdapter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createContactList()
    }

    private fun createContactList() {
        val dataMock = ContactListMock(applicationContext)
        val adapter = ContactListViewAdapter(dataMock, {})
        val list = findViewById<RecyclerView>(R.id.contact_list)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
    }
}
