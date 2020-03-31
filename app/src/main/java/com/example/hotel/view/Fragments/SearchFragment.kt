package com.example.hotel.view.Fragments


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.hotel.R
import com.example.hotel.view.Activities.HomeScreen
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.homescreen_main.*
import kotlin.math.E

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        callHotel.setOnClickListener{

            callHotel()
        }

        search_edit_text.setOnEditorActionListener( object: TextView.OnEditorActionListener{
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {

                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                    actionId == EditorInfo.IME_ACTION_DONE ||
                    actionId == EditorInfo.IME_ACTION_SEND ||
                    event?.action == KeyEvent.ACTION_DOWN &&
                    event?.keyCode == KeyEvent.KEYCODE_ENTER){

                    Toast.makeText(activity!!,"Search Info: ${search_edit_text.text}",Toast.LENGTH_LONG).show()

                    return true
            }
                return false
        }

        })


    }


    fun callHotel(){

        val callLocalNumber = Intent(Intent.ACTION_DIAL)
        callLocalNumber.setData(Uri.parse("tel:${getString(R.string.toll_free_number)}"))
        startActivity(callLocalNumber)
    }

}
