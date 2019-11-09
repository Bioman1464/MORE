package bonch.dev.more.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import bonch.dev.more.R
import bonch.dev.more.ui.BottomNavigationViewBehavior
import bonch.dev.more.ui.fragments.BottomNavigationDrawerFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet_card_layout.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottom_app_bar)
        setSupportActionBar(bottomAppBar)

        initView()


    }

    private fun initView() {

        fab.setOnClickListener {
            slideUpDownBottomSheet()
        }

        textViewFacebook.setOnClickListener {
            Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show()
        }
        textViewTwitter.setOnClickListener {
            Toast.makeText(this, "Twitter", Toast.LENGTH_SHORT).show()
        }
        textViewInstagram.setOnClickListener {
            Toast.makeText(this, "Instagram", Toast.LENGTH_SHORT).show()
        }
        textViewLinkedin.setOnClickListener {
            Toast.makeText(this, "Linkedin", Toast.LENGTH_SHORT).show()
        }
        bottomSheetBehavior = BottomSheetBehavior.from<ConstraintLayout>(bottomSheet as ConstraintLayout)
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                if (BottomSheetBehavior.STATE_DRAGGING == newState) {
//                    fab.animate().rotation(180f)
//                } else if (BottomSheetBehavior.STATE_COLLAPSED == newState) {
//                    fab.animate().rotation(180f)
//                }
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        rotateArrowUp()
                        fab.marginTop

                    }
//                    BottomSheetBehavior.STATE_HIDDEN -> {
//
//                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        rotateArrowDown()
                    }
//                    BottomSheetBehavior.STATE_DRAGGING -> {
//                    }
//                    BottomSheetBehavior.STATE_SETTLING -> {
//                    }
                }
            }
        })
    }

    private fun rotateArrowDown() {
        fab.animate().setDuration(150).rotation(180f).start()
    }

    private fun rotateArrowUp() {
        fab.animate().setDuration(150).rotation(0f).start()
    }

    private fun slideUpDownBottomSheet() {
        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            toast("SLIDE UP!")
        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED;
            toast("SLIDE DOWN!")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.app_bar_fav -> toast("PROFILE BTN WAS CLICKED")

            android.R.id.home -> {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
        }

        return true
    }
}
