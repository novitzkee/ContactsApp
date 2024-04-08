package pl.farmaprom.trainings.contactsapp.contacts.data

import android.content.Context
import pl.farmaprom.trainings.contactsapp.R
import kotlin.random.Random

class ContactListMock(context: Context) : ContactList {

    private val contacts: List<Contact>

    init {
        val random = Random(0x0F0F0F)

        val femaleNames = context.resources.getStringArray(R.array.female_mock_names)
        val femaleSurnames = context.resources.getStringArray(R.array.female_mock_surnames)
        val maleNames = context.resources.getStringArray(R.array.male_mock_names)
        val maleSurnames = context.resources.getStringArray(R.array.male_mock_surnames)

        contacts = sequence {
            while (true) {
                when (random.nextBoolean()) {
                    true -> yield(
                        Contact(
                            femaleNames.pick(random),
                            femaleSurnames.pick(random),
                            randomPhoneNumber(random)
                        )
                    )

                    false -> yield(
                        Contact(
                            maleNames.pick(random),
                            maleSurnames.pick(random),
                            randomPhoneNumber(random)
                        )
                    )
                }
            }
        }.take(30).toList()
    }

    override fun getAllContacts() = contacts
}

fun <T> Array<T>.pick(random: Random): T = this[random.nextInt(this.size)]

fun randomPhoneNumber(random: Random): String =
    (1..9).map { _ -> random.nextInt(9) }.joinToString(separator = "")

