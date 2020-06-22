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

        itemRating.setSectionName("Рейтинг филиалов Виджет TextView чуть больше содержащегося в нем текста из-за атрибута android:padding=\"24dp\". Этот атрибут приказывает виджету добавить заданный отступ вокруг содержимого при определении размера, чтобы текст вопроса не соприкасался с кнопкой. (Интересуетесь, что это за единицы — dp? Это пикселы, не зависящие от плотности (density-independent pixels), о которых будет рассказано ")
        itemRating.setRatingValue("88 результатов")
    }
}
