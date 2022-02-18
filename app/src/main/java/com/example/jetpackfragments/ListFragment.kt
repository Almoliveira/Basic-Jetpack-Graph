package com.example.jetpackfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.RuntimeException
import androidx.navigation.Navigation;

class ListFragment : Fragment() {

    private lateinit var starSignListener: StarSignListener;

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is StarSignListener) {
            starSignListener = context
        } else {
            throw RuntimeException("Must implement StarSignListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val starSigns = listOf<View>(
            view.findViewById(R.id.aries),
            view.findViewById(R.id.taurus),
            view.findViewById(R.id.cancer),
            view.findViewById(R.id.gemini),
            view.findViewById(R.id.leo),
            view.findViewById(R.id.virgo),
            view.findViewById(R.id.libra),
            view.findViewById(R.id.scorpion),
            view.findViewById(R.id.sagittarius),
            view.findViewById(R.id.capricorn),
            view.findViewById(R.id.aquarius),
            view.findViewById(R.id.pisces)
        )
        starSigns.forEach{ starSign ->
            val fragmentBundle = Bundle()
            fragmentBundle.putInt(STAR_SIGN_ID, starSign.id)
            starSign.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    R.id.star_sign_id_action,
                    fragmentBundle
                )
            )
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

}