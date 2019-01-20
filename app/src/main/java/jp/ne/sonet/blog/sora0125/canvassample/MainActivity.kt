package jp.ne.sonet.blog.sora0125.canvassample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyView(this))
    }

    inner class MyView(context: Context): View(context) {
        private var paint: Paint? = null
        // 描画するラインの太さ
        private val strokeWidth = 20.0f
        private var mDisplay: Display? = null
        private var mPoint: Point? = null

        init {
            paint = Paint()
            mDisplay = this@MainActivity.windowManager.defaultDisplay
            mPoint = Point()
            mDisplay?.getSize(mPoint)
        }

        override fun onDraw(canvas: Canvas?) {
            // 円を描く
            paint?.let {p ->
                p.color = Color.argb(255, 0, 0, 0)
                val screenWidth = mPoint?.x?.toFloat() ?: 0f
                val screenHeight = mPoint?.y?.toFloat()?: 0f
                val num = 4

                // x=40f, y=40f 半径 20f の円を描画
                p.isAntiAlias = false
//                canvas?.drawCircle(screenWidth / 2, screenHeight / 2, 20.0f, p)

                var degreeRoot = 270
                val rad = 180 /15
                // 中心座標をずらす
                canvas?.translate(screenWidth / 2, screenHeight / 2 )
                for (i in 1..16) {
//                    val degree = degreeRoot
                    val radian1 = Math.toRadians(degreeRoot.toDouble()) //degree1 * Math.PI / 180
//                    val radian1 = Math.toRadians(degreeRoot.toDouble()) //degree1 * Math.PI / 180
                    val circley1 = Math.sin(radian1) * (screenWidth / num)
                    val circleX1 = Math.cos(radian1) * (screenWidth / num)
                    p.isAntiAlias = true
//                    canvas?.scale(2F, 2F)
//                    canvas?.rotate(degreeRoot.toFloat())
//                    canvas?.drawCircle(circley1.toFloat(), circleX1.toFloat(), 20.0f, p)
                    p.textSize = 36F
                    canvas?.drawText(i.toString(), circley1.toFloat(), circleX1.toFloat(), p)
//                    canvas?.rotate(12F)
                    degreeRoot += rad
                }
                // アンチエイリアスの円を描画
//                val degree = 35
//                val radian = degree * Math.PI / 180
//                val circley = Math.sin(radian) * (screenWidth / 4) + (screenHeight / num)
//                val circleX = Math.cos(radian) * (screenWidth / 4) + (screenWidth / num)
//
//                p.isAntiAlias = true
//                canvas?.drawCircle(circley.toFloat(), circleX.toFloat(), 20.0f, p)
//
//                // アンチエイリアスの円を描画
//                val degree1 = 30.0
//                val radian1 = Math.toRadians(degree1) //degree1 * Math.PI / 180
//                val circley1 = Math.sin(radian1) * (screenWidth / 4) + (screenHeight / num)
//                val circleX1 = Math.cos(radian1) * (screenWidth / 4) + (screenWidth / num)
//
//                 p.isAntiAlias = true
//                 canvas?.drawCircle(circley1.toFloat(), circleX1.toFloat(), 20.0f, p)
//
//                // アンチエイリアスの円を描画
//                val degree2 = 25.0
//                val radian2 = Math.toRadians(degree2)//degree1 * Math.PI / 180
//                val circley2 = Math.sin(radian2) * (screenWidth / 4) + (screenHeight / num)
//                val circleX2 = Math.cos(radian2) * (screenWidth / 4) + (screenWidth / num)
//
//                p.isAntiAlias = true
//                canvas?.drawCircle(circley2.toFloat(), circleX2.toFloat(), 20.0f, p)
//
//                // 塗りつぶし無しの円を描画
//                p.style = Paint.Style.STROKE
//                p.strokeWidth = 5f
//                canvas?.drawCircle(100f, 100f, 10.0f, p)
            }


//            // 四角形を描く
//            paint?.let {p ->
//                // ペイントする色
//                p.color = Color.argb(255, 255, 0, 255)
//                // ストロークの幅
//                p.strokeWidth = strokeWidth
//                // ストロークのstyle
//                p.style = Paint.Style.STROKE
//
//                canvas?.drawRect(300f, 300f,600f, 600f, p)
//            }
        }
    }
}
