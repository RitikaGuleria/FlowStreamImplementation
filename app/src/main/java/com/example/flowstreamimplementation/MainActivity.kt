package com.example.flowstreamimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val job=
            GlobalScope.launch {
            val data : Flow<Int> = producer()
            //consumer consumes here, if the below will be commented,producer will automaticallly not
            //produce data in this case- means without collect at consumer end, producer willn't produce.
            data.collect()
            {
                Log.d("consumer-1",it.toString())
            }
        }
//        GlobalScope.launch {
//            delay(5500)
//            job.cancel()
//        }
        GlobalScope.launch {
            val data : Flow<Int> = producer()
            //consumer consumes here, if the below will be commented,producer will automaticallly not
            //produce data in this case- means without collect at consumer end, producer willn't produce.
            data.collect()
            {
                //if I add delay to it
                delay(2500)
                Log.d("consumer-2",it.toString())
            }

    }
    }
    //flow automatically create coroutine scope for us
    fun producer()= flow<Int> {
        val list = listOf(1,2,3,4,5,6,7,8,9,10)
        list.forEach{
            delay(1000)
            emit(it)
        }
    }

}