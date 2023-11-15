package com.example.tackapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.tackapp.databinding.FragmentHomeBinding
import com.example.tackapp.databinding.ItemAppBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val taskList = arrayListOf(
        TaskModel("Brade",+799987989),
        TaskModel("Rock",+678667868),
        TaskModel("joy",+890080009),
        TaskModel("Roy",+89977009),
        TaskModel("Ruby",+854754009),
        TaskModel("Mark",+846547009),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = TaskAdapter(taskList)
        binding.rvTack.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    inner class TaskAdapter(private val taskList: List<TaskModel>) :
        RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                ItemAppBinding.inflate
                    (LayoutInflater.from(parent.context), parent, false)
            )
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(taskList[position])
        }
        override fun getItemCount(): Int {
            return taskList.size
        }
        inner class ViewHolder(private val binding: ItemAppBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(task: TaskModel) {
                binding.tvTack.text = task.test
                binding.number.text = task.number.toString()
            }
        }
    }
}
