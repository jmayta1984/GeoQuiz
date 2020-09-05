package pe.edu.upc.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var questions: ArrayList<Question>
    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQuestions()
        setupViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        var question = Question("¿Es Lima la capital de Chile?", false)
        questions.add(question)

        question = Question("¿Es Budapest la capital de Hungría?", true)
        questions.add(question)

    }

    private fun setupViews() {

        showSentence()

        btYes.setOnClickListener {
            validateAnswer(true)
        }

        btNo.setOnClickListener {
            validateAnswer(false)
        }

        btNext.setOnClickListener {
            position++
            showSentence()
        }
    }

    private fun validateAnswer(option: Boolean) {
        if (questions[position].answer == option) {
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showSentence() {
        tvSentence.text = questions[position].sentence
    }

}