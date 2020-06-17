package com.example.gamisoftcustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var itemRating: ItemRating

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemRating = findViewById(R.id.itemRating)

        itemRating.setSectionName("Обратите внимание: в имени пакета используется схема «обратного DNS», согласно которой доменное имя вашей организации записывается в обратном порядке с присоединением суффиксов дополнительных идентификаторов. Эта схема обеспечивает уникальность имен пакетов и позволяет различать приложения на устройстве и в Google Play. ")
        itemRating.setRatingValue("8800000000000 результатов")
        itemRating.getArrow()
    }
}
