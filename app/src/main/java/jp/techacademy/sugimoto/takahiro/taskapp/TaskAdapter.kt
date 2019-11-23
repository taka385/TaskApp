package jp.techacademy.sugimoto.takahiro.taskapp

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter(context: Context): BaseAdapter() {
    private val mLayoutInflater: LayoutInflater = LayoutInflater.from(context)
    var taskList = mutableListOf<Task>()


    override fun getCount(): Int {
        return taskList.size
    }

    override fun getItem(position: Int): Any {
        return taskList[position]
    }

    override fun getItemId(position: Int): Long {
        return taskList[position].id.toLong()

    }
    //TaskApp 一覧画面　テキスト
    override fun getView(position: Int, convertView: View?, perent: ViewGroup?): View {
        val view: View = convertView ?: mLayoutInflater.inflate(R.layout.simple_list_item_2, null)

        val textView1 = view.findViewById<TextView>(R.id.text1)
        val textView2 = view.findViewById<TextView>(R.id.text2)


        textView1.text = "[${taskList[position].category}]${taskList[position].title}"

        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.JAPANESE)
        val date = taskList[position].date
        textView2.text =simpleDateFormat.format(date)


        return view



    }
}