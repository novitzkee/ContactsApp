package pl.farmaprom.trainings.contactsapp.contacts.data

import com.google.android.gms.maps.model.LatLng
import org.joda.time.DateTime

data class Contact(
    val name: String = "",
    val surname: String = "",
    val phone: String = ""
)
