package kr.mad.circularbar

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler;
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val handler = Handler()

    private var progressBar: ProgressBar? = null
    private var progressText: TextView? = null

    internal var progressTmp = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        progressText = findViewById<TextView>(R.id.progress_text)

        progressBar!!.max = 45
        val progress = 41;

        progressText!!.text = progress.toString() + " kWh"

        /* 애니메이션 1 */
        ObjectAnimator.ofInt(progressBar, "progress", 0, progress).apply {
           duration = 1500
           start()
        }

        /* 애니메이션 2
        Thread {
           while (progressTmp < progress) {
               progressTmp += 1
               handler.post {
                   progressBar!!.progress = progressTmp
               }
               try {
                   Thread.sleep(10)
               }
               catch (e: InterruptedException) {
                   e.printStackTrace()
               }
           }
        }.start()*/
}
}