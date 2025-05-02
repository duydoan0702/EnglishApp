package com.example.learnenglishapp.ui.activity

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.learnenglishapp.R

class ListenAndWriteListActivity : AppCompatActivity() {
    private var isPlaying = false // Biến theo dõi trạng thái phát

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_listen_and_write_list)

        val btnPlayPause = findViewById<ImageButton>(R.id.btnPlayPause)

        // Xử lý sự kiện khi ấn vào nút
        btnPlayPause.setOnClickListener {
            isPlaying = !isPlaying  // Chuyển đổi trạng thái

            // Thay đổi icon dựa trên trạng thái
            if (isPlaying) {
                btnPlayPause.setImageResource(R.drawable.ic_pause)  // Nếu đang phát, hiển thị ic_pause
                // Thêm logic phát âm thanh tại đây
            } else {
                btnPlayPause.setImageResource(R.drawable.ic_play)   // Nếu tạm dừng, hiển thị ic_play
                // Thêm logic tạm dừng âm thanh tại đây
            }
        }
    }
}
