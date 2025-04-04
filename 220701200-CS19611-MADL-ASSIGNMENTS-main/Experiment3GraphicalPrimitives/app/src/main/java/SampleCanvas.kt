package com.example.graphicalprimitives

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SampleCanvas @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.setColor(Color.YELLOW)
        canvas.drawPaint(paint)
        paint.setColor(Color.RED)
        canvas.drawCircle(200f, 150f, 100f, paint)
        paint.textSize = 60f
        canvas.drawText("Circle", 125f, 300f, paint)
        paint.setColor(Color.BLACK)
        canvas.drawRect(500f, 100f, 900f, 400f, paint);
        canvas.drawText("Rectangle", 600f, 500f,paint)
        canvas.drawRect()
    }
}