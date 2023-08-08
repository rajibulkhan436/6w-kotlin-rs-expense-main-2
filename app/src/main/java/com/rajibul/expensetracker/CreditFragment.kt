package com.rajibul.expensetracker

import android.app.Dialog
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.rajibul.expensetracker.databinding.FragmentCreditBinding
import com.rajibul.expensetracker.roomdatabase.CategoryEntity
import com.rajibul.expensetracker.roomdatabase.ExpenseDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreditFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var binding: FragmentCreditBinding? = null
    var layoutManager:LinearLayoutManager?=null

    private var mainActivity: MainActivity? = null
    private var expenseDatabase: ExpenseDatabase? = null
    var categoriesList = arrayListOf<CategoryEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        mainActivity?.let {
            expenseDatabase = ExpenseDatabase.getDatabase(it)

        }
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreditBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = LinearLayoutManager(mainActivity, LinearLayoutManager.VERTICAL, false)
        getCategory()
        binding?.fabAdd?.setOnClickListener {
            var dialog= Dialog(mainActivity!!)
            dialog?.setContentView(R.layout.category_entry_dialog)
            dialog.show()


            class insertCategory : AsyncTask<Void, Void, Void>(){
                override fun doInBackground(vararg p0: Void?): Void? {
                    expenseDatabase?.expenseDao()?.insertCategory(CategoryEntity(name = "TESTING"))

                    return  null
                }

                override fun onPostExecute(result: Void?) {
                    super.onPostExecute(result)
                    getCategory()
                }
            }
            insertCategory().execute()



        }
    }

    fun getCategory(){
        class getCategory : AsyncTask<Void, Void, Void>(){
            override fun doInBackground(vararg p0: Void?): Void? {
                categoriesList.addAll(expenseDatabase?.expenseDao()?.getCategories() as ArrayList<CategoryEntity>)

                return  null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                getCategory()
            }
        }
        getCategory().execute()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CreditFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreditFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}