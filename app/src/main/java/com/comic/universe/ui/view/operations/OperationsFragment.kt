package com.comic.universe.ui.view.operations

import android.os.Bundle
import com.comic.universe.R
import com.comic.universe.center.BaseFragment
import com.comic.universe.util.OperationStrings
import kotlinx.android.synthetic.main.fragment_operation.*

const val EXPLANATION_USE ="     Explicacion de uso para resolver las operaciones: \n " +
        "    \"10 + 2 * 6\"            ---> 22 \n" +
        "     \"100 * 2 + 12\"          ---> 212 \n" +
        "     \"100 * ( 2 + 12 )\"      ---> 1400 \n" +
        "     \"100 * ( 2 + 12 ) / 14\" ---> 100     "
class OperationsFragment : BaseFragment() {

    override fun onFinishedViewLoad() {
        instructionsForUse.text = EXPLANATION_USE

        btnResolved.setOnClickListener {
            /*val responseOperation = OperationStrings.evaluate(evEvaluation.text.toString())
            val bundle = Bundle()
            bundle.putInt("responseOperation", responseOperation)*/
            navController()!!.navigate(R.id.action_operationsFragment_to_comicFragment/*,bundle*/ )
           // evEvaluation.text.clear()
        }
    }

    override fun fragmentLayout(): Int = R.layout.fragment_operation
}