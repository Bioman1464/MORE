package bonch.dev.more.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bonch.dev.more.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottomsheet.*
import org.jetbrains.anko.toast

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottomsheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            // Bottom Navigation Drawer menu item clicks
            when (menuItem!!.itemId) {
                R.id.nav1 -> context!!.toast("getString(R.string.nav1_clicked)")
                R.id.nav2 -> context!!.toast("getString(R.string.nav2_clicked)")
                R.id.nav3 -> context!!.toast("getString(R.string.nav3_clicked)")
            }
            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here
            true
        }
    }




}
